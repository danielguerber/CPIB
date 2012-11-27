package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import token.classes.Ident;

public class FactorIdent implements IFactor {
	private Ident ident;
	private IAuxIdent auxIdent;
	
	public FactorIdent(Ident ident, IAuxIdent auxIdent) {
		this.ident = ident;
		this.auxIdent = auxIdent;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return auxIdent.toAbstrSyntax(ident);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<FactorIdent>\n" +
				ident.toString(indent + '\t') +
				auxIdent.toString(indent + '\t') +
				indent +
				"</FactorIdent>\n";
	}
}
