package de.cherry.flang;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends FlangBaseVisitor<FlangValue> {

  private static ReturnValue returnValue = new ReturnValue();
  private Scope scope;
  private Map<String, Function> functions;

  public EvalVisitor(Scope scope, Map<String, Function> functions) {
    this.scope = scope;
    this.functions = functions;
  }

  // functionDecl
  @Override
  public FlangValue visitFunctionDecl(FlangParser.FunctionDeclContext ctx) {
    return FlangValue.VOID;
  }

  // list: '[' exprList? ']'
  @Override
  public FlangValue visitList(FlangParser.ListContext ctx) {
    List<FlangValue> list = new ArrayList<>();
    if (ctx.exprList() != null) {
      for(FlangParser.ExpressionContext ex: ctx.exprList().expression()) {
        list.add(this.visit(ex));
      }
    }
    return new FlangValue(list);
  }


  // '-' expression                           #unaryMinusExpression
  @Override
  public FlangValue visitUnaryMinusExpression(FlangParser.UnaryMinusExpressionContext ctx) {
    FlangValue v = this.visit(ctx.expression());
    if (!v.isNumber()) {
      throw new EvalException(ctx);
    }
    return new FlangValue(-1 * v.asDouble());
  }

  // '!' expression                           #notExpression
  @Override
  public FlangValue visitNotExpression(FlangParser.NotExpressionContext ctx) {
    FlangValue v = this.visit(ctx.expression());
    if(!v.isBoolean()) {
      throw new EvalException(ctx);
    }
    return new FlangValue(!v.asBoolean());
  }

  // expression '^' expression                #powerExpression
  @Override
  public FlangValue visitPowerExpression(FlangParser.PowerExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(Math.pow(lhs.asDouble(), rhs.asDouble()));
    }
    throw new EvalException(ctx);
  }

  // expression op=( '*' | '/' | '%' ) expression         #multExpression
  @Override
  public FlangValue visitMultExpression(FlangParser.MultExpressionContext ctx) {
    switch (ctx.op.getType()) {
      case FlangLexer.Multiply:
        return multiply(ctx);
      case FlangLexer.Divide:
        return divide(ctx);
      case FlangLexer.Modulus:
        return modulus(ctx);
      default:
        throw new RuntimeException("unknown operator type: " + ctx.op.getType());
    }
  }

  // expression op=( '+' | '-' ) expression               #addExpression
  @Override
  public FlangValue visitAddExpression(FlangParser.AddExpressionContext ctx) {
    switch (ctx.op.getType()) {
      case FlangLexer.Add:
        return add(ctx);
      case FlangLexer.Subtract:
        return subtract(ctx);
      default:
        throw new RuntimeException("unknown operator type: " + ctx.op.getType());
    }
  }

  // expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
  @Override
  public FlangValue visitCompExpression(FlangParser.CompExpressionContext ctx) {
    switch (ctx.op.getType()) {
      case FlangLexer.LT:
        return lt(ctx);
      case FlangLexer.LTEquals:
        return ltEq(ctx);
      case FlangLexer.GT:
        return gt(ctx);
      case FlangLexer.GTEquals:
        return gtEq(ctx);
      default:
        throw new RuntimeException("unknown operator type: " + ctx.op.getType());
    }
  }

  // expression op=( '==' | '!=' ) expression             #eqExpression
  @Override
  public FlangValue visitEqExpression(FlangParser.EqExpressionContext ctx) {
    switch (ctx.op.getType()) {
      case FlangLexer.Equals:
        return eq(ctx);
      case FlangLexer.NEquals:
        return nEq(ctx);
      default:
        throw new RuntimeException("unknown operator type: " + ctx.op.getType());
    }
  }

  public FlangValue multiply(FlangParser.MultExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if(lhs == null || rhs == null) {
      System.err.println("lhs "+ lhs+ " rhs "+rhs);
      throw new EvalException(ctx);
    }

    // number * number
    if(lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() * rhs.asDouble());
    }

    // string * number
    if(lhs.isString() && rhs.isNumber()) {
      StringBuilder str = new StringBuilder();
      int stop = rhs.asDouble().intValue();
      for(int i = 0; i < stop; i++) {
        str.append(lhs.asString());
      }
      return new FlangValue(str.toString());
    }

    // list * number
    if(lhs.isList() && rhs.isNumber()) {
      List<FlangValue> total = new ArrayList<>();
      int stop = rhs.asDouble().intValue();
      for(int i = 0; i < stop; i++) {
        total.addAll(lhs.asList());
      }
      return new FlangValue(total);
    }

    throw new EvalException(ctx);
  }

  private FlangValue divide(FlangParser.MultExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() / rhs.asDouble());
    }
    throw new EvalException(ctx);
  }

  private FlangValue modulus(FlangParser.MultExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() % rhs.asDouble());
    }
    throw new EvalException(ctx);
  }

  private FlangValue add(FlangParser.AddExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));

    if(lhs == null || rhs == null) {
      throw new EvalException(ctx);
    }

    // number + number
    if(lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() + rhs.asDouble());
    }

    // list + any
    if(lhs.isList()) {
      List<FlangValue> list = lhs.asList();
      list.add(rhs);
      return new FlangValue(list);
    }

    // string + any
    if(lhs.isString()) {
      return new FlangValue(lhs.asString() + "" + rhs.toString());
    }

    // any + string
    if(rhs.isString()) {
      return new FlangValue(lhs.toString() + "" + rhs.asString());
    }

    return new FlangValue(lhs.toString() + rhs.toString());
  }

  private FlangValue subtract(FlangParser.AddExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() - rhs.asDouble());
    }
    if (lhs.isList()) {
      List<FlangValue> list = lhs.asList();
      list.remove(rhs);
      return new FlangValue(list);
    }
    throw new EvalException(ctx);
  }

  private FlangValue gtEq(FlangParser.CompExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() >= rhs.asDouble());
    }
    if(lhs.isString() && rhs.isString()) {
      return new FlangValue(lhs.asString().compareTo(rhs.asString()) >= 0);
    }
    throw new EvalException(ctx);
  }

  private FlangValue ltEq(FlangParser.CompExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() <= rhs.asDouble());
    }
    if(lhs.isString() && rhs.isString()) {
      return new FlangValue(lhs.asString().compareTo(rhs.asString()) <= 0);
    }
    throw new EvalException(ctx);
  }

  private FlangValue gt(FlangParser.CompExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() > rhs.asDouble());
    }
    if(lhs.isString() && rhs.isString()) {
      return new FlangValue(lhs.asString().compareTo(rhs.asString()) > 0);
    }
    throw new EvalException(ctx);
  }

  private FlangValue lt(FlangParser.CompExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs.isNumber() && rhs.isNumber()) {
      return new FlangValue(lhs.asDouble() < rhs.asDouble());
    }
    if(lhs.isString() && rhs.isString()) {
      return new FlangValue(lhs.asString().compareTo(rhs.asString()) < 0);
    }
    throw new EvalException(ctx);
  }

  private FlangValue eq(FlangParser.EqExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    if (lhs == null) {
      throw new EvalException(ctx);
    }
    return new FlangValue(lhs.equals(rhs));
  }

  private FlangValue nEq(FlangParser.EqExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));
    return new FlangValue(!lhs.equals(rhs));
  }

  // expression '&&' expression               #andExpression
  @Override
  public FlangValue visitAndExpression(FlangParser.AndExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));

    if(!lhs.isBoolean() || !rhs.isBoolean()) {
      throw new EvalException(ctx);
    }
    return new FlangValue(lhs.asBoolean() && rhs.asBoolean());
  }

  // expression '||' expression               #orExpression
  @Override
  public FlangValue visitOrExpression(FlangParser.OrExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));

    if(!lhs.isBoolean() || !rhs.isBoolean()) {
      throw new EvalException(ctx);
    }
    return new FlangValue(lhs.asBoolean() || rhs.asBoolean());
  }

  // expression '?' expression ':' expression #ternaryExpression
  @Override
  public FlangValue visitTernaryExpression(FlangParser.TernaryExpressionContext ctx) {
    FlangValue condition = this.visit(ctx.expression(0));
    if (condition.asBoolean()) {
      return new FlangValue(this.visit(ctx.expression(1)));
    } else {
      return new FlangValue(this.visit(ctx.expression(2)));
    }
  }

  // expression In expression                 #inExpression
  @Override
  public FlangValue visitInExpression(FlangParser.InExpressionContext ctx) {
    FlangValue lhs = this.visit(ctx.expression(0));
    FlangValue rhs = this.visit(ctx.expression(1));

    if (rhs.isList()) {
      for(FlangValue val: rhs.asList()) {
        if (val.equals(lhs)) {
          return new FlangValue(true);
        }
      }
      return new FlangValue(false);
    }
    throw new EvalException(ctx);
  }

  // Number                                   #numberExpression
  @Override
  public FlangValue visitNumberExpression(FlangParser.NumberExpressionContext ctx) {
    return new FlangValue(Double.valueOf(ctx.getText()));
  }

  // Bool                                     #boolExpression
  @Override
  public FlangValue visitBoolExpression(FlangParser.BoolExpressionContext ctx) {
    return new FlangValue(Boolean.valueOf(ctx.getText()));
  }

  // Null                                     #nullExpression
  @Override
  public FlangValue visitNullExpression(FlangParser.NullExpressionContext ctx) {
    return FlangValue.NULL;
  }

  private FlangValue resolveIndexes(FlangValue val, List<FlangParser.ExpressionContext> indexes) {
    for (FlangParser.ExpressionContext ec: indexes) {
      FlangValue idx = this.visit(ec);
      if (!idx.isNumber() || (!val.isList() && !val.isString()) ) {
        throw new EvalException("Problem resolving indexes on "+val+" at "+idx, ec);
      }
      int i = idx.asDouble().intValue();
      if (val.isString()) {
        val = new FlangValue(val.asString().substring(i, i+1));
      } else {
        val = val.asList().get(i);
      }
    }
    return val;
  }

  private void setAtIndex(ParserRuleContext ctx, List<FlangParser.ExpressionContext> indexes, FlangValue val, FlangValue newVal) {
    if (!val.isList()) {
      throw new EvalException(ctx);
    }
    for (int i = 0; i < indexes.size() - 1; i++) {
      FlangValue idx = this.visit(indexes.get(i));
      if (!idx.isNumber()) {
        throw new EvalException(ctx);
      }
      val = val.asList().get(idx.asDouble().intValue());
    }
    FlangValue idx = this.visit(indexes.get(indexes.size() - 1));
    if (!idx.isNumber()) {
      throw new EvalException(ctx);
    }
    val.asList().set(idx.asDouble().intValue(), newVal);
  }

  // functionCall indexes?                    #functionCallExpression
  @Override
  public FlangValue visitFunctionCallExpression(FlangParser.FunctionCallExpressionContext ctx) {
    FlangValue val = this.visit(ctx.functionCall());
    if (ctx.indexes() != null) {
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      val = resolveIndexes(val, exps);
    }
    return val;
  }

  // list indexes?                            #listExpression
  @Override
  public FlangValue visitListExpression(FlangParser.ListExpressionContext ctx) {
    FlangValue val = this.visit(ctx.list());
    if (ctx.indexes() != null) {
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      val = resolveIndexes(val, exps);
    }
    return val;
  }

  // Identifier indexes?                      #identifierExpression
  @Override
  public FlangValue visitIdentifierExpression(FlangParser.IdentifierExpressionContext ctx) {
    String id = ctx.Identifier().getText();
    FlangValue val = scope.resolve(id);

    if (ctx.indexes() != null) {
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      val = resolveIndexes(val, exps);
    }
    return val;
  }

  // String indexes?                          #stringExpression
  @Override
  public FlangValue visitStringExpression(FlangParser.StringExpressionContext ctx) {
    String text = ctx.getText();
    text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
    FlangValue val = new FlangValue(text);
    if (ctx.indexes() != null) {
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      val = resolveIndexes(val, exps);
    }
    return val;
  }

  // '(' expression ')' indexes?              #expressionExpression
  @Override
  public FlangValue visitExpressionExpression(FlangParser.ExpressionExpressionContext ctx) {
    FlangValue val = this.visit(ctx.expression());
    if (ctx.indexes() != null) {
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      val = resolveIndexes(val, exps);
    }
    return val;
  }

  // Input '(' String? ')'                    #inputExpression
  @Override
  public FlangValue visitInputExpression(FlangParser.InputExpressionContext ctx) {
    TerminalNode inputString = ctx.String();
    try {
      if (inputString != null) {
        String text = inputString.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        return new FlangValue(new String(Files.readAllBytes(Paths.get(text))));
      } else {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        return new FlangValue(buffer.readLine());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  // assignment
  // : Identifier indexes? '=' expression
  // ;
  @Override
  public FlangValue visitAssignment(FlangParser.AssignmentContext ctx) {
    FlangValue newVal = this.visit(ctx.expression());
    if (ctx.indexes() != null) {
      FlangValue val = scope.resolve(ctx.Identifier().getText());
      List<FlangParser.ExpressionContext> exps = ctx.indexes().expression();
      setAtIndex(ctx, exps, val, newVal);
    } else {
      String id = ctx.Identifier().getText();
      scope.assign(id, newVal);
    }
    return FlangValue.VOID;
  }

  // Identifier '(' exprList? ')' #identifierFunctionCall
  @Override
  public FlangValue visitIdentifierFunctionCall(FlangParser.IdentifierFunctionCallContext ctx) {
    List<FlangParser.ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<FlangParser.ExpressionContext>();
    String id = ctx.Identifier().getText() + params.size();
    Function function;
    if ((function = functions.get(id)) != null) {
      return function.invoke(params, functions, scope);
    }
    throw new EvalException(ctx);
  }

  // Println '(' expression? ')'  #printlnFunctionCall
  @Override
  public FlangValue visitPrintlnFunctionCall(FlangParser.PrintlnFunctionCallContext ctx) {
    System.out.println(this.visit(ctx.expression()));
    return FlangValue.VOID;
  }

  // Print '(' expression ')'     #printFunctionCall
  @Override
  public FlangValue visitPrintFunctionCall(FlangParser.PrintFunctionCallContext ctx) {
    System.out.print(this.visit(ctx.expression()));
    return FlangValue.VOID;
  }

  // Assert '(' expression ')'    #assertFunctionCall
  @Override
  public FlangValue visitAssertFunctionCall(FlangParser.AssertFunctionCallContext ctx) {
    FlangValue value = this.visit(ctx.expression());

    if(!value.isBoolean()) {
      throw new EvalException(ctx);
    }

    if(!value.asBoolean()) {
      throw new AssertionError("Failed Assertion "+ctx.expression().getText()+" line:"+ctx.start.getLine());
    }

    return FlangValue.VOID;
  }

  // Size '(' expression ')'      #sizeFunctionCall
  @Override
  public FlangValue visitSizeFunctionCall(FlangParser.SizeFunctionCallContext ctx) {
    FlangValue value = this.visit(ctx.expression());

    if(value.isString()) {
      return new FlangValue(value.asString().length());
    }

    if(value.isList()) {
      return new FlangValue(value.asList().size());
    }

    throw new EvalException(ctx);
  }

  // ifStatement
  //  : ifStat elseIfStat* elseStat? End
  //  ;
  //
  // ifStat
  //  : If expression Do block
  //  ;
  //
  // elseIfStat
  //  : Else If expression Do block
  //  ;
  //
  // elseStat
  //  : Else Do block
  //  ;
  @Override
  public FlangValue visitIfStatement(FlangParser.IfStatementContext ctx) {

    // if ...
    if(this.visit(ctx.ifStat().expression()).asBoolean()) {
      return this.visit(ctx.ifStat().block());
    }

    // else if ...
    for(int i = 0; i < ctx.elseIfStat().size(); i++) {
      if(this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
        return this.visit(ctx.elseIfStat(i).block());
      }
    }

    // else ...
    if(ctx.elseStat() != null) {
      return this.visit(ctx.elseStat().block());
    }

    return FlangValue.VOID;
  }

  // block
  // : (statement | functionDecl)* (Return expression)?
  // ;
  @Override
  public FlangValue visitBlock(FlangParser.BlockContext ctx) {

    scope = new Scope(scope); // create new local scope
    for (FlangParser.StatementContext sx: ctx.statement()) {
      this.visit(sx);
    }
    FlangParser.ExpressionContext ex;
    if ((ex = ctx.expression()) != null) {
      returnValue.value = this.visit(ex);
      scope = scope.parent();
      throw returnValue;
    }
    scope = scope.parent();
    return FlangValue.VOID;
  }

  // forStatement
  // : For Identifier '=' expression To expression OBrace block CBrace
  // ;
  @Override
  public FlangValue visitForStatement(FlangParser.ForStatementContext ctx) {
    int start = this.visit(ctx.expression(0)).asDouble().intValue();
    int stop = this.visit(ctx.expression(1)).asDouble().intValue();
    for(int i = start; i <= stop; i++) {
      scope.assign(ctx.Identifier().getText(), new FlangValue(i));
      FlangValue returnValue = this.visit(ctx.block());
      if(returnValue != FlangValue.VOID) {
        return returnValue;
      }
    }
    return FlangValue.VOID;
  }

  // whileStatement
  // : While expression OBrace block CBrace
  // ;
  @Override
  public FlangValue visitWhileStatement(FlangParser.WhileStatementContext ctx) {
    while( this.visit(ctx.expression()).asBoolean() ) {
      FlangValue returnValue = this.visit(ctx.block());
      if (returnValue != FlangValue.VOID) {
        return returnValue;
      }
    }
    return FlangValue.VOID;
  }


}
