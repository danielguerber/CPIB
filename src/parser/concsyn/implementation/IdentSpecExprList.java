package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExprList;
import parser.concsyn.IConcSyn.IIdentSpec;

public class IdentSpecExprList implements IIdentSpec {
	private IExprList exprList;
	
	public IdentSpecExprList(IExprList exprList) {
		this.exprList = exprList;
	}
}
