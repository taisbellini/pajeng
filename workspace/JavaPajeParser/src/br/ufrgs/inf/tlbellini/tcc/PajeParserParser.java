// Generated from PajeParser.g4 by ANTLR 4.5

	package br.ufrgs.inf.tlbellini.tcc;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PajeParserParser extends Parser {
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
	public static final int
		RULE_paje = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_event_name = 3, 
		RULE_event_id = 4, RULE_fields = 5, RULE_field = 6, RULE_field_name = 7, 
		RULE_field_type = 8, RULE_events = 9, RULE_event = 10, RULE_non_empty_event = 11, 
		RULE_empty_event = 12, RULE_arguments = 13, RULE_argument = 14;
	public static final String[] ruleNames = {
		"paje", "declarations", "declaration", "event_name", "event_id", "fields", 
		"field", "field_name", "field_type", "events", "event", "non_empty_event", 
		"empty_event", "arguments", "argument"
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

	@Override
	public String getGrammarFileName() { return "PajeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PajeParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PajeContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public EventsContext events() {
			return getRuleContext(EventsContext.class,0);
		}
		public PajeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paje; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterPaje(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitPaje(this);
		}
	}

	public final PajeContext paje() throws RecognitionException {
		PajeContext _localctx = new PajeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_paje);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			declarations();
			setState(31);
			events();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				declaration();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_EVENT_DEF_BEGIN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TK_EVENT_DEF_BEGIN() { return getToken(PajeParserParser.TK_EVENT_DEF_BEGIN, 0); }
		public Event_nameContext event_name() {
			return getRuleContext(Event_nameContext.class,0);
		}
		public Event_idContext event_id() {
			return getRuleContext(Event_idContext.class,0);
		}
		public List<TerminalNode> TK_BREAK() { return getTokens(PajeParserParser.TK_BREAK); }
		public TerminalNode TK_BREAK(int i) {
			return getToken(PajeParserParser.TK_BREAK, i);
		}
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public TerminalNode TK_EVENT_DEF_END() { return getToken(PajeParserParser.TK_EVENT_DEF_END, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(TK_EVENT_DEF_BEGIN);
			setState(39);
			event_name();
			setState(40);
			event_id();
			setState(41);
			match(TK_BREAK);
			setState(42);
			fields();
			setState(43);
			match(TK_EVENT_DEF_END);
			setState(44);
			match(TK_BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_nameContext extends ParserRuleContext {
		public TerminalNode TK_PAJE_DEFINE_CONTAINER_TYPE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_CONTAINER_TYPE, 0); }
		public TerminalNode TK_PAJE_DEFINE_VARIABLE_TYPE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_VARIABLE_TYPE, 0); }
		public TerminalNode TK_PAJE_DEFINE_STATE_TYPE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_STATE_TYPE, 0); }
		public TerminalNode TK_PAJE_DEFINE_EVENT_TYPE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_EVENT_TYPE, 0); }
		public TerminalNode TK_PAJE_DEFINE_LINK_TYPE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_LINK_TYPE, 0); }
		public TerminalNode TK_PAJE_DEFINE_ENTITY_VALUE() { return getToken(PajeParserParser.TK_PAJE_DEFINE_ENTITY_VALUE, 0); }
		public TerminalNode TK_PAJE_CREATE_CONTAINER() { return getToken(PajeParserParser.TK_PAJE_CREATE_CONTAINER, 0); }
		public TerminalNode TK_PAJE_DESTROY_CONTAINER() { return getToken(PajeParserParser.TK_PAJE_DESTROY_CONTAINER, 0); }
		public TerminalNode TK_PAJE_SET_VARIABLE() { return getToken(PajeParserParser.TK_PAJE_SET_VARIABLE, 0); }
		public TerminalNode TK_PAJE_ADD_VARIABLE() { return getToken(PajeParserParser.TK_PAJE_ADD_VARIABLE, 0); }
		public TerminalNode TK_PAJE_SUB_VARIABLE() { return getToken(PajeParserParser.TK_PAJE_SUB_VARIABLE, 0); }
		public TerminalNode TK_PAJE_SET_STATE() { return getToken(PajeParserParser.TK_PAJE_SET_STATE, 0); }
		public TerminalNode TK_PAJE_PUSH_STATE() { return getToken(PajeParserParser.TK_PAJE_PUSH_STATE, 0); }
		public TerminalNode TK_PAJE_POP_STATE() { return getToken(PajeParserParser.TK_PAJE_POP_STATE, 0); }
		public TerminalNode TK_PAJE_RESET_STATE() { return getToken(PajeParserParser.TK_PAJE_RESET_STATE, 0); }
		public TerminalNode TK_PAJE_START_LINK() { return getToken(PajeParserParser.TK_PAJE_START_LINK, 0); }
		public TerminalNode TK_PAJE_END_LINK() { return getToken(PajeParserParser.TK_PAJE_END_LINK, 0); }
		public TerminalNode TK_PAJE_NEW_EVENT() { return getToken(PajeParserParser.TK_PAJE_NEW_EVENT, 0); }
		public Event_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterEvent_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitEvent_name(this);
		}
	}

	public final Event_nameContext event_name() throws RecognitionException {
		Event_nameContext _localctx = new Event_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_event_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_PAJE_DEFINE_CONTAINER_TYPE) | (1L << TK_PAJE_DEFINE_VARIABLE_TYPE) | (1L << TK_PAJE_DEFINE_STATE_TYPE) | (1L << TK_PAJE_DEFINE_EVENT_TYPE) | (1L << TK_PAJE_DEFINE_LINK_TYPE) | (1L << TK_PAJE_DEFINE_ENTITY_VALUE) | (1L << TK_PAJE_CREATE_CONTAINER) | (1L << TK_PAJE_DESTROY_CONTAINER) | (1L << TK_PAJE_SET_VARIABLE) | (1L << TK_PAJE_ADD_VARIABLE) | (1L << TK_PAJE_SUB_VARIABLE) | (1L << TK_PAJE_SET_STATE) | (1L << TK_PAJE_PUSH_STATE) | (1L << TK_PAJE_POP_STATE) | (1L << TK_PAJE_RESET_STATE) | (1L << TK_PAJE_START_LINK) | (1L << TK_PAJE_END_LINK) | (1L << TK_PAJE_NEW_EVENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_idContext extends ParserRuleContext {
		public TerminalNode TK_INT() { return getToken(PajeParserParser.TK_INT, 0); }
		public Event_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterEvent_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitEvent_id(this);
		}
	}

	public final Event_idContext event_id() throws RecognitionException {
		Event_idContext _localctx = new Event_idContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_event_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(TK_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitFields(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				field();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_EVENT_DEF );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode TK_EVENT_DEF() { return getToken(PajeParserParser.TK_EVENT_DEF, 0); }
		public Field_nameContext field_name() {
			return getRuleContext(Field_nameContext.class,0);
		}
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public TerminalNode TK_BREAK() { return getToken(PajeParserParser.TK_BREAK, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(TK_EVENT_DEF);
			setState(56);
			field_name();
			setState(57);
			field_type();
			setState(58);
			match(TK_BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_nameContext extends ParserRuleContext {
		public TerminalNode TK_EVENT_DEF_ALIAS() { return getToken(PajeParserParser.TK_EVENT_DEF_ALIAS, 0); }
		public TerminalNode TK_EVENT_DEF_TYPE() { return getToken(PajeParserParser.TK_EVENT_DEF_TYPE, 0); }
		public TerminalNode TK_EVENT_DEF_NAME() { return getToken(PajeParserParser.TK_EVENT_DEF_NAME, 0); }
		public TerminalNode TK_EVENT_DEF_COLOR() { return getToken(PajeParserParser.TK_EVENT_DEF_COLOR, 0); }
		public TerminalNode TK_EVENT_DEF_START_CONTAINER_TYPE() { return getToken(PajeParserParser.TK_EVENT_DEF_START_CONTAINER_TYPE, 0); }
		public TerminalNode TK_EVENT_DEF_END_CONTAINER_TYPE() { return getToken(PajeParserParser.TK_EVENT_DEF_END_CONTAINER_TYPE, 0); }
		public TerminalNode TK_EVENT_DEF_CONTAINER() { return getToken(PajeParserParser.TK_EVENT_DEF_CONTAINER, 0); }
		public TerminalNode TK_EVENT_DEF_TIME() { return getToken(PajeParserParser.TK_EVENT_DEF_TIME, 0); }
		public TerminalNode TK_EVENT_DEF_START_CONTAINER() { return getToken(PajeParserParser.TK_EVENT_DEF_START_CONTAINER, 0); }
		public TerminalNode TK_EVENT_DEF_END_CONTAINER() { return getToken(PajeParserParser.TK_EVENT_DEF_END_CONTAINER, 0); }
		public TerminalNode TK_EVENT_DEF_VALUE() { return getToken(PajeParserParser.TK_EVENT_DEF_VALUE, 0); }
		public TerminalNode TK_EVENT_DEF_KEY() { return getToken(PajeParserParser.TK_EVENT_DEF_KEY, 0); }
		public TerminalNode TK_EVENT_DEF_LINE() { return getToken(PajeParserParser.TK_EVENT_DEF_LINE, 0); }
		public TerminalNode TK_EVENT_DEF_FILE() { return getToken(PajeParserParser.TK_EVENT_DEF_FILE, 0); }
		public TerminalNode TK_STRING() { return getToken(PajeParserParser.TK_STRING, 0); }
		public Field_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterField_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitField_name(this);
		}
	}

	public final Field_nameContext field_name() throws RecognitionException {
		Field_nameContext _localctx = new Field_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_EVENT_DEF_ALIAS) | (1L << TK_EVENT_DEF_TYPE) | (1L << TK_EVENT_DEF_NAME) | (1L << TK_EVENT_DEF_COLOR) | (1L << TK_EVENT_DEF_START_CONTAINER_TYPE) | (1L << TK_EVENT_DEF_END_CONTAINER_TYPE) | (1L << TK_EVENT_DEF_CONTAINER) | (1L << TK_EVENT_DEF_TIME) | (1L << TK_EVENT_DEF_START_CONTAINER) | (1L << TK_EVENT_DEF_END_CONTAINER) | (1L << TK_EVENT_DEF_VALUE) | (1L << TK_EVENT_DEF_KEY) | (1L << TK_EVENT_DEF_LINE) | (1L << TK_EVENT_DEF_FILE) | (1L << TK_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_typeContext extends ParserRuleContext {
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_STRING() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_STRING, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_FLOAT() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_FLOAT, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_DOUBLE() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_DOUBLE, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_INT() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_INT, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_HEX() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_HEX, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_DATE() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_DATE, 0); }
		public TerminalNode TK_EVENT_DEF_FIELD_TYPE_COLOR() { return getToken(PajeParserParser.TK_EVENT_DEF_FIELD_TYPE_COLOR, 0); }
		public Field_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterField_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitField_type(this);
		}
	}

	public final Field_typeContext field_type() throws RecognitionException {
		Field_typeContext _localctx = new Field_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_field_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_EVENT_DEF_FIELD_TYPE_STRING) | (1L << TK_EVENT_DEF_FIELD_TYPE_FLOAT) | (1L << TK_EVENT_DEF_FIELD_TYPE_DOUBLE) | (1L << TK_EVENT_DEF_FIELD_TYPE_INT) | (1L << TK_EVENT_DEF_FIELD_TYPE_HEX) | (1L << TK_EVENT_DEF_FIELD_TYPE_DATE) | (1L << TK_EVENT_DEF_FIELD_TYPE_COLOR))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventsContext extends ParserRuleContext {
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public EventsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_events; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterEvents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitEvents(this);
		}
	}

	public final EventsContext events() throws RecognitionException {
		EventsContext _localctx = new EventsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_events);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				event();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_BREAK || _la==TK_INT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public Non_empty_eventContext non_empty_event() {
			return getRuleContext(Non_empty_eventContext.class,0);
		}
		public Empty_eventContext empty_event() {
			return getRuleContext(Empty_eventContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitEvent(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_event);
		try {
			setState(71);
			switch (_input.LA(1)) {
			case TK_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				non_empty_event();
				}
				break;
			case TK_BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				empty_event();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_empty_eventContext extends ParserRuleContext {
		public TerminalNode TK_INT() { return getToken(PajeParserParser.TK_INT, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode TK_BREAK() { return getToken(PajeParserParser.TK_BREAK, 0); }
		public Non_empty_eventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_empty_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterNon_empty_event(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitNon_empty_event(this);
		}
	}

	public final Non_empty_eventContext non_empty_event() throws RecognitionException {
		Non_empty_eventContext _localctx = new Non_empty_eventContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_non_empty_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(TK_INT);
			setState(74);
			arguments();
			setState(75);
			match(TK_BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Empty_eventContext extends ParserRuleContext {
		public TerminalNode TK_BREAK() { return getToken(PajeParserParser.TK_BREAK, 0); }
		public Empty_eventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterEmpty_event(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitEmpty_event(this);
		}
	}

	public final Empty_eventContext empty_event() throws RecognitionException {
		Empty_eventContext _localctx = new Empty_eventContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_empty_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(TK_BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				argument();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_STRING))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode TK_STRING() { return getToken(PajeParserParser.TK_STRING, 0); }
		public TerminalNode TK_FLOAT() { return getToken(PajeParserParser.TK_FLOAT, 0); }
		public TerminalNode TK_INT() { return getToken(PajeParserParser.TK_INT, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PajeParserListener ) ((PajeParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\6\3%\n\3"+
		"\r\3\16\3&\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7\66"+
		"\n\7\r\7\16\7\67\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13D\n\13\r"+
		"\13\16\13E\3\f\3\f\5\fJ\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\6\17S\n\17"+
		"\r\17\16\17T\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36\2\6\3\2\n\33\4\2\34)\63\63\3\2*\60\3\2\61\63N\2 \3\2\2\2\4$\3\2\2"+
		"\2\6(\3\2\2\2\b\60\3\2\2\2\n\62\3\2\2\2\f\65\3\2\2\2\169\3\2\2\2\20>\3"+
		"\2\2\2\22@\3\2\2\2\24C\3\2\2\2\26I\3\2\2\2\30K\3\2\2\2\32O\3\2\2\2\34"+
		"R\3\2\2\2\36V\3\2\2\2 !\5\4\3\2!\"\5\24\13\2\"\3\3\2\2\2#%\5\6\4\2$#\3"+
		"\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2()\7\b\2\2)*\5\b\5\2"+
		"*+\5\n\6\2+,\7\3\2\2,-\5\f\7\2-.\7\t\2\2./\7\3\2\2/\7\3\2\2\2\60\61\t"+
		"\2\2\2\61\t\3\2\2\2\62\63\7\61\2\2\63\13\3\2\2\2\64\66\5\16\b\2\65\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\r\3\2\2\29:\7\7\2\2"+
		":;\5\20\t\2;<\5\22\n\2<=\7\3\2\2=\17\3\2\2\2>?\t\3\2\2?\21\3\2\2\2@A\t"+
		"\4\2\2A\23\3\2\2\2BD\5\26\f\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"F\25\3\2\2\2GJ\5\30\r\2HJ\5\32\16\2IG\3\2\2\2IH\3\2\2\2J\27\3\2\2\2KL"+
		"\7\61\2\2LM\5\34\17\2MN\7\3\2\2N\31\3\2\2\2OP\7\3\2\2P\33\3\2\2\2QS\5"+
		"\36\20\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\35\3\2\2\2VW\t\5\2\2"+
		"W\37\3\2\2\2\7&\67EIT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}