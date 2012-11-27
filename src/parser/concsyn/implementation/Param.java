package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParam;

public class Param implements IParam {
	private IAuxFlowMode auxFlowMode;
	private IAuxMechMode auxMechMode;
	private IStoreDecl storeDecl;
	
	public Param(IAuxFlowMode auxFlowMode, IAuxMechMode auxMechMode, IStoreDecl storeDecl) {
		this.auxFlowMode = auxFlowMode;
		this.auxMechMode = auxMechMode;
		this.storeDecl = storeDecl;
	}

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax(IRepParam repParam) {
		return new abstsyn.implementation.Param(
				auxFlowMode.toAbstrSyntax(),
				auxMechMode.toAbstrSyntax(),
				storeDecl.toAbstrSyntax(), 
				repParam.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Param>\n" +
				auxFlowMode.toString(indent + '\t') +
				auxMechMode.toString(indent + '\t') +
				storeDecl.toString(indent + '\t') +
				indent +
				"</Param>\n";
	}
}
