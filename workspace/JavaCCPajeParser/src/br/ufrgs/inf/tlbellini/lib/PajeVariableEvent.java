package br.ufrgs.inf.tlbellini.lib;

public class PajeVariableEvent extends PajeEvent {
	
	private double doubleValue;

	public PajeVariableEvent(PajeTraceEvent event, PajeContainer container, PajeType type) {
		super(event, container, type);
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

}
