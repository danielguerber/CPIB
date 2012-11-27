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
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Program>\n" +
				ident.toString(indent + '\t') +
				cpsDecl.toString(indent + '\t') +
				cmd.toString(indent + '\t') +
				indent +
				"</Program>\n";
	}
}
