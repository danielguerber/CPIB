package parser.concsyn.implementation;

import abstsyn.IAbstSyn;
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
	
	@Override
	public IAbstSyn.IProgram toAbstrSyntax() {
		return new abstsyn.implementation.Program(ident, auxGlobCpsDecl.toAbstrSyntax(), blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Program>\n" +
				ident.toString(indent + '\t') +
				auxGlobCpsDecl.toString(indent + '\t') +
				blockCmd.toString(indent + '\t') +
				indent +
				"</Program>\n";
	}
}
