package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.implementation.ExprDyadic;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm2;
import ch.fhnw.cpib.dgu.token.classes.Operator.BoolOpr;
import ch.fhnw.cpib.dgu.token.classes.Operator.RelOpr;
import ch.fhnw.cpib.dgu.token.enums.Operators;

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

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final IAbstSyn.IExpr relExpr,
	        final IAbstSyn.IExpr boolExpr) {
	    
	    final IAbstSyn.IExpr term2Abst = term2.toAbstrSyntax();
		ExprDyadic exprDya 
		    = new ExprDyadic(relOpr, relExpr, term2Abst);
		
		if (boolExpr != null) {
		    BoolOpr boolOpr = new BoolOpr(Operators.CAND);
		    exprDya = new ExprDyadic(boolOpr, boolExpr, exprDya);
		}
		
		return repTerm2.toAbstrSyntax(term2Abst, exprDya);
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
