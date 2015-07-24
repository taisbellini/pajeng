package br.ufrgs.inf.tlbellini.lib;

import java.util.HashMap;
import java.util.Map;

public class PajeCategorizedType extends PajeType {
	
	Map<String, PajeValue> values = new HashMap<String, PajeValue>();
	Map<String, PajeColor> colors = new HashMap<String, PajeColor>();

	public PajeCategorizedType(String name, String alias, PajeType parent) {
		super(name, alias, parent);
	}
	
	public boolean isCategorizedType(){
		return true;
	}
	

}
