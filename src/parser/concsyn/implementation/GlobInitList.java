package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobInitList;
import parser.concsyn.IConcSyn.IRepIdent;
import token.classes.Ident;

public class GlobInitList implements IGlobInitList {
	private Ident ident;
	private IRepIdent repIdent;
	
	public GlobInitList(Ident ident, IRepIdent repIdent) {
		this.ident = ident;
		this.repIdent = repIdent;
	}
}
