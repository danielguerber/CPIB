package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm3;
import parser.concsyn.IConcSyn.ITerm2;
import parser.concsyn.IConcSyn.ITerm3;

public class Term2 implements ITerm2 {
	private ITerm3 term3;
	private IRepTerm3 repTerm3;
	
	public Term2(ITerm3 term3, IRepTerm3 repTerm3) {
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}
}
