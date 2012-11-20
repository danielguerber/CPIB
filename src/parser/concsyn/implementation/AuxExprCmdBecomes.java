package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;
import parser.concsyn.IConcSyn.IExpr;

public class AuxExprCmdBecomes implements IAuxExprCmd {
	private IExpr expr;
	
	public AuxExprCmdBecomes(IExpr expr) {
		this.expr = expr;
	}

}
