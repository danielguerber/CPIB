package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExpr;

public class CmdExpr implements ICmd{
	private IExpr targetExpr;
	private IExpr sourceExpr;
	
	public CmdExpr(IExpr targetExpr, IExpr sourceExpr) {
		this.targetExpr = targetExpr;
		this.sourceExpr = sourceExpr;
	}
}
