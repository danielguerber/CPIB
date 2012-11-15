package parser;

import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IExprList;
import parser.concsyn.IConcSyn.IRepExpr;

public class ExprList implements IExprList {
	private IExpr expr;
	private IRepExpr repExpr;
	
	public ExprList(IExpr expr, IRepExpr repExpr) {
		this.expr = expr;
		this.repExpr = repExpr;
	}
}
