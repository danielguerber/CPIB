package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdQuest implements ICmd {
	IExpr expr;
	
	public CmdQuest(IExpr expr) {
		this.expr = expr;
	}
}
