package br.ufrgs.inf.tlbellini.lib;

import br.ufrgs.inf.tlbellini.PajeGrammar;

public class PajeVariableType extends PajeType {


	private PajeColor color;
	
	public PajeVariableType(String name, String alias, PajeType parent, PajeColor color) {
		super(name, alias, parent);
		this.setColor(color);
		
		String sql = PajeGrammar.db.generateInsertVariableTypeSQL(alias, name, parent.alias, depth, PajeGrammar.fileId, color);
		PajeGrammar.db.insert(sql);
	}

	protected PajeColor getColor() {
		return color;
	}

	protected void setColor(PajeColor color) {
		this.color = color;
	}
	
	
	
	public PajeTypeNature getNature(){
		return PajeTypeNature.VariableType;
	}
	
}
