package br.ufrgs.inf.tlbellini.lib;

public class PajeCategorizedEvent extends PajeEvent {
	
	private PajeValue value;

	public PajeCategorizedEvent(PajeTraceEvent event, PajeContainer container, PajeType type) {
		super(event, container, type);
	}

	public PajeValue getValue() {
		return value;
	}

	public void setValue(PajeValue value) {
		this.value = value;
	}

}
