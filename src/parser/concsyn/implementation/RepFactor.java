package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepFactor;
import token.classes.Operator.MultOpr;
import abstsyn.implementation.ExprDyadic;

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
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
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
