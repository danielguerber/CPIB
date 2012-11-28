package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList;

public final class ExprListEps implements IExprList {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprListEps/>\n";
	}
}
