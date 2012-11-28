package abstsyn.implementation;

import abstsyn.IAbstSyn.IExprList;

public final class ExprListEps implements IExprList {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprListEps/>\n";
	}
}
