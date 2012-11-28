package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class ExprCall implements IExpr {
	private final Ident ident;
	private final IExprList exprList;
	private final IGlobInit globInit;
	
	public ExprCall(final Ident ident, 
	        final IExprList exprList, 
	        final IGlobInit globInit) {
		this.ident = ident;
		this.exprList = exprList;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprCall>\n"
				+ ident.toString(indent + '\t')
				+ exprList.toString(indent + '\t')
				+ globInit.toString(indent + '\t')
				+ indent
				+ "</ExprCall>\n";
	}
}