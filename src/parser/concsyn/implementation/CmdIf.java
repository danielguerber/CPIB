package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdIf implements ICmd {
	private IExpr expr;
	private IBlockCmd ifCmd;
	private IBlockCmd elseCmd;
	
	public CmdIf(IExpr expr, IBlockCmd ifCmd, IBlockCmd elseCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
	}
}
