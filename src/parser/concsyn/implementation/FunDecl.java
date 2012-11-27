package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFunDecl;
import token.classes.Ident;

public class FunDecl implements IFunDecl {
	private Ident ident;
	private IParamList paramList;
	private IStoreDecl storeDecl;
	private IAuxGlobImpList auxGlobImpList;
	private IAuxLocCpsDecl auxLocCpsDecl;
	private IBlockCmd blockCmd;
	
	
	public FunDecl(Ident ident, IParamList paramList, IStoreDecl storeDecl,
			IAuxGlobImpList auxGlobImpList, IAuxLocCpsDecl auxLocCpsDecl, IBlockCmd blockCmd) {
		this.ident = ident;
		this.paramList = paramList;
		this.storeDecl = storeDecl;
		this.auxGlobImpList = auxGlobImpList;
		this.auxLocCpsDecl = auxLocCpsDecl;
		this.blockCmd = blockCmd;
	}


	@Override
	public abstsyn.IAbstSyn.IDecl toAbstrSyntax() {
		return new abstsyn.implementation.FunDecl(
				ident, 
				paramList.toAbstrSyntax(), 
				storeDecl.toAbstrSyntax(),
				auxGlobImpList.toAbstrSyntax(),
				auxLocCpsDecl.toAbstrSyntax(), 
				blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<FunDecl>\n" +
				ident.toString(indent + '\t') +
				paramList.toString(indent + '\t') +
				storeDecl.toString(indent + '\t') +
				auxGlobImpList.toString(indent + '\t') +
				auxLocCpsDecl.toString(indent + '\t') +
				blockCmd.toString(indent + '\t') +
				indent +
				"</FunDecl>\n";
	}
}
