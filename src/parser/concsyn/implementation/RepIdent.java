package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepIdent;
import token.classes.Ident;

public class RepIdent implements IRepIdent {
	private Ident ident;
	private IRepIdent repIdent;
	
	public RepIdent(Ident ident, IRepIdent repIdent) {
		this.ident = ident;
		this.repIdent = repIdent;
	}
}
