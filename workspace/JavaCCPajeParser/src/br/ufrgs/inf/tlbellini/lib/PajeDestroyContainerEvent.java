package br.ufrgs.inf.tlbellini.lib;

public class PajeDestroyContainerEvent extends PajeEvent {

	public PajeDestroyContainerEvent(PajeTraceEvent event, PajeContainer container, PajeType type) {
		super(event, container, type);
	}

}
