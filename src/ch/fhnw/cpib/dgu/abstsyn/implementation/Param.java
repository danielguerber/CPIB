package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.MechMode;

public final class Param implements IParam {
	private final FlowMode flowMode;
	private final MechMode mechMode;
	private final IStoreDecl storeDecl;
	private final IParam param;
	
	public Param(final FlowMode flowMode, 
	        final MechMode mechMode, 
	        final IStoreDecl storeDecl,
			final IParam param) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.storeDecl = storeDecl;
		this.param = param;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Param>\n"
				+ flowMode.toString(indent + '\t')
				+ mechMode.toString(indent + '\t')
				+ storeDecl.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ indent
				+ "</Param>\n";
	}
}
