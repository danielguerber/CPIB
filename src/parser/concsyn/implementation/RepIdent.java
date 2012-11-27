package parser.concsyn.implementation;

import abstsyn.IAbstSyn.IGlobInit;
import parser.concsyn.IConcSyn.IRepIdent;
import token.classes.Ident;

public class RepIdent implements IRepIdent {
	private Ident ident;
	private IRepIdent repIdent;
	
	public RepIdent(Ident ident, IRepIdent repIdent) {
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
				"<RepIdent>\n" +
				ident.toString(indent + '\t') +
				repIdent.toString(indent + '\t') +
				indent +
				"</RepIdent>\n";
	}
}
