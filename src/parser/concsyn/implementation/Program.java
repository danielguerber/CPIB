package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;
import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.IProgram;
import token.classes.Ident;

public class Program implements IProgram{
	private Ident ident;
	private IAuxGlobCpsDecl auxGlobCpsDecl;
	private IBlockCmd blockCmd;
	
	public Program(Ident ident, IAuxGlobCpsDecl auxGlobCpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.blockCmd = blockCmd;
		this.auxGlobCpsDecl=auxGlobCpsDecl;
	}
}
