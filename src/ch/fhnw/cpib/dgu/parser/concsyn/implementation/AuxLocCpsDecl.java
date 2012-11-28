package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxLocCpsDecl;

public final class AuxLocCpsDecl implements IAuxLocCpsDecl {
	private final ICpsDecl cpsDecl;
	public AuxLocCpsDecl(final ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}
	
	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return cpsDecl.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxLocCpsDecl>\n"
				+ cpsDecl.toString(indent + '\t')
				+ indent
				+ "</AuxLocCpsDecl>\n";
	}
}
