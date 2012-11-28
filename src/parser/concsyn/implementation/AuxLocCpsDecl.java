package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxLocCpsDecl;

public final class AuxLocCpsDecl implements IAuxLocCpsDecl {
	private final ICpsDecl cpsDecl;
	public AuxLocCpsDecl(final ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}
	
	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
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
