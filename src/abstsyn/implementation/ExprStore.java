package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IExpr;

public class ExprStore implements IExpr {
	private Ident ident;
	private boolean isInit;
	
	public ExprStore(Ident ident, boolean isInit) {
		this.ident = ident;
		this.isInit = isInit;
	}
}
