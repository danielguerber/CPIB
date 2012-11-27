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
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprStore>\n" +
				ident.toString(indent + '\t') +
				indent +
				"<IsInit>" + isInit + "</IsInit>\n" +
				indent +
				"</ExprStore>\n";
	}
}
