package br.ufrgs.inf.tlbellini.lib;

public class PajeUserEvent extends PajeSingleTimedEntity {
	
	private PajeValue value;

	public PajeUserEvent() {
		// TODO Auto-generated constructor stub
	}

	public PajeValue getValue() {
		return value;
	}

	public void setValue(PajeValue value) {
		this.value = value;
	}

}
