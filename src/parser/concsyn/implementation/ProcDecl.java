package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;
import parser.concsyn.IConcSyn.IAuxLocCpsDecl;
import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IGlobImpList;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IProcDecl;
import token.classes.Ident;

public class ProcDecl implements IProcDecl {
	private Ident ident;
	private IParamList paramList;
	private IAuxGlobImpList auxGlobImpList;
	private IAuxLocCpsDecl auxLocCpsDecl;
	private IBlockCmd blockCmd;
	
	public ProcDecl(Ident ident, IParamList paramList,
			IAuxGlobImpList auxGlobImpList, IAuxLocCpsDecl auxLocCpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.auxGlobImpList = auxGlobImpList;
		this.auxLocCpsDecl = auxLocCpsDecl;
		this.blockCmd = blockCmd;
	}
	
}
