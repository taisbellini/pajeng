package br.ufrgs.inf.tlbellini.lib;

import java.util.HashMap;
import java.util.Map;

public class PajeContainerType extends PajeType {

	private Map<String, PajeType> children = new HashMap<String, PajeType>();
	
	public PajeContainerType(String name, String alias, PajeType parent) {
		super(name, alias, parent);
	}

	public Map<String, PajeType> getChildren() {
		return children;
	}

	public void setChildren(Map<String, PajeType> children) {
		this.children = children;
	}
	
	public String getId(){
		if(alias.isEmpty()){
			return name;
		}else{
			return alias;
		}
	}
	
	public void addChildrenType(String name, String alias, PajeType newType){
		this.children.put(newType.getId(), newType);
	}

}
