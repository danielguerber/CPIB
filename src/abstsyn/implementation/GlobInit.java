package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IGlobInit;

public class GlobInit implements IGlobInit {
	private Ident ident;
	private IGlobInit globInit;
	
	public GlobInit(Ident ident, IGlobInit globInit) {
		this.ident = ident;
		this.globInit = globInit;
	}
}
