package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;
import parser.concsyn.IConcSyn.ICpsDecl;

public class AuxGlobCpsDecl implements IAuxGlobCpsDecl {
	private ICpsDecl cpsDecl;
	
	public AuxGlobCpsDecl(ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}
}
