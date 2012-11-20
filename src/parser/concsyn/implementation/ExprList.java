package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprList;
import parser.concsyn.IConcSyn.IExprList;

public class ExprList implements IExprList {
	private IAuxExprList auxExprList;

	public ExprList(IAuxExprList auxExprList) {
		this.auxExprList = auxExprList;
	}
}
