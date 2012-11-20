package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdExcl  implements ICmd {
	private IExpr expr;
	
	public CmdExcl(IExpr expr) {
		this.expr = expr;
	}
}
