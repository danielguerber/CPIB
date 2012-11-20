package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import parser.concsyn.IConcSyn.IFactor;
import token.classes.Ident;

public class FactorIdent implements IFactor {
	private Ident ident;
	private IAuxIdent auxIdent;
	
	public FactorIdent(Ident ident, IAuxIdent auxIdent) {
		this.ident = ident;
		this.auxIdent = auxIdent;
	}
}
