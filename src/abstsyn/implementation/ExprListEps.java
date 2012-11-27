package abstsyn.implementation;

import abstsyn.IAbstSyn.IExprList;

public class ExprListEps implements IExprList {
	@Override
	public String toString(String indent) {
		return indent + "<ExprListEps/>\n";
	}
}
