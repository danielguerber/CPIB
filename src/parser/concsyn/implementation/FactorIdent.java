package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import parser.concsyn.IConcSyn.IIdentSpec;
import token.classes.Ident;

public class FactorIdent implements IFactor {
	private Ident ident;
	private IIdentSpec identSpec;
	
	public FactorIdent(Ident ident, IIdentSpec identSpec) {
		this.ident = ident;
		this.identSpec = identSpec;
	}
}
