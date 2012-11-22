package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import parser.concsyn.IConcSyn.IExprList;

public class AuxIdentExprList implements IAuxIdent {
	private IExprList exprList;
	private IAuxGlobInitList auxGlobInitList;
	
	public AuxIdentExprList(IExprList exprList, IAuxGlobInitList auxGlobInitList) {
		this.exprList = exprList;
		this.auxGlobInitList = auxGlobInitList;
	}
}
