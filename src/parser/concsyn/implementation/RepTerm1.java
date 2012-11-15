package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm1;
import parser.concsyn.IConcSyn.ITerm1;
import token.classes.Operator;
import token.classes.Operator.BoolOpr;

public class RepTerm1 implements IRepTerm1 {
	private Operator.BoolOpr boolOpr;
	private ITerm1 term1;
	private IRepTerm1 repTerm1;
	
	public RepTerm1(BoolOpr boolOpr, ITerm1 term1, IRepTerm1 repTerm1) {
		this.boolOpr = boolOpr;
		this.term1 = term1;
		this.repTerm1 = repTerm1;
	}	
}
