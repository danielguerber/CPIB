package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IRepExpr;

public class RepExpr implements IRepExpr {
	private IExpr expr;
	private IRepExpr repExpr;
	
	public RepExpr(IExpr expr, IRepExpr repExpr) {
		this.expr = expr;
		this.repExpr = repExpr;
	}
}
