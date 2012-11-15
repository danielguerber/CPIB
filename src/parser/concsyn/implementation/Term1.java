package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;
import parser.concsyn.IConcSyn.ITerm1;
import parser.concsyn.IConcSyn.ITerm2;

public class Term1 implements ITerm1 {
	private ITerm2 term2;
	private IRepTerm2 repTerm2;
	
	public Term1(ITerm2 term2, IRepTerm2 repTerm2) {
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}
}
