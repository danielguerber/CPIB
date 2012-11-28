package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImp;
import token.classes.Ident;

public final class GlobImp implements IGlobImp {
	private final IAuxFlowMode auxFlowMode;
	private final IAuxChangeMode auxChangeMode;
	private final Ident ident;
	
	public GlobImp(
	        final IAuxFlowMode auxFlowMode, 
	        final IAuxChangeMode auxChangeMode, 
	        final Ident ident) {
		this.auxFlowMode = auxFlowMode;
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
	}

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax(
	        final IRepGlobImp repGlobImp) {
		return new abstsyn.implementation.GlobImp(
				auxFlowMode.toAbstrSyntax(), 
				auxChangeMode.toAbstrSyntax(),
				ident, 
				repGlobImp.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobImp>\n"
				+ auxFlowMode.toString(indent + '\t')
				+ auxChangeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ indent
				+ "</GlobImp>\n";
	}
}
