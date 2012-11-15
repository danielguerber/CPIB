package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdExcl  implements ICmd {
	IExpr expr;
	
	public CmdExcl(IExpr expr) {
		this.expr = expr;
	}
}
