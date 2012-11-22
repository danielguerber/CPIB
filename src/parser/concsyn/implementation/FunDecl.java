package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;
import parser.concsyn.IConcSyn.IAuxLocCpsDecl;
import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.IFunDecl;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;

public class FunDecl implements IFunDecl {
	private Ident ident;
	private IParamList paramList;
	private IStoreDecl storeDecl;
	private IAuxGlobImpList auxGlobImpList;
	private IAuxLocCpsDecl auxLocCpsDecl;
	private IBlockCmd blockCmd;
	
	
	public FunDecl(Ident ident, IParamList paramList, IStoreDecl storeDecl,
			IAuxGlobImpList auxGlobImpList, IAuxLocCpsDecl auxLocCpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.storeDecl = storeDecl;
		this.auxGlobImpList = auxGlobImpList;
		this.auxLocCpsDecl = auxLocCpsDecl;
		this.blockCmd = blockCmd;
	}
}
