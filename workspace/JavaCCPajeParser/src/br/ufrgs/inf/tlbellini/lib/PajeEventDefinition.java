package br.ufrgs.inf.tlbellini.lib;

import java.util.ArrayList;
import java.util.Vector;

public class PajeEventDefinition {
	
	public PajeEventId pajeEventId;
	public int uniqueID;
	public Vector<String> userDefinedFieldNames;
	public ArrayList<PajeField> fields = new ArrayList<PajeField>();
	
	public PajeEventDefinition(PajeEventId id, int unique/* int line, PajeDefinitions definitions*/){
		pajeEventId = id;
		uniqueID = unique;
	}
	
	public void addFields(ArrayList<PajeField> newFields){
		
		fields.addAll(newFields);
	}
	
	public void addField(PajeField newField){
		
		fields.add(newField);
	}
	

}
