package br.ufrgs.inf.tlbellini.lib;

import br.ufrgs.inf.tlbellini.PajeGrammar;

public class PajeValue extends PajeObject {
	
	private PajeColor color;
	private String name;
	private String alias;
	private PajeType type;
	
	public PajeValue(String name, String alias, PajeType type, PajeColor color){
		this.setColor(color);
		this.setName(name);
		this.setAlias(alias);
		this.setType(type);
		
		String sql = PajeGrammar.db.generateInsertValueSQL(alias, name, type.getAlias());
		PajeGrammar.db.insert(sql);
	}

	public PajeColor getColor() {
		return color;
	}

	public void setColor(PajeColor color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		if(alias.isEmpty()){
			return name;
		}else
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public PajeType getType() {
		return type;
	}

	public void setType(PajeType type) {
		this.type = type;
	}

	public String getId() {
		if(alias.isEmpty()){
			return name;
		}else{
			return alias;
		}
	}

}
