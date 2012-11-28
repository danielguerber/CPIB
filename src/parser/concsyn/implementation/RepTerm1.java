package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm1;
import token.classes.Operator.BoolOpr;
import abstsyn.implementation.ExprDyadic;

public final class RepTerm1 implements IRepTerm1 {
	private final BoolOpr boolOpr;
	private final ITerm1 term1;
	private final IRepTerm1 repTerm1;
	
	public RepTerm1(
	        final BoolOpr boolOpr, 
	        final ITerm1 term1, 
	        final IRepTerm1 repTerm1) {
		this.boolOpr = boolOpr;
		this.term1 = term1;
		this.repTerm1 = repTerm1;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		final ExprDyadic exprDya 
		    = new ExprDyadic(boolOpr, expr, term1.toAbstrSyntax());
		return repTerm1.toAbstrSyntax(exprDya);
	}	
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepTerm1>\n"
				+ boolOpr.toString(indent + '\t')
				+ term1.toString(indent + '\t')
				+ repTerm1.toString(indent + '\t')
				+ indent
				+ "</RepTerm1>\n";
	}
}
