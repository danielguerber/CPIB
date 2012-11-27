package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IProgram;

public class Program implements IProgram {
	private Ident ident;
	private ICpsDecl cpsDecl;
	private ICmd cmd;
	
	public Program(Ident ident, ICpsDecl cpsDecl, ICmd cmd) {
		this.ident = ident;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
}
