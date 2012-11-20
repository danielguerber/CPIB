package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxFlowMode;
import parser.concsyn.IConcSyn.IAuxMechMode;
import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IStoreDecl;

public class Param implements IParam {
	private IAuxFlowMode auxFlowMode;
	private IAuxMechMode auxMechMode;
	private IStoreDecl storeDecl;
	
	public Param(IAuxFlowMode auxFlowMode, IAuxMechMode auxMechMode, IStoreDecl storeDecl) {
		this.auxFlowMode = auxFlowMode;
		this.auxMechMode = auxMechMode;
		this.storeDecl = storeDecl;
	}
}
