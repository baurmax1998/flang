package de.cherry.flang;

import de.cherry.flang.FlangLexer;
import de.cherry.flang.FlangParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.InputStream;

public class FlangFactory {

  public Flang createFlang(InputStream in) throws IOException {
    ANTLRInputStream input = new ANTLRInputStream(in);
    FlangLexer flangLexer = new FlangLexer(input);
    CommonTokenStream commonTokenStream = new CommonTokenStream(flangLexer);
    FlangParser flangParser = new FlangParser(commonTokenStream);
    flangParser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
      }
    });
    MyFlangListener listener = new MyFlangListener();
    flangParser.addParseListener(listener);
    flangParser.program();
    return listener.getFlang();
  }
}
