package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxLocCpsDecl;

public class AuxLocCpsDecl implements IAuxLocCpsDecl {
	private ICpsDecl cpsDecl;
	public AuxLocCpsDecl(ICpsDecl cpsDecl) {
		this.cpsDecl=cpsDecl;
	}
	
	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return cpsDecl.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxLocCpsDecl>\n" +
				cpsDecl.toString(indent + '\t') +
				indent +
				"</AuxLocCpsDecl>\n";
	}
}
