package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;

public class AuxGlobCpsDecl implements IAuxGlobCpsDecl {
	private ICpsDecl cpsDecl;
	
	public AuxGlobCpsDecl(ICpsDecl cpsDecl) {
		this.cpsDecl = cpsDecl;
	}

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return cpsDecl.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxGlobCpsDecl>\n" +
				cpsDecl.toString(indent + '\t') +
				indent +
				"</AuxGlobCpsDecl>\n";
	}
}
