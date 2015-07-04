package br.ufrgs.inf.tlbellini.lib;

import java.util.Map;

public class PajeEntity extends PajeObject {


	//private PajeContainer
	private PajeType type;
	Map<String, String> extraFields;
	
	
	public PajeEntity() {
		// TODO Auto-generated constructor stub
	}


	public PajeType getType() {
		return type;
	}


	public void setType(PajeType type) {
		this.type = type;
	}

}
