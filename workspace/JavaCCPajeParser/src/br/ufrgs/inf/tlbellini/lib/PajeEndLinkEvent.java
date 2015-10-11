package br.ufrgs.inf.tlbellini.lib;

public class PajeEndLinkEvent extends PajeLinkEvent {

	public PajeEndLinkEvent(PajeTraceEvent event, PajeContainer container, PajeType type, double time, PajeValue value, String key) {
		super(event, container, container, type, time, value, key);
	}

}
