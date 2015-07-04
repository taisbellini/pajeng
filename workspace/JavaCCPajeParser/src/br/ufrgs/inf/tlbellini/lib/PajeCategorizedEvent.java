package br.ufrgs.inf.tlbellini.lib;

public class PajeCategorizedEvent extends PajeEvent {
	
	private PajeValue value;

	public PajeCategorizedEvent() {
		// TODO Auto-generated constructor stub
	}

	public PajeValue getValue() {
		return value;
	}

	public void setValue(PajeValue value) {
		this.value = value;
	}

}
