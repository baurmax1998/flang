// Generated from de/cherry/game/Field.g4 by ANTLR 4.2
package de.cherry.game;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FieldParser}.
 */
public interface FieldListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FieldParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull FieldParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link FieldParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull FieldParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link FieldParser#burial}.
	 * @param ctx the parse tree
	 */
	void enterBurial(@NotNull FieldParser.BurialContext ctx);
	/**
	 * Exit a parse tree produced by {@link FieldParser#burial}.
	 * @param ctx the parse tree
	 */
	void exitBurial(@NotNull FieldParser.BurialContext ctx);

	/**
	 * Enter a parse tree produced by {@link FieldParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(@NotNull FieldParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FieldParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(@NotNull FieldParser.LocationContext ctx);

	/**
	 * Enter a parse tree produced by {@link FieldParser#points}.
	 * @param ctx the parse tree
	 */
	void enterPoints(@NotNull FieldParser.PointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FieldParser#points}.
	 * @param ctx the parse tree
	 */
	void exitPoints(@NotNull FieldParser.PointsContext ctx);
}