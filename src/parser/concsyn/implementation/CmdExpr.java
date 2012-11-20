package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;
import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdExpr implements ICmd{
	private IExpr expr;
	private IAuxExprCmd auxExprCmd;
	
	public CmdExpr(IExpr expr, IAuxExprCmd auxExprCmd) {
		this.expr = expr;
		this.auxExprCmd = auxExprCmd;
	}
}
