package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepDecl;

public class RepDecl implements IRepDecl {
	private IDecl decl;
	private IRepDecl repDecl;
	
	public RepDecl(IDecl decl, IRepDecl repDecl) {
		this.decl=decl;
		this.repDecl=repDecl;
	}

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDecl(decl.toAbstrSyntax(), repDecl.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepDecl>\n" +
				decl.toString(indent + '\t') +
				repDecl.toString(indent + '\t') +
				indent +
				"</RepDecl>\n";
	}
}
