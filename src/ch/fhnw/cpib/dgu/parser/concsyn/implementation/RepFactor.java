package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.implementation.ExprDyadic;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepFactor;
import ch.fhnw.cpib.dgu.token.classes.Operator.MultOpr;

public final class RepFactor implements IRepFactor {
	private final MultOpr multOpr;
	private final IFactor factor;
	private final IRepFactor repFactor;
	
	public RepFactor(
	        final MultOpr multOpr, 
	        final IFactor factor, 
	        final IRepFactor repFactor) {
		this.multOpr = multOpr;
		this.factor = factor;
		this.repFactor = repFactor;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr expr) {
		final ExprDyadic exprDya 
		    = new ExprDyadic(multOpr, expr, factor.toAbstrSyntax());
		return repFactor.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepFactor>\n"
				+ multOpr.toString(indent + '\t')
				+ factor.toString(indent + '\t')
				+ repFactor.toString(indent + '\t')
				+ indent
				+ "</RepFactor>\n";
	}
}
