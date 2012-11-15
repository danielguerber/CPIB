package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import token.classes.Literal;

public class FactorLiteral implements IFactor {
	private Literal literal;
	
	public FactorLiteral(Literal literal) {
		this.literal = literal;
	}
}
