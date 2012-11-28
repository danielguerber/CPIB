package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IProcDecl;
import token.classes.Ident;

public final class ProcDecl implements IProcDecl {
	private final Ident ident;
	private final IParamList paramList;
	private final IAuxGlobImpList auxGlobImpList;
	private final IAuxLocCpsDecl auxLocCpsDecl;
	private final IBlockCmd blockCmd;
	
	public ProcDecl(
	        final Ident ident, 
	        final IParamList paramList,
			final IAuxGlobImpList auxGlobImpList, 
			final IAuxLocCpsDecl auxLocCpsDecl, 
			final IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.auxGlobImpList = auxGlobImpList;
		this.auxLocCpsDecl = auxLocCpsDecl;
		this.blockCmd = blockCmd;
	}

	@Override
	public abstsyn.IAbstSyn.IDecl toAbstrSyntax() {
		return new abstsyn.implementation.ProcDecl(
				ident, 
				paramList.toAbstrSyntax(), 
				auxGlobImpList.toAbstrSyntax(), 
				auxLocCpsDecl.toAbstrSyntax(), 
				blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ProcDecl>\n"
				+ ident.toString(indent + '\t')
				+ paramList.toString(indent + '\t')
				+ auxGlobImpList.toString(indent + '\t')
				+ auxLocCpsDecl.toString(indent + '\t')
				+ blockCmd.toString(indent + '\t')
				+ indent
				+ "</ProcDecl>\n";
	}
}
