package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImp;
import token.classes.Ident;

public class GlobImp implements IGlobImp {
	private IAuxFlowMode auxFlowMode;
	private IAuxChangeMode auxChangeMode;
	private Ident ident;
	
	public GlobImp(IAuxFlowMode auxFlowMode, IAuxChangeMode auxChangeMode, Ident ident) {
		this.auxFlowMode = auxFlowMode;
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
	}

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax(IRepGlobImp repGlobImp) {
		return new abstsyn.implementation.GlobImp(
				auxFlowMode.toAbstrSyntax(), 
				auxChangeMode.toAbstrSyntax(),
				ident, 
				repGlobImp.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<GlobImp>\n" +
				auxFlowMode.toString(indent + '\t') +
				auxChangeMode.toString(indent + '\t') +
				ident.toString(indent + '\t') +
				indent +
				"</GlobImp>\n";
	}
}
