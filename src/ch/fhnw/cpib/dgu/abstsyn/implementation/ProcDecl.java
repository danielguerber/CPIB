package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class ProcDecl implements IDecl {
	private final Ident ident;
	private final IParam param;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public ProcDecl(final Ident ident, final IParam param,
			final IGlobImp globImp, final ICpsDecl cpsDecl, final ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ProcDecl>\n"
				+ ident.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</ProcDecl>\n";
	}
}
