package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class ExprStore implements IExpr {
	private final Ident ident;
	private final boolean isInit;
	
	public ExprStore(final Ident ident, final boolean isInit) {
		this.ident = ident;
		this.isInit = isInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprStore>\n"
				+ ident.toString(indent + '\t')
				+ indent
				+ "<IsInit>" + isInit + "</IsInit>\n"
				+ indent
				+ "</ExprStore>\n";
	}
}
