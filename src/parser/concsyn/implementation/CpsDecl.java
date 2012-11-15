package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IDecl;
import parser.concsyn.IConcSyn.IRepDecl;

public class CpsDecl implements ICpsDecl {
	private IDecl decl;
	private IRepDecl repDecl;
	
	public CpsDecl(IDecl decl, IRepDecl repDecl) {
		this.decl=decl;
		this.repDecl=repDecl;
	}
}
