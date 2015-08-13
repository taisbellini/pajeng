package br.ufrgs.inf.tlbellini.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PajeContainer extends PajeNamedEntity {
	
	private double stopSimulationAt;
	private boolean destroyed;
	
	public String alias;
	public Map<String, PajeContainer> children = new HashMap<String, PajeContainer>();
	public int depth;
	
	private Map<PajeType, String> linksUsedKeys = new HashMap<PajeType, String>(); //used keys for this container
	private Map<PajeType, Map<String, PajeUserLink>> pendingLinks;
	private Map<PajeType, ArrayList<PajeUserState>> stackStates; //stack for state types
	
	// keep all simulated entities
	private Map<PajeType, ArrayList<PajeEntity>> entities;
	
	
	public PajeContainer(double time, String name, String alias, PajeContainer parent, PajeType type, PajeTraceEvent event){
		super(parent, type, time, name, event);
		this.alias = alias;
		this.setDestroyed(false);
		this.setStopSimulationAt(-1);
	}
	
	public PajeContainer(double time, String name, String alias, PajeContainer parent, PajeType type, PajeTraceEvent event, double stopAt){
		super(parent, type, time, name, event);
		this.alias = alias;
		this.setDestroyed(false);
		this.setStopSimulationAt(stopAt);
		if(parent != null){
			this.depth = parent.depth +1;
		}else
			this.depth = 0;
	}
	
	public String getId(){
		return alias.isEmpty() ? this.getName() : alias; 
	}
	
	public void addChildren(String id, PajeContainer child){
		this.children.put(id, child);
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public double getStopSimulationAt() {
		return stopSimulationAt;
	}

	public void setStopSimulationAt(double stopSimulationAt) {
		this.stopSimulationAt = stopSimulationAt;
	}
	
	public boolean isAncestorof(PajeContainer c){
		if(this.children.containsKey(c))
			return true;
		else
			return false;
	}
	
	public void demuxer(PajeEvent event) throws Exception{
		
		if(this.destroyed){
			return;
		}
		
		double lastKnownTime = event.getTime();
		
		if(this.stopSimulationAt != -1){
			if(lastKnownTime > this.stopSimulationAt){
				pajeDestroyContainer(stopSimulationAt, event);
				return;
			}
		}
		
		//call the method to be simulated
		PajeEventId eventId = event.getEvent().getPajeEventDef().getPajeEventId();
		callEventMethod(eventId, event);
	}
	

	private void callEventMethod(PajeEventId eventId, PajeEvent event) throws Exception {
		switch(eventId){
		case PajeDestroyContainer: pajeDestroyContainer(event.getTime(), event);
		break;
		default: break;
		}
		
	}

	private void pajeDestroyContainer(double time, PajeEvent event) throws Exception {
		if(this.destroyed){
			throw new Exception ("Container "+ this.alias + " already destroyed");
		}
		
		destroy(time);
		
	}
	
	private void destroy (double time){
		this.setDestroyed(true);
		this.setEndTime(time);
		
		//finish all entities
		//TODO
		
		//check pending links
		//TODO
		
		//end stack 
		//TODO
	}

}
