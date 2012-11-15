package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import parser.concsyn.IConcSyn.IRepFactor;
import token.classes.Operator;
import token.classes.Operator.MultOpr;

public class RepFactor implements IRepFactor {
	private Operator.MultOpr multOpr;
	private IFactor factor;
	private IRepFactor repFactor;
	
	public RepFactor(MultOpr multOpr, IFactor factor, IRepFactor repFactor) {
		this.multOpr = multOpr;
		this.factor = factor;
		this.repFactor = repFactor;
	}
}
