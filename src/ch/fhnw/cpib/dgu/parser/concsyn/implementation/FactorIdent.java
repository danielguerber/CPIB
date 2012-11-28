package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFactor;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class FactorIdent implements IFactor {
	private final Ident ident;
	private final IAuxIdent auxIdent;
	
	public FactorIdent(final Ident ident, final IAuxIdent auxIdent) {
		this.ident = ident;
		this.auxIdent = auxIdent;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return auxIdent.toAbstrSyntax(ident);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FactorIdent>\n"
				+ ident.toString(indent + '\t')
				+ auxIdent.toString(indent + '\t')
				+ indent
				+ "</FactorIdent>\n";
	}
}
