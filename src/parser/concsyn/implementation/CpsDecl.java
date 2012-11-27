package parser.concsyn.implementation;

import abstsyn.IAbstSyn;
import parser.concsyn.IConcSyn.ICpsDecl;

public class CpsDecl implements ICpsDecl {
	private IDecl decl;
	private IRepDecl repDecl;
	
	public CpsDecl(IDecl decl, IRepDecl repDecl) {
		this.decl=decl;
		this.repDecl=repDecl;
	}

	@Override
	public IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDecl(decl.toAbstrSyntax(), repDecl.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CpsDecl>\n" +
				decl.toString(indent + '\t') +
				repDecl.toString(indent + '\t') +
				indent +
				"</CpsDecl>\n";
	}
}
