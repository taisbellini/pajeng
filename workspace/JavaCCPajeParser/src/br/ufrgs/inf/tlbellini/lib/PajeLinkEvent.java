package br.ufrgs.inf.tlbellini.lib;

public class PajeLinkEvent extends PajeCategorizedEvent {
	
	//protected PajeContainer linkedContainer;
	
	private String key;

	public PajeLinkEvent(PajeTraceEvent event, PajeContainer container, PajeType type, double time) {
		super(event, container, type, time);
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}

}
