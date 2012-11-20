package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprList;
import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IRepExpr;

public class AuxExprList implements IAuxExprList {
	private IExpr expr;
	private IRepExpr repExpr;

	public AuxExprList(IExpr expr, IRepExpr repExpr) {
		this.expr = expr;
		this.repExpr = repExpr;
	}
}
