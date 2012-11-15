package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IGlobImpList;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IProcDecl;
import token.classes.Ident;

public class ProcDecl implements IProcDecl {
	private Ident ident;
	private IParamList paramList;
	private IGlobImpList globImpList;
	private ICpsDecl cpsDecl;
	private IBlockCmd blockCmd;
	
	public ProcDecl(Ident ident, IParamList paramList,
			IGlobImpList globImpList, ICpsDecl cpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.globImpList = globImpList;
		this.cpsDecl = cpsDecl;
		this.blockCmd = blockCmd;
	}
	
}