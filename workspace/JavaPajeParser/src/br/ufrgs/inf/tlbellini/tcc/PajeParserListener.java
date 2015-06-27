// Generated from PajeParser.g4 by ANTLR 4.5

	package br.ufrgs.inf.tlbellini.tcc;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PajeParserParser}.
 */
public interface PajeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#paje}.
	 * @param ctx the parse tree
	 */
	void enterPaje(PajeParserParser.PajeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#paje}.
	 * @param ctx the parse tree
	 */
	void exitPaje(PajeParserParser.PajeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(PajeParserParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(PajeParserParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PajeParserParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PajeParserParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#event_name}.
	 * @param ctx the parse tree
	 */
	void enterEvent_name(PajeParserParser.Event_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#event_name}.
	 * @param ctx the parse tree
	 */
	void exitEvent_name(PajeParserParser.Event_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#event_id}.
	 * @param ctx the parse tree
	 */
	void enterEvent_id(PajeParserParser.Event_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#event_id}.
	 * @param ctx the parse tree
	 */
	void exitEvent_id(PajeParserParser.Event_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(PajeParserParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(PajeParserParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PajeParserParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PajeParserParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#field_name}.
	 * @param ctx the parse tree
	 */
	void enterField_name(PajeParserParser.Field_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#field_name}.
	 * @param ctx the parse tree
	 */
	void exitField_name(PajeParserParser.Field_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#field_type}.
	 * @param ctx the parse tree
	 */
	void enterField_type(PajeParserParser.Field_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#field_type}.
	 * @param ctx the parse tree
	 */
	void exitField_type(PajeParserParser.Field_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#events}.
	 * @param ctx the parse tree
	 */
	void enterEvents(PajeParserParser.EventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#events}.
	 * @param ctx the parse tree
	 */
	void exitEvents(PajeParserParser.EventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(PajeParserParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(PajeParserParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#non_empty_event}.
	 * @param ctx the parse tree
	 */
	void enterNon_empty_event(PajeParserParser.Non_empty_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#non_empty_event}.
	 * @param ctx the parse tree
	 */
	void exitNon_empty_event(PajeParserParser.Non_empty_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#empty_event}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_event(PajeParserParser.Empty_eventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#empty_event}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_event(PajeParserParser.Empty_eventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PajeParserParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PajeParserParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PajeParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PajeParserParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PajeParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PajeParserParser.ArgumentContext ctx);
}