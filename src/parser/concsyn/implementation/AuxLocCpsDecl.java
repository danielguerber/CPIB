package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxLocCpsDecl;
import parser.concsyn.IConcSyn.ICpsDecl;

public class AuxLocCpsDecl implements IAuxLocCpsDecl {
	private ICpsDecl cpsDecl;
	public AuxLocCpsDecl(ICpsDecl cpsDecl) {
		this.cpsDecl=cpsDecl;
	}
}
