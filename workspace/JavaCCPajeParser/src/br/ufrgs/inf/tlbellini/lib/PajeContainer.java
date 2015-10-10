package br.ufrgs.inf.tlbellini.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PajeContainer extends PajeNamedEntity {
	
	private double stopSimulationAt;
	private boolean destroyed;
	
	public String alias;
	public Map<String, PajeContainer> children = new HashMap<String, PajeContainer>();
	public int depth;
	
	private Map<PajeType, String> linksUsedKeys = new HashMap<PajeType, String>(); //used keys for this container
	private Map<PajeType, Map<String, PajeUserLink>> pendingLinks;
	
	private Map<PajeType, ArrayList<PajeUserState>> stackStates = new HashMap<PajeType, ArrayList<PajeUserState>>(); //stack for state types
	// keep all simulated entities
	
	private Map<PajeType, ArrayList<PajeEntity>> entities = new HashMap<PajeType, ArrayList<PajeEntity>>();
	
	
	public PajeContainer(double time, String name, String alias, PajeContainer parent, PajeType type, PajeTraceEvent event){
		super(parent, type, time, name, event);
		this.alias = alias;
		this.setDestroyed(false);
		this.setStopSimulationAt(-1);
		if(parent != null){
			this.depth = parent.depth +1;
		}else
			this.depth = 0;
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
		
	/* NECESSARY??? To make the methods private */
	public void demuxer(PajeEvent event) throws Exception{
		
		//if Container destroyed, can't do anything (maybe an exception??)
		if(this.destroyed){
			return;
		}
		/*double lastKnownTime = event.getTime();
		 *
		 * deciding if necessary
		if(this.stopSimulationAt != -1){
			if(lastKnownTime > this.stopSimulationAt){
				pajeDestroyContainer(stopSimulationAt, event);
				return;
			}
		}*/
		
		//call the method to be simulated
		PajeEventId eventId = event.getEvent().getPajeEventDef().getPajeEventId();
		callEventMethod(eventId, event);
		
		this.setEndTime(event.getTime());
	}
	

	private void callEventMethod(PajeEventId eventId, PajeEvent event) throws Exception {
		switch(eventId){
		case PajeDestroyContainer: pajeDestroyContainer(event);
		break;
		case PajeSetState: pajeSetState((PajeStateEvent) event);
		break;
		case PajePushState: pajePushState((PajeStateEvent) event);
		break;
		case PajePopState: pajePopState((PajeStateEvent) event);
		break;
		case PajeResetState: pajeResetState(event);
		break;
		case PajeNewEvent: pajeNewEvent((PajeEventEvent) event);
		break;
		case PajeSetVariable: pajeSetVariable((PajeVariableEvent) event);
		break;
		case PajeAddVariable: pajeAddVariable((PajeVariableEvent) event);
		default: break;
		}
		
	}

	private void pajeDestroyContainer(PajeEvent event) throws Exception {
		
		if(this.destroyed){
			throw new Exception ("Container "+ this.alias + " already destroyed ");
		}
		
		destroy(event.getTime());
		
	}
	
	private void destroy (double time){
		
		this.setDestroyed(true);
		this.setEndTime(time);
		
		//finish all entities
		for(Map.Entry<PajeType, ArrayList<PajeEntity>> entry : this.entities.entrySet()){
			for(PajeEntity ent : entry.getValue()){
				//TODO salvar no bd e remover
				((PajeDoubleTimedEntity) ent).setEndTime(time);
			}
		}
		
		//check pending links
		//TODO
		
		//end stack 
		for(Map.Entry<PajeType, ArrayList<PajeUserState>> entry : this.stackStates.entrySet()){
			for(PajeEntity ent : entry.getValue()){
				//TODO salvar no bd e remover
				((PajeDoubleTimedEntity) ent).setEndTime(time);
			}
		}
	}
	
	private void pajeSetState(PajeStateEvent event) throws Exception{
		
		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		pajeResetState(event);
		
		PajeUserState newState = new PajeUserState(this, type, time, value, traceEvent);
		newState.setImbrication(0);
		//create entry if empty
		if(this.entities.isEmpty() || !this.entities.containsKey(type))
			this.entities.put(type, new ArrayList<PajeEntity>());
		if(this.stackStates.isEmpty() || !this.stackStates.containsKey(type))
			this.stackStates.put(type, new ArrayList<PajeUserState>());
		
		this.entities.get(type).add(newState);
		this.stackStates.get(type).add(newState);
		
	}
	
private void pajePushState(PajeStateEvent event) throws Exception{
		
		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		
		checkTimeOrder(event);
		
		//does not create if doesn't exist
		if(this.entities.isEmpty() || !this.entities.containsKey(type))
			throw new Exception("A Push State for type " + type.getAlias() + " was done in line " + traceEvent.getLine() + " before a Set State for the type");
		if(this.stackStates.isEmpty() || !this.stackStates.containsKey(type))
			throw new Exception("A Push State for type " + type.getAlias() + " was done in line " + traceEvent.getLine() + " before a Set State for the type");
		
		PajeUserState newState = new PajeUserState(this, type, time, value, traceEvent);
		//check if correct: assuming 0, 1 , 2 ...
		newState.setImbrication(this.stackStates.size());
		
		this.entities.get(type).add(newState);
		this.stackStates.get(type).add(newState);
		
	}

	// will be the last? searches the hash for type and gets the last
	private void pajePopState(PajeStateEvent event) throws Exception {
		PajeType type = event.getType();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		
		checkTimeOrder(event);
		
		//get last push from that type
		if(!this.entities.isEmpty() && this.entities.containsKey(type)){
				((PajeDoubleTimedEntity) this.entities.get(type).get(this.entities.get(type).size()-1)).setEndTime(time);
				//TODO actually remove
		}else{
			throw new Exception("Trying to Pop a State of type "+ type.getAlias() + " that was not previously Pushed in line " + traceEvent.getLine());
		}
		
		if(!this.stackStates.isEmpty() && this.stackStates.containsKey(type)){
			this.stackStates.get(type).get(this.stackStates.get(type).size() -1).setEndTime(time);
			//TODO actually remove
		}else{
			throw new Exception("Trying to Pop a State of type "+ type.getAlias() + " that was not previously Pushed in line " + traceEvent.getLine());
		}
	}
	
	private void pajeNewEvent(PajeEventEvent event) throws Exception{
		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		
		checkTimeOrder(event);
		PajeUserEvent newEvent = new PajeUserEvent(this, type, time, value, traceEvent);
		
		//check if the type for the event exists in container
		if(this.entities.isEmpty() || !this.entities.containsKey(type))
			this.entities.put(type, new ArrayList<PajeEntity>());
		this.entities.get(type).add(newEvent);
		
	}
	
	private void pajeSetVariable(PajeVariableEvent event) throws Exception{
		double time = event.getTime();
		PajeType type = event.getType();
		double value = event.getDoubleValue();
		PajeTraceEvent traceEvent = event.getEvent();
		
		checkTimeOrder(event);
		
		if(!this.entities.containsKey(type))
			this.entities.put(type, new ArrayList<PajeEntity>());
		
		//if same timestamp, just replaces value
		if(!this.entities.get(type).isEmpty()){
			PajeEntity last = this.entities.get(type).get(this.entities.get(type).size() -1);
	
			if(((PajeUserVariable) last).getStartTime() == time){
				((PajeUserVariable) last).setValue(value);
				return;				
			}else{
				((PajeDoubleTimedEntity) last).setEndTime(time);
			}
		}
		
		PajeUserVariable newValue = new PajeUserVariable(this, type, time, value, traceEvent);		
		this.entities.get(type).add(newValue);	
	}
	
	private void pajeAddVariable(PajeVariableEvent event) throws Exception{
		double time = event.getTime();
		PajeType type = event.getType();
		double value = event.getDoubleValue();
		PajeTraceEvent traceEvent = event.getEvent();
		double lastVal = 0;
			
		if(!this.entities.containsKey(type) || this.entities.get(type).isEmpty())
			throw new Exception("Illegal addition to a variable that has no value (yet) in "+ traceEvent.getLine());
		
		checkTimeOrder(event);
		
		PajeEntity last = this.entities.get(type).get(this.entities.get(type).size() -1);
		if(((PajeUserVariable) last).getStartTime() == time){
			((PajeUserVariable) last).addValue(value);
			return;				
		}else{
			((PajeDoubleTimedEntity) last).setEndTime(time);
			//TODO put in bd
		}
		lastVal = ((PajeUserVariable) last).getValue();
		
		//add variable with new value
		PajeUserVariable newValue = new PajeUserVariable(this, type, time, lastVal + value, traceEvent);		
		this.entities.get(type).add(newValue);
		
	}
	
	//check if trace is correctly ordered
	// check if correct
	public boolean checkTimeOrder(PajeEvent event) throws Exception{
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		
		 if(!this.entities.isEmpty()){
			 if(this.entities.containsKey(event.getType())){
				 ArrayList<PajeEntity> v = this.entities.get(event.getType());
				if(!v.isEmpty()){
					PajeSingleTimedEntity last = (PajeSingleTimedEntity) v.get(v.size()-1);
					if((last.getStartTime() > time) || last.getEndTime() != -1 && last.getEndTime() > time){
						throw new Exception ("Trace is not time-ordered	in "+ traceEvent.getLine());
					}
				}
			 }
		}
		return true;
	}
	
	public void pajeResetState (PajeEvent event) throws Exception{
		checkTimeOrder (event);
		
		if(!this.stackStates.isEmpty()){
			if(stackStates.containsKey(event.getType())){
				for (PajeUserState state : this.stackStates.get(event.getType())){
					state.setEndTime(event.getTime());
					// TODO clear stack and save db
				}
			}
		}
	}

}
