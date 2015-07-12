package br.ufrgs.inf.tlbellini.lib;

import java.util.Map;

public class PajeContainer extends PajeNamedEntity {
	
	private double stopSimulationAt;
	public String alias;
	public Map<String, PajeContainer> children;
	int depth;
	
	public PajeContainer(double time, String name, String alias, PajeContainer parent, PajeType type, PajeTraceEvent event){
		super(parent, type, time, name, event);
		this.alias = alias;
	}
	
	public String getId(){
		return alias.isEmpty() ? this.getName() : alias; 
	}

	

}
