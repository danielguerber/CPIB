package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobCpsDecl;

public final class AuxGlobCpsDecl implements IAuxGlobCpsDecl {
	private final ICpsDecl cpsDecl;
	
	public AuxGlobCpsDecl(final ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return cpsDecl.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxGlobCpsDecl>\n"
				+ cpsDecl.toString(indent + '\t')
				+ indent
				+ "</AuxGlobCpsDecl>\n";
	}
}
