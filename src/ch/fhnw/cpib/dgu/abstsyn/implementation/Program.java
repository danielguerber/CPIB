package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IProgram;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class Program implements IProgram {
	private final Ident ident;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public Program(final Ident ident, final ICpsDecl cpsDecl, final ICmd cmd) {
		this.ident = ident;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Program>\n"
				+ ident.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</Program>\n";
	}
}
