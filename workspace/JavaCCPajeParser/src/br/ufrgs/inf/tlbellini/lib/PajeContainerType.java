package br.ufrgs.inf.tlbellini.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public PajeTypeNature getNature(){
		return PajeTypeNature.ContainerType;
	}
	
	//more efficient http://stackoverflow.com/questions/15422428/iterator-over-hashmap-in-java
	// as it is start and end CONTAINER, I suppose I can just analyze the containerTypes (they`re the only ones with children
	public boolean isAncestralOf(String c){
		if(!this.children.isEmpty()){
			for(Map.Entry<String, PajeType> entry : this.children.entrySet()){
				if(entry.getKey().equals(c))
					return true;
				else
				{
					if(entry.getValue().getNature().equals(PajeTypeNature.ContainerType))
						return ((PajeContainerType) entry.getValue()).isAncestralOf(c);
				}
			}
		}
		return false;

	}

}
