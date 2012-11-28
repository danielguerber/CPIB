package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IProgram;
import token.classes.Ident;
import abstsyn.IAbstSyn;

public final class Program implements IProgram {
	private final Ident ident;
	private final IAuxGlobCpsDecl auxGlobCpsDecl;
	private final IBlockCmd blockCmd;
	
	public Program(
	        final Ident ident, 
	        final IAuxGlobCpsDecl auxGlobCpsDecl, 
	        final IBlockCmd blockCmd) {
		this.ident = ident;
		this.blockCmd = blockCmd;
		this.auxGlobCpsDecl = auxGlobCpsDecl;
	}
	
	@Override
	public IAbstSyn.IProgram toAbstrSyntax() {
		return new abstsyn.implementation.Program(
		        ident, 
		        auxGlobCpsDecl.toAbstrSyntax(), 
		        blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Program>\n"
				+ ident.toString(indent + '\t')
				+ auxGlobCpsDecl.toString(indent + '\t')
				+ blockCmd.toString(indent + '\t')
				+ indent
				+ "</Program>\n";
	}
}
