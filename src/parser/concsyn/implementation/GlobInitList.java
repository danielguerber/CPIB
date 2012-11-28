package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobInitList;
import token.classes.Ident;
import abstsyn.IAbstSyn.IGlobInit;

public final class GlobInitList implements IGlobInitList {
	private final Ident ident;
	private final IRepIdent repIdent;
	
	public GlobInitList(final Ident ident, final IRepIdent repIdent) {
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
				+ "<GlobInitList>\n"
				+ ident.toString(indent + '\t')
				+ repIdent.toString(indent + '\t')
				+ indent
				+ "</GlobInitList>\n";
	}
}
