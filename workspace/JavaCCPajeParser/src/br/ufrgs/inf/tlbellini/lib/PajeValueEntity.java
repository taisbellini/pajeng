package br.ufrgs.inf.tlbellini.lib;

public class PajeValueEntity extends PajeDoubleTimedEntity {
	
	PajeValue value;

	public PajeValueEntity(PajeContainer container,PajeType type, double startTime,PajeValue value,PajeTraceEvent event) {
		super(container, type, startTime, event);
	}

}
