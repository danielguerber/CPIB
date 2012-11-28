package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;

public final class AuxGlobCpsDecl implements IAuxGlobCpsDecl {
	private final ICpsDecl cpsDecl;
	
	public AuxGlobCpsDecl(final ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
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
