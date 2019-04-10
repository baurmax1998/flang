package de.cherry.game;

import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


public class GameFactory {

  public Game createGame(InputStream in) throws IOException {
    de.cherry.game.FieldLexer l = new de.cherry.game.FieldLexer(new ANTLRInputStream(in));
    de.cherry.game.FieldParser p = new de.cherry.game.FieldParser(new CommonTokenStream(l));
    p.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
      }
    });

    final AtomicReference<String> name = new AtomicReference<>();
    final Map<String, Integer> points = new HashMap<>();
    final String[][] grid = new String[5][5];

    p.addParseListener(new de.cherry.game.FieldBaseListener() {
      int x;
      int y;

      @Override
      public void exitField(de.cherry.game.FieldParser.FieldContext ctx) {
        name.set(ctx.name.getText());
      }

      @Override
      public void exitLocation(de.cherry.game.FieldParser.LocationContext ctx) {
        x = Integer.parseInt(ctx.x.getText());
        y = Integer.parseInt(ctx.y.getText());
      }

      @Override
      public void exitBurial(de.cherry.game.FieldParser.BurialContext ctx) {
        grid[x][y] = ctx.treasure.getText();
      }

      @Override
      public void exitPoints(de.cherry.game.FieldParser.PointsContext ctx) {
        points.put(ctx.treasure.getText(), Integer.parseInt(ctx.value.getText()));
      }
    });
    p.field();

    return new Game(name.get(), points, grid);
  }
}
