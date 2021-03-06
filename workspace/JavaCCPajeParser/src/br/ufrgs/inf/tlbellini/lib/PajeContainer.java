package br.ufrgs.inf.tlbellini.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import java.sql.PreparedStatement;

import br.ufrgs.inf.tlbellini.PajeGrammar;

public class PajeContainer extends PajeNamedEntity {

	private double stopSimulationAt;
	private boolean destroyed;

	public String alias;
	public Map<String, PajeContainer> children = new HashMap<String, PajeContainer>();
	public int depth;

	private Map<PajeType, Set<String>> linksUsedKeys = new HashMap<PajeType, Set<String>>(); // used
																								// keys
																								// for
																								// this
																								// container
	private Map<PajeType, Map<String, PajeUserLink>> pendingLinks = new HashMap<PajeType, Map<String, PajeUserLink>>();

	private Map<PajeType, ArrayList<PajeUserState>> stackStates = new HashMap<PajeType, ArrayList<PajeUserState>>(); // stack
																														// for
																														// state
																														// types
	// keep all simulated entities

	private Map<PajeType, ArrayList<PajeEntity>> entities = new HashMap<PajeType, ArrayList<PajeEntity>>();
	
	

	public PajeContainer(double time, String name, String alias, PajeContainer parent, PajeType type,
			PajeTraceEvent event) {
		super(parent, type, time, name, event);
		this.alias = alias;
		this.setDestroyed(false);
		this.setStopSimulationAt(-1);
		if (parent != null) {
			this.depth = parent.depth + 1;
		} else
			this.depth = 0;

		// insert container in DB so that it can be referred throughout the
		// simulation
		String sql = PajeGrammar.db.generateInsertContainerSQL(alias, name, time, -1,
				parent != null ? parent.alias : "null", type.alias, PajeGrammar.fileId);
		PajeGrammar.db.insert(sql);
	}

	public String getId() {
		return alias.isEmpty() ? this.getName() : alias;
	}

	public void addChildren(String id, PajeContainer child) {
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
	public void demuxer(PajeEvent event) throws Exception {

		// CHECK WITH END TIME OF CONTAINER IF IS A DESTROY
		if (event.getEvent().getPajeEventDef().getPajeEventId().equals(PajeEventId.PajeDestroyContainer)) {
			if (event.getTime() < this.getEndTime()) {
				throw new Exception("Illegal, container events are not time-ordered in " + event.getEvent().getLine());
			}
		}

		// if Container destroyed, can't do anything (maybe an exception??)
		if (this.destroyed) {
			return;
		}

		// call the method to be simulated
		PajeEventId eventId = event.getEvent().getPajeEventDef().getPajeEventId();
		callEventMethod(eventId, event);

		this.setEndTime(event.getTime());
	}

	private void callEventMethod(PajeEventId eventId, PajeEvent event) throws Exception {
		switch (eventId) {
		case PajeDestroyContainer:
			pajeDestroyContainer(event);
			break;
		case PajeSetState:
			pajeSetState((PajeStateEvent) event);
			break;
		case PajePushState:
			pajePushState((PajeStateEvent) event);
			break;
		case PajePopState:
			pajePopState((PajeStateEvent) event);
			break;
		case PajeResetState:
			pajeResetState(event);
			break;
		case PajeNewEvent:
			pajeNewEvent((PajeEventEvent) event);
			break;
		case PajeSetVariable:
			pajeSetVariable((PajeVariableEvent) event);
			break;
		case PajeAddVariable:
			pajeAddVariable((PajeVariableEvent) event);
			break;
		case PajeSubVariable:
			pajeSubVariable((PajeVariableEvent) event);
			break;
		case PajeStartLink:
			pajeStartLink((PajeLinkEvent) event);
			break;
		case PajeEndLink:
			pajeEndLink((PajeLinkEvent) event);
			break;
		default:
			break;
		}

	}

	private void pajeDestroyContainer(PajeEvent event) throws Exception {

		if (this.destroyed) {
			throw new Exception("Container " + this.alias + " already destroyed ");
		}

		destroy(event.getTime());

	}

	private void destroy(double time) throws Exception {

		this.setDestroyed(true);
		this.setEndTime(time);
		PajeGrammar.db.setEndContainerDB(alias, PajeGrammar.fileId, time);

		// finish all entities - set end time in last entity of array
		
		for (Map.Entry<PajeType, ArrayList<PajeEntity>> entry : this.getEntities().entrySet()) {
			ArrayList<PajeEntity> list = entry.getValue();
			if (!list.isEmpty()) {
				// if event, no need to set end time
				if ((list.get(list.size() - 1).getType().getNature() != PajeTypeNature.EventType)
						&& ((PajeDoubleTimedEntity) list.get(list.size() - 1)).getEndTime() == -1)
					((PajeDoubleTimedEntity) list.get(list.size() - 1)).setEndTime(time);
			}

		}

		// check pending links
		for (Map.Entry<PajeType, Map<String, PajeUserLink>> links : this.pendingLinks.entrySet()) {
			if (!links.getValue().isEmpty())
				throw new Exception("Can't destroy container " + this.alias + " because it has pending links");

		}
		// end stack
		for (Map.Entry<PajeType, ArrayList<PajeUserState>> entry : this.stackStates.entrySet()) {
			for (PajeUserState ent : entry.getValue()) {
				// just add to db, the setEndTime was done in the above "for"for
				// entities
				// String sql =
				// PajeGrammar.db.generateInsertStateSQL(((PajeSingleTimedEntity)
				// ent).getStartTime(),
				// ((PajeDoubleTimedEntity) ent).getEndTime(),
				// ent.getType().getAlias(), ((PajeValueEntity)
				// ent).getValue().getAlias(), this.alias, ((PajeUserState)
				// ent).getImbrication(), PajeGrammar.fileId);
				// PajeGrammar.db.insert(sql);
				
				PajeGrammar.simulator.stmtState.setString(1, this.alias);
				PajeGrammar.simulator.stmtState.setString(2, ent.getType().alias);
				PajeGrammar.simulator.stmtState.setDouble(3, ent.getStartTime());
				PajeGrammar.simulator.stmtState.setDouble(4, ent.getEndTime());
				PajeGrammar.simulator.stmtState.setString(5, ent.getValue().getAlias());
				PajeGrammar.simulator.stmtState.setDouble(6, ent.getImbrication());
				PajeGrammar.simulator.stmtState.setInt(7, PajeGrammar.fileId);
				
				PajeGrammar.simulator.stmtState.addBatch();
			}

		}
		this.recursiveDestroy(time);

	}

	private void pajeSetState(PajeStateEvent event) throws Exception {

		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();
		pajeResetState(event);

		PajeUserState newState = new PajeUserState(this, type, time, value, traceEvent);
		newState.setImbrication(0);
		// create entry if empty
		if (this.getEntities().isEmpty() || !this.getEntities().containsKey(type))
			this.getEntities().put(type, new ArrayList<PajeEntity>());
		if (this.stackStates.isEmpty() || !this.stackStates.containsKey(type))
			this.stackStates.put(type, new ArrayList<PajeUserState>());

		this.getEntities().get(type).add(newState);
		this.stackStates.get(type).add(newState);

	}

	private void pajePushState(PajeStateEvent event) throws Exception {

		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();

		checkTimeOrder(event);

		// does not create if doesn't exist
		// TODO examples given by Lucas were not following paje's documentation
		if (this.getEntities().isEmpty() || !this.getEntities().containsKey(type))
			// throw new Exception("A Push State for type " + type.getAlias() +
			// " was done in line " + traceEvent.getLine()
			// + " before a Set State for the type");
			this.getEntities().put(type, new ArrayList<PajeEntity>());
		if (this.stackStates.isEmpty() || !this.stackStates.containsKey(type))
			// throw new Exception("A Push State for type " + type.getAlias() +
			// " was done in line " + traceEvent.getLine()
			// + " before a Set State for the type");
			this.stackStates.put(type, new ArrayList<PajeUserState>());

		PajeUserState newState = new PajeUserState(this, type, time, value, traceEvent);
		newState.setImbrication(this.stackStates.size());

		this.getEntities().get(type).add(newState);
		this.stackStates.get(type).add(newState);

	}

	// will be the last? searches the hash for type and gets the last
	private void pajePopState(PajeStateEvent event) throws Exception {
		PajeType type = event.getType();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();

		checkTimeOrder(event);

		// get last push from that type
		PajeUserState state = (PajeUserState) this.getEntities().get(type).get(this.getEntities().get(type).size() - 1);

		if (!this.getEntities().isEmpty() && this.getEntities().containsKey(type)) {
			state.setEndTime(time);

			// only inserts here
			// String sql =
			// PajeGrammar.db.generateInsertStateSQL(state.getStartTime(), time,
			// type.alias, state.getValue().getAlias(), this.alias,
			// state.getImbrication(), PajeGrammar.fileId);
			// PajeGrammar.db.insert(sql);
			
			PajeGrammar.simulator.stmtState.setString(1, this.alias);
			PajeGrammar.simulator.stmtState.setString(2, state.getType().alias);
			PajeGrammar.simulator.stmtState.setDouble(3, state.getStartTime());
			PajeGrammar.simulator.stmtState.setDouble(4, state.getEndTime());
			PajeGrammar.simulator.stmtState.setString(5, state.getValue().getAlias());
			PajeGrammar.simulator.stmtState.setDouble(6, state.getImbrication());
			PajeGrammar.simulator.stmtState.setInt(7, PajeGrammar.fileId);
			
			PajeGrammar.simulator.stmtState.addBatch();
			
			this.getEntities().get(type).remove(state);


		} else {
			throw new Exception("Trying to Pop a State of type " + type.getAlias()
					+ " that was not previously Pushed in line " + traceEvent.getLine());
		}

		// remove from stack since it is in DB
		if (this.stackStates.isEmpty() || !this.stackStates.containsKey(type)) {
			this.stackStates.get(type).remove(state);

			// } else {
			throw new Exception("Trying to Pop a State of type " + type.getAlias()
					+ " that was not previously Pushed in line " + traceEvent.getLine());
		}
	}

	private void pajeNewEvent(PajeEventEvent event) throws Exception {
		PajeType type = event.getType();
		PajeValue value = event.getValue();
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();

		checkTimeOrder(event);
		PajeUserEvent newEvent = new PajeUserEvent(this, type, time, value, traceEvent);

		// check if the type for the event exists in container
		if (this.getEntities().isEmpty() || !this.getEntities().containsKey(type))
			this.getEntities().put(type, new ArrayList<PajeEntity>());
		// not necessary since it is in db
		this.getEntities().get(type).add(newEvent);

		//String sql = PajeGrammar.db.generateInsertEventSQL(time, type.alias, this.alias, value.getAlias(),
		//		PajeGrammar.fileId);
		//PajeGrammar.db.insert(sql);
		PajeGrammar.simulator.stmtEvent.setDouble(1, time);
		PajeGrammar.simulator.stmtEvent.setString(2, type.alias);
		PajeGrammar.simulator.stmtEvent.setString(3, this.alias);
		PajeGrammar.simulator.stmtEvent.setString(4, value.getAlias());
		PajeGrammar.simulator.stmtEvent.setInt(5, PajeGrammar.fileId);
		PajeGrammar.simulator.stmtEvent.addBatch();

	}

	private void pajeSetVariable(PajeVariableEvent event) throws Exception {
		double time = event.getTime();
		PajeType type = event.getType();
		double value = event.getDoubleValue();
		PajeTraceEvent traceEvent = event.getEvent();

		checkTimeOrder(event);

		if (!this.getEntities().containsKey(type))
			this.getEntities().put(type, new ArrayList<PajeEntity>());

		// if same timestamp, just replaces value
		if (!this.getEntities().get(type).isEmpty()) {
			PajeEntity last = this.getEntities().get(type).get(this.getEntities().get(type).size() - 1);

			if (((PajeUserVariable) last).getStartTime() == time) {
				((PajeUserVariable) last).setValue(value);
				return;
			} else {
				((PajeDoubleTimedEntity) last).setEndTime(time);
			}
		}

		PajeUserVariable newValue = new PajeUserVariable(this, type, time, value, traceEvent);
		this.getEntities().get(type).add(newValue);

		//String sql = PajeGrammar.db.generateInsertVariableSQL(time, type.alias, this.alias, value, -1,
		//		PajeGrammar.fileId);
		//PajeGrammar.db.insert(sql);
		
		PajeGrammar.simulator.stmtVariable.setDouble(1, time);
		PajeGrammar.simulator.stmtVariable.setString(2, type.alias);
		PajeGrammar.simulator.stmtVariable.setString(3, this.alias);
		PajeGrammar.simulator.stmtVariable.setDouble(4, value);
		PajeGrammar.simulator.stmtVariable.setDouble(5, -1);
		PajeGrammar.simulator.stmtVariable.setInt(6, PajeGrammar.fileId);
		PajeGrammar.simulator.stmtVariable.addBatch();
	}

	private void pajeAddVariable(PajeVariableEvent event) throws Exception {
		double time = event.getTime();
		PajeType type = event.getType();
		double value = event.getDoubleValue();
		PajeTraceEvent traceEvent = event.getEvent();
		double lastVal = 0;

		if (!this.getEntities().containsKey(type) || this.getEntities().get(type).isEmpty())
			throw new Exception("Illegal addition to a variable that has no value (yet) in " + traceEvent.getLine());

		checkTimeOrder(event);

		PajeEntity last = this.getEntities().get(type).get(this.getEntities().get(type).size() - 1);
		// get the first var to get the time it was set
		PajeEntity first = this.getEntities().get(type).get(0);

		if (((PajeUserVariable) last).getStartTime() == time) {
			((PajeUserVariable) last).addValue(value);
			return;
		} else {
			((PajeDoubleTimedEntity) last).setEndTime(time);
		}
		lastVal = ((PajeUserVariable) last).getValue();

		// add variable with new value
		PajeUserVariable newValue = new PajeUserVariable(this, type, time, lastVal + value, traceEvent);
		this.getEntities().get(type).add(newValue);

		//String sql = PajeGrammar.db.generateInsertVariableSQL(((PajeUserVariable) first).getStartTime(), type.alias,
		//		this.alias, newValue.getValue(), time, PajeGrammar.fileId);
		//PajeGrammar.db.insert(sql);
		
		PajeGrammar.simulator.stmtVariable.setDouble(1, ((PajeSingleTimedEntity) first).getStartTime());
		PajeGrammar.simulator.stmtVariable.setString(2, type.alias);
		PajeGrammar.simulator.stmtVariable.setString(3, this.alias);
		PajeGrammar.simulator.stmtVariable.setDouble(4, newValue.getValue());
		PajeGrammar.simulator.stmtVariable.setDouble(5, time);
		PajeGrammar.simulator.stmtVariable.setInt(6, PajeGrammar.fileId);
		PajeGrammar.simulator.stmtVariable.addBatch();
	}

	private void pajeSubVariable(PajeVariableEvent event) throws Exception {
		double time = event.getTime();
		PajeType type = event.getType();
		double value = event.getDoubleValue();
		PajeTraceEvent traceEvent = event.getEvent();
		double lastVal = 0;

		if (!this.getEntities().containsKey(type) || this.getEntities().get(type).isEmpty())
			throw new Exception("Illegal addition to a variable that has no value (yet) in " + traceEvent.getLine());

		checkTimeOrder(event);

		PajeEntity last = this.getEntities().get(type).get(this.getEntities().get(type).size() - 1);
		// get the first var to get the time it was set
		PajeEntity first = this.getEntities().get(type).get(0);

		if (((PajeUserVariable) last).getStartTime() == time) {
			((PajeUserVariable) last).subValue(value);
			return;
		} else {
			((PajeDoubleTimedEntity) last).setEndTime(time);
		}
		lastVal = ((PajeUserVariable) last).getValue();

		// add variable with new value
		PajeUserVariable newValue = new PajeUserVariable(this, type, time, lastVal - value, traceEvent);
		this.getEntities().get(type).add(newValue);

		//String sql = PajeGrammar.db.generateInsertVariableSQL(((PajeUserVariable) first).getStartTime(), type.alias,
			//	this.alias, newValue.getValue(), time, PajeGrammar.fileId);
		//PajeGrammar.db.insert(sql);
		
		PajeGrammar.simulator.stmtVariable.setDouble(1, ((PajeSingleTimedEntity) first).getStartTime());
		PajeGrammar.simulator.stmtVariable.setString(2, type.alias);
		PajeGrammar.simulator.stmtVariable.setString(3, this.alias);
		PajeGrammar.simulator.stmtVariable.setDouble(4, newValue.getValue());
		PajeGrammar.simulator.stmtVariable.setDouble(5, time);
		PajeGrammar.simulator.stmtVariable.setInt(6, PajeGrammar.fileId);
		PajeGrammar.simulator.stmtVariable.addBatch();
	}

	public void pajeStartLink(PajeLinkEvent event) throws Exception {
		double time = event.getTime();
		PajeType type = event.getType();
		String key = event.getKey();
		PajeValue value = event.getValue();
		PajeTraceEvent traceEvent = event.getEvent();
		PajeContainer startContainer = event.getLinkedContainer();

		if (this.linksUsedKeys.containsKey(type) && this.linksUsedKeys.get(type).contains(key)) {
			throw new Exception(
					"Illegal event in " + traceEvent.getLine() + ", the key was already used for another link");
		}

		if (!pendingLinks.containsKey(type))
			pendingLinks.put(type, new HashMap<String, PajeUserLink>());

		if (!pendingLinks.get(type).containsKey(key)) {
			PajeUserLink link = new PajeUserLink(this, type, time, value, key, startContainer, traceEvent);
			pendingLinks.get(type).put(key, link);
		} else {
			// there is a PajeEndLink
			PajeUserLink link = pendingLinks.get(type).get(key);
			link.setStartTime(time);
			link.setStartContainer(startContainer);

			// check the consistency between end and start links
			if (!link.getValue().equals(value))
				throw new Exception("Illegal PajeStartLink in " + traceEvent.getLine()
						+ ", value is different from the value of the corresponding PajeEndLink (which had "
						+ link.getValue().getAlias() + ")");

			checkTimeOrder(event);

			// probably not necessary
			if (!this.getEntities().containsKey(type))
				this.getEntities().put(type, new ArrayList<PajeEntity>());

			this.getEntities().get(type).add(link);

			//String sql = PajeGrammar.db.generateInsertLinkSQL(link.getStartTime(), link.getEndTime(), key,
				//	link.getValue().getAlias(), type.alias, link.getStartContainer().alias,
					//link.getEndContainer().alias, PajeGrammar.fileId);
			//PajeGrammar.db.insert(sql);
			
			PajeGrammar.simulator.stmtLink.setDouble(1, link.getStartTime());
			PajeGrammar.simulator.stmtLink.setDouble(2, link.getEndTime());
			PajeGrammar.simulator.stmtLink.setString(3, link.getKey());
			PajeGrammar.simulator.stmtLink.setString(4, link.getValue().getAlias());
			PajeGrammar.simulator.stmtLink.setString(5, link.getType().alias);
			PajeGrammar.simulator.stmtLink.setString(6, link.getStartContainer().alias);
			PajeGrammar.simulator.stmtLink.setString(7, link.getEndContainer().alias);
			PajeGrammar.simulator.stmtLink.setInt(8, PajeGrammar.fileId);
			PajeGrammar.simulator.stmtLink.addBatch();

			pendingLinks.get(type).remove(key);
			if (!linksUsedKeys.containsKey(type))
				linksUsedKeys.put(type, new HashSet<String>());
			linksUsedKeys.get(type).add(key);

		}
	}

	public void pajeEndLink(PajeLinkEvent event) throws Exception {
		double time = event.getTime();
		PajeType type = event.getType();
		String key = event.getKey();
		PajeValue value = event.getValue();
		PajeTraceEvent traceEvent = event.getEvent();
		PajeContainer endContainer = event.getLinkedContainer();

		if (this.linksUsedKeys.containsKey(type) && this.linksUsedKeys.get(type).contains(key)) {
			throw new Exception(
					"Illegal event in " + traceEvent.getLine() + ", the key was already used for another link");
		}

		if (!pendingLinks.containsKey(type))
			pendingLinks.put(type, new HashMap<String, PajeUserLink>());

		if (!pendingLinks.get(type).containsKey(key)) {
			PajeUserLink link = new PajeUserLink(this, type, time, value, key, null, traceEvent);
			link.setEndContainer(endContainer);
			pendingLinks.get(type).put(key, link);
		} else {
			// there is a PajeStartLink
			PajeUserLink link = pendingLinks.get(type).get(key);
			link.setEndTime(time);
			link.setEndContainer(endContainer);

			// check the consistency between end and start links
			if (!link.getValue().equals(value))
				throw new Exception("Illegal PajeEndLink in " + traceEvent.getLine()
						+ ", value is different from the value of the corresponding PajeStartLink (which had "
						+ link.getValue().getAlias() + ")");

			checkTimeOrder(event);

			if (!this.getEntities().containsKey(type))
				this.getEntities().put(type, new ArrayList<PajeEntity>());

			this.getEntities().get(type).add(link);

			//String sql = PajeGrammar.db.generateInsertLinkSQL(link.getStartTime(), link.getEndTime(), key,
			//		link.getValue().getAlias(), type.alias, link.getStartContainer().alias,
			//		link.getEndContainer().alias, PajeGrammar.fileId);
			//PajeGrammar.db.insert(sql);
			
			PajeGrammar.simulator.stmtLink.setDouble(1, link.getStartTime());
			PajeGrammar.simulator.stmtLink.setDouble(2, link.getEndTime());
			PajeGrammar.simulator.stmtLink.setString(3, link.getKey());
			PajeGrammar.simulator.stmtLink.setString(4, link.getValue().getAlias());
			PajeGrammar.simulator.stmtLink.setString(5, link.getType().alias);
			PajeGrammar.simulator.stmtLink.setString(6, link.getStartContainer().alias);
			PajeGrammar.simulator.stmtLink.setString(7, link.getEndContainer().alias);
			PajeGrammar.simulator.stmtLink.setInt(8, PajeGrammar.fileId);
			PajeGrammar.simulator.stmtLink.addBatch();


			pendingLinks.get(type).remove(key);
			if (!linksUsedKeys.containsKey(type))
				linksUsedKeys.put(type, new HashSet<String>());
			linksUsedKeys.get(type).add(key);

		}
	}

	// check if trace is correctly ordered
	// check if correct
	public boolean checkTimeOrder(PajeEvent event) throws Exception {
		double time = event.getTime();
		PajeTraceEvent traceEvent = event.getEvent();

		if (!this.getEntities().isEmpty()) {
			if (this.getEntities().containsKey(event.getType())) {
				ArrayList<PajeEntity> v = this.getEntities().get(event.getType());
				if (!v.isEmpty()) {
					PajeSingleTimedEntity last = (PajeSingleTimedEntity) v.get(v.size() - 1);
					if ((last.getStartTime() > time) || last.getEndTime() != -1 && last.getEndTime() > time) {
						throw new Exception("Trace is not time-ordered	in " + traceEvent.getLine());
					}
				}
			}
		}
		return true;
	}

	public void pajeResetState(PajeEvent event) throws Exception {
		checkTimeOrder(event);

		if (!this.stackStates.isEmpty()) {
			if (stackStates.containsKey(event.getType())) {
				for (PajeUserState state : this.stackStates.get(event.getType())) {
					state.setEndTime(event.getTime());
					PajeGrammar.simulator.stmtState.setString(1, this.alias);
					PajeGrammar.simulator.stmtState.setString(2, state.getType().alias);
					PajeGrammar.simulator.stmtState.setDouble(3, state.getStartTime());
					PajeGrammar.simulator.stmtState.setDouble(4, state.getEndTime());
					PajeGrammar.simulator.stmtState.setString(5, state.getValue().getAlias());
					PajeGrammar.simulator.stmtState.setDouble(6, state.getImbrication());
					PajeGrammar.simulator.stmtState.setInt(7, PajeGrammar.fileId);
					
					PajeGrammar.simulator.stmtState.addBatch();
				}
			}
		}
	}

	public void recursiveDestroy(double time) throws Exception {
		if (!this.destroyed) {
			this.destroy(time);
		}
		for (Map.Entry<String, PajeContainer> child : this.children.entrySet()) {
			PajeGrammar.db.setEndContainerDB(child.getValue().alias, PajeGrammar.fileId, time);
			child.getValue().recursiveDestroy(time);
		}
	}

	public Map<PajeType, ArrayList<PajeEntity>> getEntities() {
		return entities;
	}

}
