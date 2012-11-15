package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IDecl;
import parser.concsyn.IConcSyn.IRepDecl;

public class RepDecl implements IRepDecl {
	private IDecl decl;
	private IRepDecl repDecl;
	
	public RepDecl(IDecl decl, IRepDecl repDecl) {
		this.decl=decl;
		this.repDecl=repDecl;
	}
}
