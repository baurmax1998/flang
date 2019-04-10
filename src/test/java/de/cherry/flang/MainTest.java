package de.cherry.flang;


import de.cherry.game.FieldLexer;
import de.cherry.game.FieldParser;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import java.io.IOException;

public class MainTest {

  @Test
  public void start() throws IOException {
    FieldLexer l = new FieldLexer(new ANTLRInputStream(getClass().getResourceAsStream("/example.field")));
    FieldParser p = new FieldParser(new CommonTokenStream(l));
    p.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
      }
    });
    p.field();

  }
}