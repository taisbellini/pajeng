package br.ufrgs.inf.tlbellini.lib;

public class PajeUserState extends PajeValueEntity {
	
	private double imbrication;

	public PajeUserState(PajeContainer container, PajeType type, double startTime, PajeValue value, PajeTraceEvent event) {
		super(container, type, startTime, value, event);
		System.out.println("new state ok");
	}

	public double getImbrication() {
		return imbrication;
	}

	public void setImbrication(double imbrication) {
		this.imbrication = imbrication;
		System.out.println("set imb ok");
	}

}
