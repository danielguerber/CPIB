package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IFunDecl;
import parser.concsyn.IConcSyn.IGlobImpList;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;

public class FunDecl implements IFunDecl {
	private Ident ident;
	private IParamList paramList;
	private IStoreDecl storeDecl;
	private IGlobImpList globImpList;
	private ICpsDecl cpsDecl;
	private IBlockCmd blockCmd;
	
	
	public FunDecl(Ident ident, IParamList paramList, IStoreDecl storeDecl,
			IGlobImpList globImpList, ICpsDecl cpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.storeDecl = storeDecl;
		this.globImpList = globImpList;
		this.cpsDecl = cpsDecl;
		this.blockCmd = blockCmd;
	}
}
