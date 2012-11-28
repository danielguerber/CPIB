package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepIdent;
import token.classes.Ident;
import abstsyn.IAbstSyn.IGlobInit;

public final class RepIdent implements IRepIdent {
	private final Ident ident;
	private final IRepIdent repIdent;
	
	public RepIdent(final Ident ident, final IRepIdent repIdent) {
		this.ident = ident;
		this.repIdent = repIdent;
	}

	@Override
	public IGlobInit toAbstrSyntax() {
		return new abstsyn.implementation.GlobInit(
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
