package br.ufrgs.inf.tlbellini.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PajeSimulator extends PajeComponent {
	
	private PajeContainerType rootType;
	private PajeContainer root;
	
	//map alias with type object
	private Map<String, PajeType> typeMap = new HashMap<String, PajeType>();
	private Map<String, PajeType> typeNamesMap = new HashMap<String, PajeType>();; 
	private Map<String, PajeContainer> contMap = new HashMap<String, PajeContainer>();
	private Map<String, PajeContainer> contNamesMap = new HashMap<String, PajeContainer>();
	private double stopSimulationAtTime;
	
	private double selectionStart;
	private double selectionEnd;
	
	protected double lastKnownTime;
	
	public PajeSimulator(){
		this.stopSimulationAtTime = -1;
	}
	
	public PajeSimulator(double stopAt){
		this.stopSimulationAtTime = stopAt;
	}
	
	public void init(){
		// name, alias, parent
		this.rootType = new PajeContainerType("0", "0", null);
		
		//time, name, alias, parent, type, event
		this.root = new PajeContainer(0.0,"0","0", null, rootType, null);
		typeMap.put(rootType.getId(), rootType);
		typeNamesMap.put(rootType.getName(), rootType);
		contMap.put(root.getId(), root);
		contNamesMap.put(root.getName(), root);
	}
	
	protected void setLastKnownTime(PajeTraceEvent event){
		String time = event.valueForField(PajeFieldName.Time);
		if(time.isEmpty()){
			this.lastKnownTime = -1;
		}else{
			this.lastKnownTime = Double.parseDouble(time);
		}
	}
	
	PajeColor getColor (String color, PajeTraceEvent event) throws Exception
	{
	  PajeColor ret = null;
	  Pattern patAspas = Pattern.compile("\"");
	  String str[] = patAspas.split(color);
	  Pattern pat = Pattern.compile(" ");
	  String v[] = pat.split(str[1]);
	  if (!color.isEmpty()){
	    if (v.length == 3){
	      ret = new PajeColor (Float.parseFloat(v[0]), Float.parseFloat(v[1]), Float.parseFloat(v[2]), 1);
	    }else if (v.length==4){
	      ret = new PajeColor (Float.parseFloat(v[0]), Float.parseFloat(v[1]), Float.parseFloat(v[2]), Float.parseFloat(v[3]));
	    }else{
	      throw new Exception ("Could not understand color parameter");
	    }
	  }
	  return ret;
	}
	
	public void simulate(PajeObject data) throws Exception{
		PajeTraceEvent event = (PajeTraceEvent) data;
		setLastKnownTime(event);
		PajeEventId eventId = event.getPajeEventDef().getPajeEventId();
		callEventMethod(eventId, event);
		
	}
	
	public void callEventMethod(PajeEventId eventId, PajeTraceEvent event) throws Exception{
		switch(eventId){
			case PajeDefineContainerType: pajeDefineContainerType(event);
			break;
			case PajeDefineStateType: pajeDefineStateType(event);
			break;
			case PajeDefineEventType: pajeDefineEventType(event);
			break;
			case PajeDefineVariableType: pajeDefineVariableType(event);
			break;
			default: break;
		}
	}

	private void pajeDefineContainerType(PajeTraceEvent event) throws Exception {
		String name = event.valueForField(PajeFieldName.Name);
		String type = event.valueForField(PajeFieldName.Type);
		String alias = event.valueForField(PajeFieldName.Alias);
		
		//check if name is allowed
		if(name.equals("0")){
			throw new Exception("Name can't be 0");
		}
		if(typeNamesMap.containsKey(name)){
			throw new Exception("Name already exists");
		}
		
		PajeContainerType containerType;
		if(typeMap.containsKey(type)){
			containerType = (PajeContainerType) typeMap.get(type);
		}else{
			throw new Exception("Container type "+ type + " does not exist");
		}
		
		String identifier = alias.isEmpty() ? name : alias;
		PajeContainerType newType;
		if(typeMap.containsKey(identifier)){
			throw new Exception ("Container type " + identifier + "already exists");
		}else{
			newType = new PajeContainerType(name, alias, containerType);
		}
		typeMap.put(newType.getId(), newType);
		typeNamesMap.put(newType.getName(), newType);
		
		//add children to the parent container type
		containerType.addChildrenType(name, alias, newType);	 
	}
	
	private void pajeDefineStateType(PajeTraceEvent event) throws Exception {
		String name = event.valueForField(PajeFieldName.Name);
		String type = event.valueForField(PajeFieldName.Type);
		String alias = event.valueForField(PajeFieldName.Alias);
		
		if(typeNamesMap.containsKey(name)){
			throw new Exception("Name already exists");
		}
		
		PajeContainerType containerType;
		if(typeMap.containsKey(type)){
			containerType = (PajeContainerType) typeMap.get(type);
		}else{
			throw new Exception("Container type "+ type + " does not exist");
		}
		
		String identifier = alias.isEmpty() ? name : alias;
		PajeStateType newType;
		if(typeMap.containsKey(identifier)){
			throw new Exception ("State type " + identifier + " already exists");
		}else{
			newType = new PajeStateType(name, alias, containerType);
		}
		typeMap.put(newType.getId(), newType);
		typeNamesMap.put(newType.getName(), newType);
		
		//add children to the parent container type
		containerType.addChildrenType(name, alias, newType);	 
	}
	
	private void pajeDefineEventType(PajeTraceEvent event) throws Exception {
		String name = event.valueForField(PajeFieldName.Name);
		String type = event.valueForField(PajeFieldName.Type);
		String alias = event.valueForField(PajeFieldName.Alias);
		
		if(typeNamesMap.containsKey(name)){
			throw new Exception("Name already exists");
		}
		
		//parent container
		PajeContainerType containerType;
		if(typeMap.containsKey(type)){
			containerType = (PajeContainerType) typeMap.get(type);
		}else{
			throw new Exception("Container type "+ type + "does not exist");
		}
		
		String identifier = alias.isEmpty() ? name : alias;
		PajeEventType newType;
		if(typeMap.containsKey(identifier)){
			throw new Exception ("Event type " + identifier + "already exists");
		}else{
			newType = new PajeEventType(name, alias, containerType);
		}
		typeMap.put(newType.getId(), newType);
		typeNamesMap.put(newType.getName(), newType);
		
		//add children to the parent container type
		containerType.addChildrenType(name, alias, newType);	 
	}
	
	private void pajeDefineVariableType(PajeTraceEvent event) throws Exception {
		String name = event.valueForField(PajeFieldName.Name);
		String type = event.valueForField(PajeFieldName.Type);
		String alias = event.valueForField(PajeFieldName.Alias);
		String color = event.valueForField(PajeFieldName.Color);
		
		if(typeNamesMap.containsKey(name)){
			throw new Exception("Name already exists");
		}
		
		PajeContainerType containerType;
		if(typeMap.containsKey(type)){
			containerType = (PajeContainerType) typeMap.get(type);
		}else{
			throw new Exception("Container type "+ type + "does not exist");
		}
		
		PajeColor pajeColor = getColor(color, event);
		
		String identifier = alias.isEmpty() ? name : alias;
		PajeVariableType newType;
		if(typeMap.containsKey(identifier)){
			throw new Exception ("Variable type " + identifier + "already exists");
		}else{
			newType = new PajeVariableType(name, alias, containerType, pajeColor);
		}
		
		typeMap.put(newType.getId(), newType);
		typeNamesMap.put(newType.getName(), newType);
		
		//add children to the parent container type
		containerType.addChildrenType(name, alias, newType);	 
	}

}
