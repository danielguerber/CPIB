package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepDecl;

public final class RepDecl implements IRepDecl {
	private final IDecl decl;
	private final IRepDecl repDecl;
	
	public RepDecl(final IDecl decl, final IRepDecl repDecl) {
		this.decl = decl;
		this.repDecl = repDecl;
	}

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDecl(
		        decl.toAbstrSyntax(), 
		        repDecl.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepDecl>\n"
				+ decl.toString(indent + '\t')
				+ repDecl.toString(indent + '\t')
				+ indent
				+ "</RepDecl>\n";
	}
}
