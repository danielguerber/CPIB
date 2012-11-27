package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobInitList;
import token.classes.Ident;
import abstsyn.IAbstSyn.IGlobInit;

public class GlobInitList implements IGlobInitList {
	private Ident ident;
	private IRepIdent repIdent;
	
	public GlobInitList(Ident ident, IRepIdent repIdent) {
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
	public String toString(String indent) {
		return indent +
				"<GlobInitList>\n" +
				ident.toString(indent + '\t') +
				repIdent.toString(indent + '\t') +
				indent +
				"</GlobInitList>\n";
	}
}
