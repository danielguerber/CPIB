package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IGlobInit;

public final class GlobInit implements IGlobInit {
	private final Ident ident;
	private final IGlobInit globInit;
	
	public GlobInit(final Ident ident, final IGlobInit globInit) {
		this.ident = ident;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobInit>\n"
				+ ident.toString(indent + '\t')
				+ globInit.toString(indent + '\t')
				+ indent
				+ "</GlobInit>\n";
	}
}
