package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepDecl;

public final class RepDecl implements IRepDecl {
	private final IDecl decl;
	private final IRepDecl repDecl;
	
	public RepDecl(final IDecl decl, final IRepDecl repDecl) {
		this.decl = decl;
		this.repDecl = repDecl;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CpsDecl(
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
