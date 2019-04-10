package de.cherry.flang;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolVisitor extends FlangBaseVisitor<FlangValue> {
  private Map<String, Function> functions;

  SymbolVisitor(Map<String, Function> functions) {
    this.functions = functions;
  }

  @Override
  public FlangValue visitFunctionDecl(FlangParser.FunctionDeclContext ctx) {
    List<TerminalNode> params = ctx.idList() != null ? ctx.idList().Identifier() : new ArrayList<TerminalNode>();
    ParseTree block = ctx.block();
    String id = ctx.Identifier().getText() + params.size();
    functions.put(id, new Function(params, block));
    return FlangValue.VOID;
  }

}
