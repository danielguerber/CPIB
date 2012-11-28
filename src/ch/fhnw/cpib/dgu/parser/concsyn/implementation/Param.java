package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IParam;

public final class Param implements IParam {
	private final IAuxFlowMode auxFlowMode;
	private final IAuxMechMode auxMechMode;
	private final IStoreDecl storeDecl;
	
	public Param(
	        final IAuxFlowMode auxFlowMode, 
	        final IAuxMechMode auxMechMode, 
	        final IStoreDecl storeDecl) {
		this.auxFlowMode = auxFlowMode;
		this.auxMechMode = auxMechMode;
		this.storeDecl = storeDecl;
	}

	@Override
	public IAbstSyn.IParam toAbstrSyntax(final IRepParam repParam) {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.Param(
				auxFlowMode.toAbstrSyntax(),
				auxMechMode.toAbstrSyntax(),
				storeDecl.toAbstrSyntax(), 
				repParam.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Param>\n"
				+ auxFlowMode.toString(indent + '\t')
				+ auxMechMode.toString(indent + '\t')
				+ storeDecl.toString(indent + '\t')
				+ indent
				+ "</Param>\n";
	}
}
