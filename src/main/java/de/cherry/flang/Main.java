package de.cherry.flang;

import org.antlr.v4.runtime.*;
import de.cherry.flang.FlangLexer;
import de.cherry.flang.FlangParser;

import java.io.IOException;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    CharStream standartTest = CharStreams.fromFileName("/Users/mbaaxur/Documents/JavaTest/flang/src/main/resources/func.flang");
    FlangLexer flangLexer = new FlangLexer(standartTest);
    CommonTokenStream commonTokenStream = new CommonTokenStream(flangLexer);
    FlangParser flangParser = new FlangParser(commonTokenStream);
    flangParser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
      }
    });
    flangParser.setBuildParseTree(true);
    FlangParser.ParseContext program = flangParser.parse();

    Scope scope = new Scope();
    HashMap<String, Function> functions = new HashMap<>();
    SymbolVisitor symbolVisitor = new SymbolVisitor(functions);
    symbolVisitor.visit(program);
    EvalVisitor evalVisitor = new EvalVisitor(scope, functions);
    evalVisitor.visit(program);
  }
}
