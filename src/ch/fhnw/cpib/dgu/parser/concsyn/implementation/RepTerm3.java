package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.implementation.ExprDyadic;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm3;
import ch.fhnw.cpib.dgu.token.classes.Operator.AddOpr;

public final class RepTerm3 implements IRepTerm3 {
	private final AddOpr addOpr;
	private final ITerm3 term3;
	private final IRepTerm3 repTerm3;
	
	public RepTerm3(
	        final AddOpr addOpr, 
	        final ITerm3 term3, 
	        final IRepTerm3 repTerm3) {
		this.addOpr = addOpr;
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr expr) {
		final ExprDyadic exprDya 
		    = new ExprDyadic(addOpr, expr, term3.toAbstrSyntax());
		return repTerm3.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepTerm3>\n"
				+ addOpr.toString(indent + '\t')
				+ term3.toString(indent + '\t')
				+ repTerm3.toString(indent + '\t')
				+ indent
				+ "</RepTerm3>\n";
	}
}
