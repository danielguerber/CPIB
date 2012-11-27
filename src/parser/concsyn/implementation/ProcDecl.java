package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IProcDecl;
import token.classes.Ident;

public class ProcDecl implements IProcDecl {
	private Ident ident;
	private IParamList paramList;
	private IAuxGlobImpList auxGlobImpList;
	private IAuxLocCpsDecl auxLocCpsDecl;
	private IBlockCmd blockCmd;
	
	public ProcDecl(Ident ident, IParamList paramList,
			IAuxGlobImpList auxGlobImpList, IAuxLocCpsDecl auxLocCpsDecl, IBlockCmd blockCmd) {
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
	public String toString(String indent) {
		return indent +
				"<ProcDecl>\n" +
				ident.toString(indent + '\t') +
				paramList.toString(indent + '\t') +
				auxGlobImpList.toString(indent + '\t') +
				auxLocCpsDecl.toString(indent + '\t') +
				blockCmd.toString(indent + '\t') +
				indent +
				"</ProcDecl>\n";
	}
}
