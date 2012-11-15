package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;
import parser.concsyn.IConcSyn.ITerm2;
import token.classes.Operator;
import token.classes.Operator.BoolOpr;
import token.classes.Operator.RelOpr;

public class RepTerm2 implements IRepTerm2 {
	private Operator.RelOpr relOpr;
	private ITerm2 term2;
	private IRepTerm2 repTerm2;
	
	public RepTerm2(RelOpr relOpr, ITerm2 term2, IRepTerm2 repTerm2) {
		this.relOpr = relOpr;
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}
}
