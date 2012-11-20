package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import parser.concsyn.IConcSyn.IExprList;

public class AuxIdentExprList implements IAuxIdent {
	private IExprList exprList;
	
	public AuxIdentExprList(IExprList exprList) {
		this.exprList = exprList;
	}
}
