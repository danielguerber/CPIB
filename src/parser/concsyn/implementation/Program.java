package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IProgram;
import token.classes.Ident;

public class Program implements IProgram{
	private Ident ident;
	private ICpsDecl cpsDecl;
	private IBlockCmd blockCmd;
	
	public Program(Ident ident, ICpsDecl cpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.blockCmd = blockCmd;
		this.cpsDecl=cpsDecl;
	}
}
