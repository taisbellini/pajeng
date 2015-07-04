package br.ufrgs.inf.tlbellini.lib;

import java.util.Map;

public class PajeContainerType extends PajeType {

	private Map<String, PajeType> children;
	
	public PajeContainerType(String name, String alias, PajeType parent) {
		super(name, alias, parent);
	}

	public Map<String, PajeType> getChildren() {
		return children;
	}

	public void setChildren(Map<String, PajeType> children) {
		this.children = children;
	}

}
