package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import parser.concsyn.IConcSyn.IRepFactor;
import parser.concsyn.IConcSyn.IRepTerm3;
import parser.concsyn.IConcSyn.ITerm3;

public class Term3 implements ITerm3 {
	private IFactor factor;
	private IRepFactor repFactor;
	
	public Term3(IFactor factor, IRepFactor repFactor) {
		this.factor = factor;
		this.repFactor = repFactor;
	}
}
