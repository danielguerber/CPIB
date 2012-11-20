package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxChangeMode;
import parser.concsyn.IConcSyn.IAuxFlowMode;
import parser.concsyn.IConcSyn.IGlobImp;
import token.classes.Ident;

public class GlobImp implements IGlobImp {
	private IAuxFlowMode auxFlowMode;
	private IAuxChangeMode auxChangeMode;
	private Ident ident;
	
	public GlobImp(IAuxFlowMode auxFlowMode, IAuxChangeMode auxChangeMode, Ident ident) {
		this.auxFlowMode = auxFlowMode;
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
	}
}
