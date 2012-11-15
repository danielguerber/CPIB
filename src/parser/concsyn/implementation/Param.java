package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Mode;
import token.classes.Mode.FlowMode;
import token.classes.Mode.MechMode;

public class Param implements IParam {
	Mode.FlowMode flowMode;
	Mode.MechMode mechMode;
	IStoreDecl storeDecl;
	
	public Param(FlowMode flowMode, MechMode mechMode, IStoreDecl storeDecl) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.storeDecl = storeDecl;
	}
	
}
