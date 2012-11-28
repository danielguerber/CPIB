package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobInit;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepIdent;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class RepIdent implements IRepIdent {
	private final Ident ident;
	private final IRepIdent repIdent;
	
	public RepIdent(final Ident ident, final IRepIdent repIdent) {
		this.ident = ident;
		this.repIdent = repIdent;
	}

	@Override
	public IGlobInit toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.GlobInit(
				ident,
				repIdent.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepIdent>\n"
				+ ident.toString(indent + '\t')
				+ repIdent.toString(indent + '\t')
				+ indent
				+ "</RepIdent>\n";
	}
}
