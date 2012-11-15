package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImp;
import token.classes.Ident;
import token.classes.Mode;
import token.classes.Mode.ChangeMode;
import token.classes.Mode.FlowMode;

public class GlobImp implements IGlobImp {
	private Mode.FlowMode flowMode;
	private Mode.ChangeMode changeMode;
	private Ident ident;
	
	public GlobImp(FlowMode flowMode, ChangeMode changeMode, Ident ident) {
		this.flowMode = flowMode;
		this.changeMode = changeMode;
		this.ident = ident;
	}
}
