package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdWhile implements ICmd {
	private IExpr expr;
	private IBlockCmd blockCmd;
	
	public CmdWhile(IExpr expr, IBlockCmd blockCmd) {
		this.expr = expr;
		this.blockCmd = blockCmd;
	}
}
