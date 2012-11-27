package abstsyn.implementation;

import abstsyn.IAbstSyn.IExpr;

public class ExprEps implements IExpr {
	@Override
	public String toString(String indent) {
		return indent + "<ExprEps/>\n";
	}
}
