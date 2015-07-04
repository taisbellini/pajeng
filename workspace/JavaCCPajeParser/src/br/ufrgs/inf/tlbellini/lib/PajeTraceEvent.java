package br.ufrgs.inf.tlbellini.lib;

import java.util.Vector;

public class PajeTraceEvent extends PajeObject {
	
	private int line;
	private Vector<String> fields;
	private PajeEventDefinition pajeEventDef;
	
	public PajeTraceEvent(){
		this.setLine(-1);
	};
	
	public PajeTraceEvent(int line){
		this.setLine(line);
	}
	
	public PajeTraceEvent(PajeEventDefinition event){
		//to do
	}
	
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}

}
