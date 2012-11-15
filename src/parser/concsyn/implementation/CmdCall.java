package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IExprList;
import parser.concsyn.IConcSyn.IGlobInitList;
import token.classes.Ident;

public class CmdCall implements ICmd {
	Ident ident;
	IExprList exprList;
	IGlobInitList globInitList;
	
	public CmdCall(Ident ident, IExprList exprList, IGlobInitList globInitList) {
		this.ident = ident;
		this.exprList = exprList;
		this.globInitList = globInitList;
	}
}
