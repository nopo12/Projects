// Generated from /home/noah/Documents/CS_HW/Compilers/Compilers-Project/Antlr_demo/src/main/java/Visitor/GoobScraper.g4 by ANTLR 4.7.2
package Visitor;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GoobScraperLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, STRING=16, 
		ID=17, NUMBER=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "STRING", "ID", 
			"NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/get'", "';'", "'/extract'", "'/update'", "'/alert'", "'/quit'", 
			"'url'", "'tables'", "'table'", "'append'", "'new'", "'sec'", "'min'", 
			"'hrs'", "'day'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "STRING", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GoobScraperLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GoobScraper.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\7\21}\n\21\f\21\16\21\u0080\13\21\3\21"+
		"\3\21\3\22\6\22\u0085\n\22\r\22\16\22\u0086\3\23\6\23\u008a\n\23\r\23"+
		"\16\23\u008b\3\24\6\24\u008f\n\24\r\24\16\24\u0090\3\24\3\24\2\2\25\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25\3\2\6\5\2\f\f\17\17$$\4\2C\\c|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5.\3\2\2\2\7\60\3"+
		"\2\2\2\t9\3\2\2\2\13A\3\2\2\2\rH\3\2\2\2\17N\3\2\2\2\21R\3\2\2\2\23Y\3"+
		"\2\2\2\25_\3\2\2\2\27f\3\2\2\2\31j\3\2\2\2\33n\3\2\2\2\35r\3\2\2\2\37"+
		"v\3\2\2\2!z\3\2\2\2#\u0084\3\2\2\2%\u0089\3\2\2\2\'\u008e\3\2\2\2)*\7"+
		"\61\2\2*+\7i\2\2+,\7g\2\2,-\7v\2\2-\4\3\2\2\2./\7=\2\2/\6\3\2\2\2\60\61"+
		"\7\61\2\2\61\62\7g\2\2\62\63\7z\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7"+
		"c\2\2\66\67\7e\2\2\678\7v\2\28\b\3\2\2\29:\7\61\2\2:;\7w\2\2;<\7r\2\2"+
		"<=\7f\2\2=>\7c\2\2>?\7v\2\2?@\7g\2\2@\n\3\2\2\2AB\7\61\2\2BC\7c\2\2CD"+
		"\7n\2\2DE\7g\2\2EF\7t\2\2FG\7v\2\2G\f\3\2\2\2HI\7\61\2\2IJ\7s\2\2JK\7"+
		"w\2\2KL\7k\2\2LM\7v\2\2M\16\3\2\2\2NO\7w\2\2OP\7t\2\2PQ\7n\2\2Q\20\3\2"+
		"\2\2RS\7v\2\2ST\7c\2\2TU\7d\2\2UV\7n\2\2VW\7g\2\2WX\7u\2\2X\22\3\2\2\2"+
		"YZ\7v\2\2Z[\7c\2\2[\\\7d\2\2\\]\7n\2\2]^\7g\2\2^\24\3\2\2\2_`\7c\2\2`"+
		"a\7r\2\2ab\7r\2\2bc\7g\2\2cd\7p\2\2de\7f\2\2e\26\3\2\2\2fg\7p\2\2gh\7"+
		"g\2\2hi\7y\2\2i\30\3\2\2\2jk\7u\2\2kl\7g\2\2lm\7e\2\2m\32\3\2\2\2no\7"+
		"o\2\2op\7k\2\2pq\7p\2\2q\34\3\2\2\2rs\7j\2\2st\7t\2\2tu\7u\2\2u\36\3\2"+
		"\2\2vw\7f\2\2wx\7c\2\2xy\7{\2\2y \3\2\2\2z~\7$\2\2{}\n\2\2\2|{\3\2\2\2"+
		"}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0082\7$\2\2\u0082\"\3\2\2\2\u0083\u0085\t\3\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"$\3\2\2\2\u0088\u008a\t\4\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c&\3\2\2\2\u008d\u008f\t"+
		"\5\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\24\2\2\u0093(\3\2\2\2"+
		"\7\2~\u0086\u008b\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}