// Generated from de/cherry/flang/Flang.g4 by ANTLR 4.2
package de.cherry.flang;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlangParser}.
 */
public interface FlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlangParser#ParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(@NotNull FlangParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#ParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(@NotNull FlangParser.ParenthesizedExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(@NotNull FlangParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(@NotNull FlangParser.IfBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#AdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(@NotNull FlangParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#AdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(@NotNull FlangParser.AdditiveExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#RelationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(@NotNull FlangParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#RelationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(@NotNull FlangParser.RelationalExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void enterVariableDef(@NotNull FlangParser.VariableDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void exitVariableDef(@NotNull FlangParser.VariableDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#LogicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(@NotNull FlangParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#LogicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(@NotNull FlangParser.LogicalAndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#callAccess}.
	 * @param ctx the parse tree
	 */
	void enterCallAccess(@NotNull FlangParser.CallAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#callAccess}.
	 * @param ctx the parse tree
	 */
	void exitCallAccess(@NotNull FlangParser.CallAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(@NotNull FlangParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(@NotNull FlangParser.WhileBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#IntExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpression(@NotNull FlangParser.IntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#IntExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpression(@NotNull FlangParser.IntExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#LogicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(@NotNull FlangParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#LogicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(@NotNull FlangParser.LogicalOrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#NotExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull FlangParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#NotExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull FlangParser.NotExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull FlangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull FlangParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull FlangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull FlangParser.ReturnStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(@NotNull FlangParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(@NotNull FlangParser.ExpressionSequenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#BoolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(@NotNull FlangParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#BoolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(@NotNull FlangParser.BoolExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#IdentifierExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(@NotNull FlangParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#IdentifierExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(@NotNull FlangParser.IdentifierExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#ThisExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(@NotNull FlangParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#ThisExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(@NotNull FlangParser.ThisExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull FlangParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull FlangParser.FunctionDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#StringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(@NotNull FlangParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#StringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(@NotNull FlangParser.StringExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull FlangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull FlangParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull FlangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull FlangParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#EqualityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(@NotNull FlangParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#EqualityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(@NotNull FlangParser.EqualityExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#MultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(@NotNull FlangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#MultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(@NotNull FlangParser.MultiplicativeExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FlangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull FlangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull FlangParser.AssignContext ctx);
}