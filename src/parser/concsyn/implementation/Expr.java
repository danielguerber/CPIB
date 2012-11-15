package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IRepTerm1;
import parser.concsyn.IConcSyn.ITerm1;

public class Expr implements IExpr {
	private ITerm1 term1;
	private IRepTerm1 repTerm1;
	
	public Expr(ITerm1 term1, IRepTerm1 repTerm1) {
		this.term1 = term1;
		this.repTerm1 = repTerm1;
	}
}
