package abstsyn.implementation;

import abstsyn.IAbstSyn.IExpr;

public final class ExprEps implements IExpr {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprEps/>\n";
	}
}
