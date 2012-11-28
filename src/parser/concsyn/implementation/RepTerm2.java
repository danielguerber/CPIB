package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;
import token.classes.Operator.RelOpr;
import abstsyn.implementation.ExprDyadic;

public final class RepTerm2 implements IRepTerm2 {
	private final RelOpr relOpr;
	private final ITerm2 term2;
	private final IRepTerm2 repTerm2;
	
	public RepTerm2(
	        final RelOpr relOpr, 
	        final ITerm2 term2, 
	        final IRepTerm2 repTerm2) {
		this.relOpr = relOpr;
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}

	//TODO: Check if CAND should be inserted here
	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		final ExprDyadic exprDya 
		= new ExprDyadic(relOpr, expr, term2.toAbstrSyntax());
		return repTerm2.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepTerm2>\n"
				+ relOpr.toString(indent + '\t')
				+ term2.toString(indent + '\t')
				+ repTerm2.toString(indent + '\t')
				+ indent
				+ "</RepTerm2>\n";
	}
}
