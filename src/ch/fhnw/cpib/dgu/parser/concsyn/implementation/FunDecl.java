package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFunDecl;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class FunDecl implements IFunDecl {
	private final Ident ident;
	private final IParamList paramList;
	private final IStoreDecl storeDecl;
	private final IAuxGlobImpList auxGlobImpList;
	private final IAuxLocCpsDecl auxLocCpsDecl;
	private final IBlockCmd blockCmd;
	
	
	public FunDecl(
	        final Ident ident, 
	        final IParamList paramList, 
	        final IStoreDecl storeDecl,
			final IAuxGlobImpList auxGlobImpList, 
			final IAuxLocCpsDecl auxLocCpsDecl, 
			final IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.storeDecl = storeDecl;
		this.auxGlobImpList = auxGlobImpList;
		this.auxLocCpsDecl = auxLocCpsDecl;
		this.blockCmd = blockCmd;
	}


	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.FunDecl(
				ident, 
				paramList.toAbstrSyntax(), 
				storeDecl.toAbstrSyntax(),
				auxGlobImpList.toAbstrSyntax(),
				auxLocCpsDecl.toAbstrSyntax(), 
				blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FunDecl>\n"
				+ ident.toString(indent + '\t')
				+ paramList.toString(indent + '\t')
				+ storeDecl.toString(indent + '\t')
				+ auxGlobImpList.toString(indent + '\t')
				+ auxLocCpsDecl.toString(indent + '\t')
				+ blockCmd.toString(indent + '\t')
				+ indent
				+ "</FunDecl>\n";
	}
}
