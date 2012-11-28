package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class FunDecl implements IDecl {
	private final Ident ident;
	private final IParam param;
	private final IStoreDecl returnDecl;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public FunDecl(final Ident ident, 
	        final IParam param, 
	        final IStoreDecl returnDecl,
			final IGlobImp globImp, 
			final ICpsDecl cpsDecl, 
			final ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.returnDecl = returnDecl;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FunDecl>\n"
				+ ident.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ returnDecl.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</FunDecl>\n";
	}
}
