package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm3;
import parser.concsyn.IConcSyn.ITerm3;
import token.classes.Operator;
import token.classes.Operator.AddOpr;

public class RepTerm3 implements IRepTerm3 {
	private Operator.AddOpr addOpr;
	private ITerm3 term3;
	private IRepTerm3 repTerm3;
	
	public RepTerm3(AddOpr addOpr, ITerm3 term3, IRepTerm3 repTerm3) {
		this.addOpr = addOpr;
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}
}
