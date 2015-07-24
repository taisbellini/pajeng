package br.ufrgs.inf.tlbellini.lib;

public class PajeAddVariableEvent extends PajeVariableEvent{

	public PajeAddVariableEvent(PajeTraceEvent event, PajeContainer container, PajeType type) {
		super(event, container, type);
	}

}
