package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICpsDecl;
import abstsyn.IAbstSyn;

public final class CpsDecl implements ICpsDecl {
	private final IDecl decl;
	private final IRepDecl repDecl;
	
	public CpsDecl(final IDecl decl, final IRepDecl repDecl) {
		this.decl = decl;
		this.repDecl = repDecl;
	}

	@Override
	public IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDecl(
		        decl.toAbstrSyntax(), 
		        repDecl.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CpsDecl>\n"
				+ decl.toString(indent + '\t')
				+ repDecl.toString(indent + '\t')
				+ indent
				+ "</CpsDecl>\n";
	}
}
