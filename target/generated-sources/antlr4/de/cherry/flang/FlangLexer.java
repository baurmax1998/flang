// Generated from de/cherry/flang/Flang.g4 by ANTLR 4.7.1
package de.cherry.flang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FlangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Println=1, Print=2, Input=3, Assert=4, Size=5, Def=6, If=7, Else=8, Return=9, 
		For=10, While=11, To=12, In=13, Null=14, Or=15, And=16, Equals=17, NEquals=18, 
		GTEquals=19, LTEquals=20, Pow=21, Excl=22, GT=23, LT=24, Add=25, Subtract=26, 
		Multiply=27, Divide=28, Modulus=29, OBrace=30, CBrace=31, OBracket=32, 
		CBracket=33, OParen=34, CParen=35, Assign=36, Comma=37, QMark=38, Colon=39, 
		Bool=40, Number=41, Identifier=42, String=43, Comment=44, Space=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Println", "Print", "Input", "Assert", "Size", "Def", "If", "Else", "Return", 
		"For", "While", "To", "In", "Null", "Or", "And", "Equals", "NEquals", 
		"GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", "Add", "Subtract", 
		"Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", 
		"OParen", "CParen", "Assign", "Comma", "QMark", "Colon", "Bool", "Number", 
		"Identifier", "String", "Comment", "Space", "Int", "Digit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'println'", "'print'", "'input'", "'assert'", "'size'", "'function'", 
		"'if'", "'else'", "'return'", "'for'", "'while'", "'to'", "'in'", "'null'", 
		"'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'^'", "'!'", "'>'", "'<'", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", 
		"')'", "'='", "','", "'?'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Println", "Print", "Input", "Assert", "Size", "Def", "If", "Else", 
		"Return", "For", "While", "To", "In", "Null", "Or", "And", "Equals", "NEquals", 
		"GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", "Add", "Subtract", 
		"Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", 
		"OParen", "CParen", "Assign", "Comma", "QMark", "Colon", "Bool", "Number", 
		"Identifier", "String", "Comment", "Space"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Flang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0140\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\5)\u00f0\n)\3*\3*\3*\7*\u00f5\n*\f*\16*\u00f8\13*\5*\u00fa\n*\3+\3+\7"+
		"+\u00fe\n+\f+\16+\u0101\13+\3,\3,\3,\3,\7,\u0107\n,\f,\16,\u010a\13,\3"+
		",\3,\3,\3,\3,\7,\u0111\n,\f,\16,\u0114\13,\3,\5,\u0117\n,\3-\3-\3-\3-"+
		"\7-\u011d\n-\f-\16-\u0120\13-\3-\3-\3-\3-\7-\u0126\n-\f-\16-\u0129\13"+
		"-\3-\3-\5-\u012d\n-\3-\3-\3.\3.\3.\3.\3/\3/\7/\u0137\n/\f/\16/\u013a\13"+
		"/\3/\5/\u013d\n/\3\60\3\60\3\u0127\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\2_\2\3\2\f\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\6\2\f\f\17\17$$^^\4"+
		"\2\f\f\17\17\3\2))\6\2\f\f\17\17))^^\6\2\13\f\16\17\"\"==\3\2\63;\3\2"+
		"\62;\2\u014b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3a\3\2\2\2\5i\3"+
		"\2\2\2\7o\3\2\2\2\tu\3\2\2\2\13|\3\2\2\2\r\u0081\3\2\2\2\17\u008a\3\2"+
		"\2\2\21\u008d\3\2\2\2\23\u0092\3\2\2\2\25\u0099\3\2\2\2\27\u009d\3\2\2"+
		"\2\31\u00a3\3\2\2\2\33\u00a6\3\2\2\2\35\u00a9\3\2\2\2\37\u00ae\3\2\2\2"+
		"!\u00b1\3\2\2\2#\u00b4\3\2\2\2%\u00b7\3\2\2\2\'\u00ba\3\2\2\2)\u00bd\3"+
		"\2\2\2+\u00c0\3\2\2\2-\u00c2\3\2\2\2/\u00c4\3\2\2\2\61\u00c6\3\2\2\2\63"+
		"\u00c8\3\2\2\2\65\u00ca\3\2\2\2\67\u00cc\3\2\2\29\u00ce\3\2\2\2;\u00d0"+
		"\3\2\2\2=\u00d2\3\2\2\2?\u00d4\3\2\2\2A\u00d6\3\2\2\2C\u00d8\3\2\2\2E"+
		"\u00da\3\2\2\2G\u00dc\3\2\2\2I\u00de\3\2\2\2K\u00e0\3\2\2\2M\u00e2\3\2"+
		"\2\2O\u00e4\3\2\2\2Q\u00ef\3\2\2\2S\u00f1\3\2\2\2U\u00fb\3\2\2\2W\u0116"+
		"\3\2\2\2Y\u012c\3\2\2\2[\u0130\3\2\2\2]\u013c\3\2\2\2_\u013e\3\2\2\2a"+
		"b\7r\2\2bc\7t\2\2cd\7k\2\2de\7p\2\2ef\7v\2\2fg\7n\2\2gh\7p\2\2h\4\3\2"+
		"\2\2ij\7r\2\2jk\7t\2\2kl\7k\2\2lm\7p\2\2mn\7v\2\2n\6\3\2\2\2op\7k\2\2"+
		"pq\7p\2\2qr\7r\2\2rs\7w\2\2st\7v\2\2t\b\3\2\2\2uv\7c\2\2vw\7u\2\2wx\7"+
		"u\2\2xy\7g\2\2yz\7t\2\2z{\7v\2\2{\n\3\2\2\2|}\7u\2\2}~\7k\2\2~\177\7|"+
		"\2\2\177\u0080\7g\2\2\u0080\f\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7"+
		"w\2\2\u0083\u0084\7p\2\2\u0084\u0085\7e\2\2\u0085\u0086\7v\2\2\u0086\u0087"+
		"\7k\2\2\u0087\u0088\7q\2\2\u0088\u0089\7p\2\2\u0089\16\3\2\2\2\u008a\u008b"+
		"\7k\2\2\u008b\u008c\7h\2\2\u008c\20\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f"+
		"\7n\2\2\u008f\u0090\7u\2\2\u0090\u0091\7g\2\2\u0091\22\3\2\2\2\u0092\u0093"+
		"\7t\2\2\u0093\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096"+
		"\u0097\7t\2\2\u0097\u0098\7p\2\2\u0098\24\3\2\2\2\u0099\u009a\7h\2\2\u009a"+
		"\u009b\7q\2\2\u009b\u009c\7t\2\2\u009c\26\3\2\2\2\u009d\u009e\7y\2\2\u009e"+
		"\u009f\7j\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2"+
		"\u00a2\30\3\2\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7q\2\2\u00a5\32\3\2\2"+
		"\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8\34\3\2\2\2\u00a9\u00aa"+
		"\7p\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7n\2\2\u00ad"+
		"\36\3\2\2\2\u00ae\u00af\7~\2\2\u00af\u00b0\7~\2\2\u00b0 \3\2\2\2\u00b1"+
		"\u00b2\7(\2\2\u00b2\u00b3\7(\2\2\u00b3\"\3\2\2\2\u00b4\u00b5\7?\2\2\u00b5"+
		"\u00b6\7?\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\7?\2\2\u00b9"+
		"&\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7?\2\2\u00bc(\3\2\2\2\u00bd\u00be"+
		"\7>\2\2\u00be\u00bf\7?\2\2\u00bf*\3\2\2\2\u00c0\u00c1\7`\2\2\u00c1,\3"+
		"\2\2\2\u00c2\u00c3\7#\2\2\u00c3.\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5\60\3"+
		"\2\2\2\u00c6\u00c7\7>\2\2\u00c7\62\3\2\2\2\u00c8\u00c9\7-\2\2\u00c9\64"+
		"\3\2\2\2\u00ca\u00cb\7/\2\2\u00cb\66\3\2\2\2\u00cc\u00cd\7,\2\2\u00cd"+
		"8\3\2\2\2\u00ce\u00cf\7\61\2\2\u00cf:\3\2\2\2\u00d0\u00d1\7\'\2\2\u00d1"+
		"<\3\2\2\2\u00d2\u00d3\7}\2\2\u00d3>\3\2\2\2\u00d4\u00d5\7\177\2\2\u00d5"+
		"@\3\2\2\2\u00d6\u00d7\7]\2\2\u00d7B\3\2\2\2\u00d8\u00d9\7_\2\2\u00d9D"+
		"\3\2\2\2\u00da\u00db\7*\2\2\u00dbF\3\2\2\2\u00dc\u00dd\7+\2\2\u00ddH\3"+
		"\2\2\2\u00de\u00df\7?\2\2\u00dfJ\3\2\2\2\u00e0\u00e1\7.\2\2\u00e1L\3\2"+
		"\2\2\u00e2\u00e3\7A\2\2\u00e3N\3\2\2\2\u00e4\u00e5\7<\2\2\u00e5P\3\2\2"+
		"\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7w\2\2\u00e9\u00f0"+
		"\7g\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7n\2\2\u00ed"+
		"\u00ee\7u\2\2\u00ee\u00f0\7g\2\2\u00ef\u00e6\3\2\2\2\u00ef\u00ea\3\2\2"+
		"\2\u00f0R\3\2\2\2\u00f1\u00f9\5]/\2\u00f2\u00f6\7\60\2\2\u00f3\u00f5\5"+
		"_\60\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f2\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00faT\3\2\2\2\u00fb\u00ff\t\2\2\2\u00fc\u00fe"+
		"\t\3\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100V\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0108\t\4\2\2"+
		"\u0103\u0107\n\5\2\2\u0104\u0105\7^\2\2\u0105\u0107\n\6\2\2\u0106\u0103"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0117\t\4"+
		"\2\2\u010c\u0112\t\7\2\2\u010d\u0111\n\b\2\2\u010e\u010f\7^\2\2\u010f"+
		"\u0111\n\6\2\2\u0110\u010d\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0115\u0117\t\7\2\2\u0116\u0102\3\2\2\2\u0116\u010c\3\2"+
		"\2\2\u0117X\3\2\2\2\u0118\u0119\7\61\2\2\u0119\u011a\7\61\2\2\u011a\u011e"+
		"\3\2\2\2\u011b\u011d\n\6\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u012d\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0121\u0122\7\61\2\2\u0122\u0123\7,\2\2\u0123\u0127\3\2\2\2\u0124"+
		"\u0126\13\2\2\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0128\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012b\7,\2\2\u012b\u012d\7\61\2\2\u012c\u0118\3\2\2\2\u012c\u0121\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u012f\b-\2\2\u012fZ\3\2\2\2\u0130\u0131"+
		"\t\t\2\2\u0131\u0132\3\2\2\2\u0132\u0133\b.\2\2\u0133\\\3\2\2\2\u0134"+
		"\u0138\t\n\2\2\u0135\u0137\5_\60\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2"+
		"\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013d\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013b\u013d\7\62\2\2\u013c\u0134\3\2\2\2\u013c\u013b\3"+
		"\2\2\2\u013d^\3\2\2\2\u013e\u013f\t\13\2\2\u013f`\3\2\2\2\21\2\u00ef\u00f6"+
		"\u00f9\u00ff\u0106\u0108\u0110\u0112\u0116\u011e\u0127\u012c\u0138\u013c"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}