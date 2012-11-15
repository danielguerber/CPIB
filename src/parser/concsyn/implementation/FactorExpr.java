package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IFactor;

public class FactorExpr implements IFactor {
	private IExpr expr;
	
	public FactorExpr(IExpr expr) {
		this.expr = expr;
	}
}
