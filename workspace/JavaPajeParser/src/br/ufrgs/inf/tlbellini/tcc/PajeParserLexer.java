// Generated from PajeParser.g4 by ANTLR 4.5

	package br.ufrgs.inf.tlbellini.tcc;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PajeParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TK_BREAK=1, SPACE=2, TAB=3, COMMENT=4, TK_EVENT_DEF=5, TK_EVENT_DEF_BEGIN=6, 
		TK_EVENT_DEF_END=7, TK_PAJE_DEFINE_CONTAINER_TYPE=8, TK_PAJE_DEFINE_VARIABLE_TYPE=9, 
		TK_PAJE_DEFINE_STATE_TYPE=10, TK_PAJE_DEFINE_EVENT_TYPE=11, TK_PAJE_DEFINE_LINK_TYPE=12, 
		TK_PAJE_DEFINE_ENTITY_VALUE=13, TK_PAJE_CREATE_CONTAINER=14, TK_PAJE_DESTROY_CONTAINER=15, 
		TK_PAJE_SET_VARIABLE=16, TK_PAJE_ADD_VARIABLE=17, TK_PAJE_SUB_VARIABLE=18, 
		TK_PAJE_SET_STATE=19, TK_PAJE_PUSH_STATE=20, TK_PAJE_POP_STATE=21, TK_PAJE_RESET_STATE=22, 
		TK_PAJE_START_LINK=23, TK_PAJE_END_LINK=24, TK_PAJE_NEW_EVENT=25, TK_EVENT_DEF_ALIAS=26, 
		TK_EVENT_DEF_TYPE=27, TK_EVENT_DEF_NAME=28, TK_EVENT_DEF_COLOR=29, TK_EVENT_DEF_START_CONTAINER_TYPE=30, 
		TK_EVENT_DEF_END_CONTAINER_TYPE=31, TK_EVENT_DEF_CONTAINER=32, TK_EVENT_DEF_TIME=33, 
		TK_EVENT_DEF_START_CONTAINER=34, TK_EVENT_DEF_END_CONTAINER=35, TK_EVENT_DEF_VALUE=36, 
		TK_EVENT_DEF_KEY=37, TK_EVENT_DEF_LINE=38, TK_EVENT_DEF_FILE=39, TK_EVENT_DEF_FIELD_TYPE_STRING=40, 
		TK_EVENT_DEF_FIELD_TYPE_FLOAT=41, TK_EVENT_DEF_FIELD_TYPE_DOUBLE=42, TK_EVENT_DEF_FIELD_TYPE_INT=43, 
		TK_EVENT_DEF_FIELD_TYPE_HEX=44, TK_EVENT_DEF_FIELD_TYPE_DATE=45, TK_EVENT_DEF_FIELD_TYPE_COLOR=46, 
		TK_INT=47, TK_FLOAT=48, TK_STRING=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TK_BREAK", "SPACE", "TAB", "DIGIT", "COMMENT", "TK_EVENT_DEF", "TK_EVENT_DEF_BEGIN", 
		"TK_EVENT_DEF_END", "TK_PAJE_DEFINE_CONTAINER_TYPE", "TK_PAJE_DEFINE_VARIABLE_TYPE", 
		"TK_PAJE_DEFINE_STATE_TYPE", "TK_PAJE_DEFINE_EVENT_TYPE", "TK_PAJE_DEFINE_LINK_TYPE", 
		"TK_PAJE_DEFINE_ENTITY_VALUE", "TK_PAJE_CREATE_CONTAINER", "TK_PAJE_DESTROY_CONTAINER", 
		"TK_PAJE_SET_VARIABLE", "TK_PAJE_ADD_VARIABLE", "TK_PAJE_SUB_VARIABLE", 
		"TK_PAJE_SET_STATE", "TK_PAJE_PUSH_STATE", "TK_PAJE_POP_STATE", "TK_PAJE_RESET_STATE", 
		"TK_PAJE_START_LINK", "TK_PAJE_END_LINK", "TK_PAJE_NEW_EVENT", "TK_EVENT_DEF_ALIAS", 
		"TK_EVENT_DEF_TYPE", "TK_EVENT_DEF_NAME", "TK_EVENT_DEF_COLOR", "TK_EVENT_DEF_START_CONTAINER_TYPE", 
		"TK_EVENT_DEF_END_CONTAINER_TYPE", "TK_EVENT_DEF_CONTAINER", "TK_EVENT_DEF_TIME", 
		"TK_EVENT_DEF_START_CONTAINER", "TK_EVENT_DEF_END_CONTAINER", "TK_EVENT_DEF_VALUE", 
		"TK_EVENT_DEF_KEY", "TK_EVENT_DEF_LINE", "TK_EVENT_DEF_FILE", "TK_EVENT_DEF_FIELD_TYPE_STRING", 
		"TK_EVENT_DEF_FIELD_TYPE_FLOAT", "TK_EVENT_DEF_FIELD_TYPE_DOUBLE", "TK_EVENT_DEF_FIELD_TYPE_INT", 
		"TK_EVENT_DEF_FIELD_TYPE_HEX", "TK_EVENT_DEF_FIELD_TYPE_DATE", "TK_EVENT_DEF_FIELD_TYPE_COLOR", 
		"TK_INT", "TK_FLOAT", "LETTER", "TK_STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "' '", "'\t'", "'#.*\n'", "'%'", "'%EventDef'", "'%EndEventDef'", 
		"'PajeDefineContainerType'", "'PajeDefineVariableType'", "'PajeDefineStateType'", 
		"'PajeDefineEventType'", "'PajeDefineLinkType'", "'PajeDefineEntityValue'", 
		"'PajeCreateContainer'", "'PajeDestroyContainer'", "'PajeSetVariable'", 
		"'PajeAddVariable'", "'PajeSubVariable'", "'PajeSetState'", "'PajePushState'", 
		"'PajePopState'", "'PajeResetState'", "'PajeStartLink'", "'PajeEndLink'", 
		"'PajeNewEvent'", "'Alias'", "'Type'", "'Name'", "'Color'", "'StartContainerType'", 
		"'EndContainerType'", "'Container'", "'Time'", "'StartContainer'", "'EndContainer'", 
		"'Value'", "'Key'", "'Line'", "'File'", "'string'", "'float'", "'double'", 
		"'int'", "'hex'", "'date'", "'color'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TK_BREAK", "SPACE", "TAB", "COMMENT", "TK_EVENT_DEF", "TK_EVENT_DEF_BEGIN", 
		"TK_EVENT_DEF_END", "TK_PAJE_DEFINE_CONTAINER_TYPE", "TK_PAJE_DEFINE_VARIABLE_TYPE", 
		"TK_PAJE_DEFINE_STATE_TYPE", "TK_PAJE_DEFINE_EVENT_TYPE", "TK_PAJE_DEFINE_LINK_TYPE", 
		"TK_PAJE_DEFINE_ENTITY_VALUE", "TK_PAJE_CREATE_CONTAINER", "TK_PAJE_DESTROY_CONTAINER", 
		"TK_PAJE_SET_VARIABLE", "TK_PAJE_ADD_VARIABLE", "TK_PAJE_SUB_VARIABLE", 
		"TK_PAJE_SET_STATE", "TK_PAJE_PUSH_STATE", "TK_PAJE_POP_STATE", "TK_PAJE_RESET_STATE", 
		"TK_PAJE_START_LINK", "TK_PAJE_END_LINK", "TK_PAJE_NEW_EVENT", "TK_EVENT_DEF_ALIAS", 
		"TK_EVENT_DEF_TYPE", "TK_EVENT_DEF_NAME", "TK_EVENT_DEF_COLOR", "TK_EVENT_DEF_START_CONTAINER_TYPE", 
		"TK_EVENT_DEF_END_CONTAINER_TYPE", "TK_EVENT_DEF_CONTAINER", "TK_EVENT_DEF_TIME", 
		"TK_EVENT_DEF_START_CONTAINER", "TK_EVENT_DEF_END_CONTAINER", "TK_EVENT_DEF_VALUE", 
		"TK_EVENT_DEF_KEY", "TK_EVENT_DEF_LINE", "TK_EVENT_DEF_FILE", "TK_EVENT_DEF_FIELD_TYPE_STRING", 
		"TK_EVENT_DEF_FIELD_TYPE_FLOAT", "TK_EVENT_DEF_FIELD_TYPE_DOUBLE", "TK_EVENT_DEF_FIELD_TYPE_INT", 
		"TK_EVENT_DEF_FIELD_TYPE_HEX", "TK_EVENT_DEF_FIELD_TYPE_DATE", "TK_EVENT_DEF_FIELD_TYPE_COLOR", 
		"TK_INT", "TK_FLOAT", "TK_STRING"
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


	public PajeParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PajeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u0292\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\5\2m\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\61\6\61\u0271\n\61\r\61\16\61\u0272\3\62\6\62\u0276\n\62\r\62\16\62"+
		"\u0277\3\62\3\62\6\62\u027c\n\62\r\62\16\62\u027d\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\7\64\u0286\n\64\f\64\16\64\u0289\13\64\3\64\3\64\6\64\u028d"+
		"\n\64\r\64\16\64\u028e\5\64\u0291\n\64\3\u0287\2\65\3\3\5\4\7\5\t\2\13"+
		"\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'"+
		"\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K"+
		"&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\2g\63\3\2\5\4\2\f\f\17\17\3\2\62;\6"+
		"\2//C\\aac|\u0297\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G"+
		"\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\3l\3\2\2\2\5n\3\2\2\2\7r\3\2\2\2\tv"+
		"\3\2\2\2\13x\3\2\2\2\r\177\3\2\2\2\17\u0081\3\2\2\2\21\u008b\3\2\2\2\23"+
		"\u0098\3\2\2\2\25\u00b0\3\2\2\2\27\u00c7\3\2\2\2\31\u00db\3\2\2\2\33\u00ef"+
		"\3\2\2\2\35\u0102\3\2\2\2\37\u0118\3\2\2\2!\u012c\3\2\2\2#\u0141\3\2\2"+
		"\2%\u0151\3\2\2\2\'\u0161\3\2\2\2)\u0171\3\2\2\2+\u017e\3\2\2\2-\u018c"+
		"\3\2\2\2/\u0199\3\2\2\2\61\u01a8\3\2\2\2\63\u01b6\3\2\2\2\65\u01c2\3\2"+
		"\2\2\67\u01cf\3\2\2\29\u01d5\3\2\2\2;\u01da\3\2\2\2=\u01df\3\2\2\2?\u01e5"+
		"\3\2\2\2A\u01f8\3\2\2\2C\u0209\3\2\2\2E\u0213\3\2\2\2G\u0218\3\2\2\2I"+
		"\u0227\3\2\2\2K\u0234\3\2\2\2M\u023a\3\2\2\2O\u023e\3\2\2\2Q\u0243\3\2"+
		"\2\2S\u0248\3\2\2\2U\u024f\3\2\2\2W\u0255\3\2\2\2Y\u025c\3\2\2\2[\u0260"+
		"\3\2\2\2]\u0264\3\2\2\2_\u0269\3\2\2\2a\u0270\3\2\2\2c\u0275\3\2\2\2e"+
		"\u027f\3\2\2\2g\u0290\3\2\2\2im\t\2\2\2jk\7\17\2\2km\7\f\2\2li\3\2\2\2"+
		"lj\3\2\2\2m\4\3\2\2\2no\7\"\2\2op\3\2\2\2pq\b\3\2\2q\6\3\2\2\2rs\7\13"+
		"\2\2st\3\2\2\2tu\b\4\2\2u\b\3\2\2\2vw\t\3\2\2w\n\3\2\2\2xy\7%\2\2yz\7"+
		"\60\2\2z{\7,\2\2{|\7\f\2\2|}\3\2\2\2}~\b\6\2\2~\f\3\2\2\2\177\u0080\7"+
		"\'\2\2\u0080\16\3\2\2\2\u0081\u0082\7\'\2\2\u0082\u0083\7G\2\2\u0083\u0084"+
		"\7x\2\2\u0084\u0085\7g\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087"+
		"\u0088\7F\2\2\u0088\u0089\7g\2\2\u0089\u008a\7h\2\2\u008a\20\3\2\2\2\u008b"+
		"\u008c\7\'\2\2\u008c\u008d\7G\2\2\u008d\u008e\7p\2\2\u008e\u008f\7f\2"+
		"\2\u008f\u0090\7G\2\2\u0090\u0091\7x\2\2\u0091\u0092\7g\2\2\u0092\u0093"+
		"\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095\7F\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7h\2\2\u0097\22\3\2\2\2\u0098\u0099\7R\2\2\u0099\u009a\7c\2\2\u009a"+
		"\u009b\7l\2\2\u009b\u009c\7g\2\2\u009c\u009d\7F\2\2\u009d\u009e\7g\2\2"+
		"\u009e\u009f\7h\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2"+
		"\7g\2\2\u00a2\u00a3\7E\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7p\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2"+
		"\u00a9\u00aa\7g\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7V\2\2\u00ac\u00ad"+
		"\7{\2\2\u00ad\u00ae\7r\2\2\u00ae\u00af\7g\2\2\u00af\24\3\2\2\2\u00b0\u00b1"+
		"\7R\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7l\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\u00b5\7F\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8\7k\2\2"+
		"\u00b8\u00b9\7p\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7X\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7c\2\2\u00bf"+
		"\u00c0\7d\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7V\2\2"+
		"\u00c3\u00c4\7{\2\2\u00c4\u00c5\7r\2\2\u00c5\u00c6\7g\2\2\u00c6\26\3\2"+
		"\2\2\u00c7\u00c8\7R\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7l\2\2\u00ca\u00cb"+
		"\7g\2\2\u00cb\u00cc\7F\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7h\2\2\u00ce"+
		"\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7U\2\2"+
		"\u00d2\u00d3\7v\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6\u00d7\7V\2\2\u00d7\u00d8\7{\2\2\u00d8\u00d9\7r\2\2\u00d9"+
		"\u00da\7g\2\2\u00da\30\3\2\2\2\u00db\u00dc\7R\2\2\u00dc\u00dd\7c\2\2\u00dd"+
		"\u00de\7l\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7F\2\2\u00e0\u00e1\7g\2\2"+
		"\u00e1\u00e2\7h\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5"+
		"\7g\2\2\u00e5\u00e6\7G\2\2\u00e6\u00e7\7x\2\2\u00e7\u00e8\7g\2\2\u00e8"+
		"\u00e9\7p\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7V\2\2\u00eb\u00ec\7{\2\2"+
		"\u00ec\u00ed\7r\2\2\u00ed\u00ee\7g\2\2\u00ee\32\3\2\2\2\u00ef\u00f0\7"+
		"R\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7l\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4"+
		"\7F\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7k\2\2\u00f7"+
		"\u00f8\7p\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7N\2\2\u00fa\u00fb\7k\2\2"+
		"\u00fb\u00fc\7p\2\2\u00fc\u00fd\7m\2\2\u00fd\u00fe\7V\2\2\u00fe\u00ff"+
		"\7{\2\2\u00ff\u0100\7r\2\2\u0100\u0101\7g\2\2\u0101\34\3\2\2\2\u0102\u0103"+
		"\7R\2\2\u0103\u0104\7c\2\2\u0104\u0105\7l\2\2\u0105\u0106\7g\2\2\u0106"+
		"\u0107\7F\2\2\u0107\u0108\7g\2\2\u0108\u0109\7h\2\2\u0109\u010a\7k\2\2"+
		"\u010a\u010b\7p\2\2\u010b\u010c\7g\2\2\u010c\u010d\7G\2\2\u010d\u010e"+
		"\7p\2\2\u010e\u010f\7v\2\2\u010f\u0110\7k\2\2\u0110\u0111\7v\2\2\u0111"+
		"\u0112\7{\2\2\u0112\u0113\7X\2\2\u0113\u0114\7c\2\2\u0114\u0115\7n\2\2"+
		"\u0115\u0116\7w\2\2\u0116\u0117\7g\2\2\u0117\36\3\2\2\2\u0118\u0119\7"+
		"R\2\2\u0119\u011a\7c\2\2\u011a\u011b\7l\2\2\u011b\u011c\7g\2\2\u011c\u011d"+
		"\7E\2\2\u011d\u011e\7t\2\2\u011e\u011f\7g\2\2\u011f\u0120\7c\2\2\u0120"+
		"\u0121\7v\2\2\u0121\u0122\7g\2\2\u0122\u0123\7E\2\2\u0123\u0124\7q\2\2"+
		"\u0124\u0125\7p\2\2\u0125\u0126\7v\2\2\u0126\u0127\7c\2\2\u0127\u0128"+
		"\7k\2\2\u0128\u0129\7p\2\2\u0129\u012a\7g\2\2\u012a\u012b\7t\2\2\u012b"+
		" \3\2\2\2\u012c\u012d\7R\2\2\u012d\u012e\7c\2\2\u012e\u012f\7l\2\2\u012f"+
		"\u0130\7g\2\2\u0130\u0131\7F\2\2\u0131\u0132\7g\2\2\u0132\u0133\7u\2\2"+
		"\u0133\u0134\7v\2\2\u0134\u0135\7t\2\2\u0135\u0136\7q\2\2\u0136\u0137"+
		"\7{\2\2\u0137\u0138\7E\2\2\u0138\u0139\7q\2\2\u0139\u013a\7p\2\2\u013a"+
		"\u013b\7v\2\2\u013b\u013c\7c\2\2\u013c\u013d\7k\2\2\u013d\u013e\7p\2\2"+
		"\u013e\u013f\7g\2\2\u013f\u0140\7t\2\2\u0140\"\3\2\2\2\u0141\u0142\7R"+
		"\2\2\u0142\u0143\7c\2\2\u0143\u0144\7l\2\2\u0144\u0145\7g\2\2\u0145\u0146"+
		"\7U\2\2\u0146\u0147\7g\2\2\u0147\u0148\7v\2\2\u0148\u0149\7X\2\2\u0149"+
		"\u014a\7c\2\2\u014a\u014b\7t\2\2\u014b\u014c\7k\2\2\u014c\u014d\7c\2\2"+
		"\u014d\u014e\7d\2\2\u014e\u014f\7n\2\2\u014f\u0150\7g\2\2\u0150$\3\2\2"+
		"\2\u0151\u0152\7R\2\2\u0152\u0153\7c\2\2\u0153\u0154\7l\2\2\u0154\u0155"+
		"\7g\2\2\u0155\u0156\7C\2\2\u0156\u0157\7f\2\2\u0157\u0158\7f\2\2\u0158"+
		"\u0159\7X\2\2\u0159\u015a\7c\2\2\u015a\u015b\7t\2\2\u015b\u015c\7k\2\2"+
		"\u015c\u015d\7c\2\2\u015d\u015e\7d\2\2\u015e\u015f\7n\2\2\u015f\u0160"+
		"\7g\2\2\u0160&\3\2\2\2\u0161\u0162\7R\2\2\u0162\u0163\7c\2\2\u0163\u0164"+
		"\7l\2\2\u0164\u0165\7g\2\2\u0165\u0166\7U\2\2\u0166\u0167\7w\2\2\u0167"+
		"\u0168\7d\2\2\u0168\u0169\7X\2\2\u0169\u016a\7c\2\2\u016a\u016b\7t\2\2"+
		"\u016b\u016c\7k\2\2\u016c\u016d\7c\2\2\u016d\u016e\7d\2\2\u016e\u016f"+
		"\7n\2\2\u016f\u0170\7g\2\2\u0170(\3\2\2\2\u0171\u0172\7R\2\2\u0172\u0173"+
		"\7c\2\2\u0173\u0174\7l\2\2\u0174\u0175\7g\2\2\u0175\u0176\7U\2\2\u0176"+
		"\u0177\7g\2\2\u0177\u0178\7v\2\2\u0178\u0179\7U\2\2\u0179\u017a\7v\2\2"+
		"\u017a\u017b\7c\2\2\u017b\u017c\7v\2\2\u017c\u017d\7g\2\2\u017d*\3\2\2"+
		"\2\u017e\u017f\7R\2\2\u017f\u0180\7c\2\2\u0180\u0181\7l\2\2\u0181\u0182"+
		"\7g\2\2\u0182\u0183\7R\2\2\u0183\u0184\7w\2\2\u0184\u0185\7u\2\2\u0185"+
		"\u0186\7j\2\2\u0186\u0187\7U\2\2\u0187\u0188\7v\2\2\u0188\u0189\7c\2\2"+
		"\u0189\u018a\7v\2\2\u018a\u018b\7g\2\2\u018b,\3\2\2\2\u018c\u018d\7R\2"+
		"\2\u018d\u018e\7c\2\2\u018e\u018f\7l\2\2\u018f\u0190\7g\2\2\u0190\u0191"+
		"\7R\2\2\u0191\u0192\7q\2\2\u0192\u0193\7r\2\2\u0193\u0194\7U\2\2\u0194"+
		"\u0195\7v\2\2\u0195\u0196\7c\2\2\u0196\u0197\7v\2\2\u0197\u0198\7g\2\2"+
		"\u0198.\3\2\2\2\u0199\u019a\7R\2\2\u019a\u019b\7c\2\2\u019b\u019c\7l\2"+
		"\2\u019c\u019d\7g\2\2\u019d\u019e\7T\2\2\u019e\u019f\7g\2\2\u019f\u01a0"+
		"\7u\2\2\u01a0\u01a1\7g\2\2\u01a1\u01a2\7v\2\2\u01a2\u01a3\7U\2\2\u01a3"+
		"\u01a4\7v\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7v\2\2\u01a6\u01a7\7g\2\2"+
		"\u01a7\60\3\2\2\2\u01a8\u01a9\7R\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7"+
		"l\2\2\u01ab\u01ac\7g\2\2\u01ac\u01ad\7U\2\2\u01ad\u01ae\7v\2\2\u01ae\u01af"+
		"\7c\2\2\u01af\u01b0\7t\2\2\u01b0\u01b1\7v\2\2\u01b1\u01b2\7N\2\2\u01b2"+
		"\u01b3\7k\2\2\u01b3\u01b4\7p\2\2\u01b4\u01b5\7m\2\2\u01b5\62\3\2\2\2\u01b6"+
		"\u01b7\7R\2\2\u01b7\u01b8\7c\2\2\u01b8\u01b9\7l\2\2\u01b9\u01ba\7g\2\2"+
		"\u01ba\u01bb\7G\2\2\u01bb\u01bc\7p\2\2\u01bc\u01bd\7f\2\2\u01bd\u01be"+
		"\7N\2\2\u01be\u01bf\7k\2\2\u01bf\u01c0\7p\2\2\u01c0\u01c1\7m\2\2\u01c1"+
		"\64\3\2\2\2\u01c2\u01c3\7R\2\2\u01c3\u01c4\7c\2\2\u01c4\u01c5\7l\2\2\u01c5"+
		"\u01c6\7g\2\2\u01c6\u01c7\7P\2\2\u01c7\u01c8\7g\2\2\u01c8\u01c9\7y\2\2"+
		"\u01c9\u01ca\7G\2\2\u01ca\u01cb\7x\2\2\u01cb\u01cc\7g\2\2\u01cc\u01cd"+
		"\7p\2\2\u01cd\u01ce\7v\2\2\u01ce\66\3\2\2\2\u01cf\u01d0\7C\2\2\u01d0\u01d1"+
		"\7n\2\2\u01d1\u01d2\7k\2\2\u01d2\u01d3\7c\2\2\u01d3\u01d4\7u\2\2\u01d4"+
		"8\3\2\2\2\u01d5\u01d6\7V\2\2\u01d6\u01d7\7{\2\2\u01d7\u01d8\7r\2\2\u01d8"+
		"\u01d9\7g\2\2\u01d9:\3\2\2\2\u01da\u01db\7P\2\2\u01db\u01dc\7c\2\2\u01dc"+
		"\u01dd\7o\2\2\u01dd\u01de\7g\2\2\u01de<\3\2\2\2\u01df\u01e0\7E\2\2\u01e0"+
		"\u01e1\7q\2\2\u01e1\u01e2\7n\2\2\u01e2\u01e3\7q\2\2\u01e3\u01e4\7t\2\2"+
		"\u01e4>\3\2\2\2\u01e5\u01e6\7U\2\2\u01e6\u01e7\7v\2\2\u01e7\u01e8\7c\2"+
		"\2\u01e8\u01e9\7t\2\2\u01e9\u01ea\7v\2\2\u01ea\u01eb\7E\2\2\u01eb\u01ec"+
		"\7q\2\2\u01ec\u01ed\7p\2\2\u01ed\u01ee\7v\2\2\u01ee\u01ef\7c\2\2\u01ef"+
		"\u01f0\7k\2\2\u01f0\u01f1\7p\2\2\u01f1\u01f2\7g\2\2\u01f2\u01f3\7t\2\2"+
		"\u01f3\u01f4\7V\2\2\u01f4\u01f5\7{\2\2\u01f5\u01f6\7r\2\2\u01f6\u01f7"+
		"\7g\2\2\u01f7@\3\2\2\2\u01f8\u01f9\7G\2\2\u01f9\u01fa\7p\2\2\u01fa\u01fb"+
		"\7f\2\2\u01fb\u01fc\7E\2\2\u01fc\u01fd\7q\2\2\u01fd\u01fe\7p\2\2\u01fe"+
		"\u01ff\7v\2\2\u01ff\u0200\7c\2\2\u0200\u0201\7k\2\2\u0201\u0202\7p\2\2"+
		"\u0202\u0203\7g\2\2\u0203\u0204\7t\2\2\u0204\u0205\7V\2\2\u0205\u0206"+
		"\7{\2\2\u0206\u0207\7r\2\2\u0207\u0208\7g\2\2\u0208B\3\2\2\2\u0209\u020a"+
		"\7E\2\2\u020a\u020b\7q\2\2\u020b\u020c\7p\2\2\u020c\u020d\7v\2\2\u020d"+
		"\u020e\7c\2\2\u020e\u020f\7k\2\2\u020f\u0210\7p\2\2\u0210\u0211\7g\2\2"+
		"\u0211\u0212\7t\2\2\u0212D\3\2\2\2\u0213\u0214\7V\2\2\u0214\u0215\7k\2"+
		"\2\u0215\u0216\7o\2\2\u0216\u0217\7g\2\2\u0217F\3\2\2\2\u0218\u0219\7"+
		"U\2\2\u0219\u021a\7v\2\2\u021a\u021b\7c\2\2\u021b\u021c\7t\2\2\u021c\u021d"+
		"\7v\2\2\u021d\u021e\7E\2\2\u021e\u021f\7q\2\2\u021f\u0220\7p\2\2\u0220"+
		"\u0221\7v\2\2\u0221\u0222\7c\2\2\u0222\u0223\7k\2\2\u0223\u0224\7p\2\2"+
		"\u0224\u0225\7g\2\2\u0225\u0226\7t\2\2\u0226H\3\2\2\2\u0227\u0228\7G\2"+
		"\2\u0228\u0229\7p\2\2\u0229\u022a\7f\2\2\u022a\u022b\7E\2\2\u022b\u022c"+
		"\7q\2\2\u022c\u022d\7p\2\2\u022d\u022e\7v\2\2\u022e\u022f\7c\2\2\u022f"+
		"\u0230\7k\2\2\u0230\u0231\7p\2\2\u0231\u0232\7g\2\2\u0232\u0233\7t\2\2"+
		"\u0233J\3\2\2\2\u0234\u0235\7X\2\2\u0235\u0236\7c\2\2\u0236\u0237\7n\2"+
		"\2\u0237\u0238\7w\2\2\u0238\u0239\7g\2\2\u0239L\3\2\2\2\u023a\u023b\7"+
		"M\2\2\u023b\u023c\7g\2\2\u023c\u023d\7{\2\2\u023dN\3\2\2\2\u023e\u023f"+
		"\7N\2\2\u023f\u0240\7k\2\2\u0240\u0241\7p\2\2\u0241\u0242\7g\2\2\u0242"+
		"P\3\2\2\2\u0243\u0244\7H\2\2\u0244\u0245\7k\2\2\u0245\u0246\7n\2\2\u0246"+
		"\u0247\7g\2\2\u0247R\3\2\2\2\u0248\u0249\7u\2\2\u0249\u024a\7v\2\2\u024a"+
		"\u024b\7t\2\2\u024b\u024c\7k\2\2\u024c\u024d\7p\2\2\u024d\u024e\7i\2\2"+
		"\u024eT\3\2\2\2\u024f\u0250\7h\2\2\u0250\u0251\7n\2\2\u0251\u0252\7q\2"+
		"\2\u0252\u0253\7c\2\2\u0253\u0254\7v\2\2\u0254V\3\2\2\2\u0255\u0256\7"+
		"f\2\2\u0256\u0257\7q\2\2\u0257\u0258\7w\2\2\u0258\u0259\7d\2\2\u0259\u025a"+
		"\7n\2\2\u025a\u025b\7g\2\2\u025bX\3\2\2\2\u025c\u025d\7k\2\2\u025d\u025e"+
		"\7p\2\2\u025e\u025f\7v\2\2\u025fZ\3\2\2\2\u0260\u0261\7j\2\2\u0261\u0262"+
		"\7g\2\2\u0262\u0263\7z\2\2\u0263\\\3\2\2\2\u0264\u0265\7f\2\2\u0265\u0266"+
		"\7c\2\2\u0266\u0267\7v\2\2\u0267\u0268\7g\2\2\u0268^\3\2\2\2\u0269\u026a"+
		"\7e\2\2\u026a\u026b\7q\2\2\u026b\u026c\7n\2\2\u026c\u026d\7q\2\2\u026d"+
		"\u026e\7t\2\2\u026e`\3\2\2\2\u026f\u0271\5\t\5\2\u0270\u026f\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273b\3\2\2\2"+
		"\u0274\u0276\5\t\5\2\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027b\7\60\2\2"+
		"\u027a\u027c\5\t\5\2\u027b\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027b"+
		"\3\2\2\2\u027d\u027e\3\2\2\2\u027ed\3\2\2\2\u027f\u0280\t\4\2\2\u0280"+
		"f\3\2\2\2\u0281\u0287\7$\2\2\u0282\u0283\7^\2\2\u0283\u0286\7$\2\2\u0284"+
		"\u0286\13\2\2\2\u0285\u0282\3\2\2\2\u0285\u0284\3\2\2\2\u0286\u0289\3"+
		"\2\2\2\u0287\u0288\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u028a\3\2\2\2\u0289"+
		"\u0287\3\2\2\2\u028a\u0291\7$\2\2\u028b\u028d\5e\63\2\u028c\u028b\3\2"+
		"\2\2\u028d\u028e\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f"+
		"\u0291\3\2\2\2\u0290\u0281\3\2\2\2\u0290\u028c\3\2\2\2\u0291h\3\2\2\2"+
		"\13\2l\u0272\u0277\u027d\u0285\u0287\u028e\u0290\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}