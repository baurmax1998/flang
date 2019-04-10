// Generated from de/cherry/flang/Flang.g4 by ANTLR 4.7.1
package de.cherry.flang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlangParser}.
 */
public interface FlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlangParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(FlangParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(FlangParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FlangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FlangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FlangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FlangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FlangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FlangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(FlangParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(FlangParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(FlangParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(FlangParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(FlangParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(FlangParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAssertFunctionCall(FlangParser.AssertFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAssertFunctionCall(FlangParser.AssertFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSizeFunctionCall(FlangParser.SizeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link FlangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSizeFunctionCall(FlangParser.SizeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(FlangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(FlangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(FlangParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(FlangParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(FlangParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(FlangParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(FlangParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(FlangParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(FlangParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(FlangParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(FlangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(FlangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(FlangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(FlangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(FlangParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(FlangParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(FlangParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(FlangParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(FlangParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(FlangParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(FlangParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(FlangParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(FlangParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(FlangParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(FlangParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(FlangParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(FlangParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(FlangParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(FlangParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(FlangParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(FlangParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(FlangParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(FlangParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(FlangParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(FlangParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(FlangParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(FlangParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(FlangParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(FlangParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(FlangParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(FlangParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(FlangParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(FlangParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(FlangParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(FlangParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(FlangParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(FlangParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(FlangParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(FlangParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(FlangParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(FlangParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(FlangParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(FlangParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(FlangParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(FlangParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(FlangParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(FlangParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link FlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(FlangParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(FlangParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(FlangParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlangParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(FlangParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(FlangParser.IndexesContext ctx);
}