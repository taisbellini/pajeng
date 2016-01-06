package br.ufrgs.inf.tlbellini.lib;

import br.ufrgs.inf.tlbellini.PajeGrammar;

public class PajeStateType extends PajeCategorizedType {

	public PajeStateType(String name, String alias, PajeType parent) {
		super(name, alias, parent);
		
		String sql = PajeGrammar.db.generateInsertTypeSQL(alias, name, parent != null? parent.alias : "null", depth, PajeGrammar.fileId);
		PajeGrammar.db.insert(sql);
	}
	
	public PajeTypeNature getNature(){
		return PajeTypeNature.StateType;
	}
}
