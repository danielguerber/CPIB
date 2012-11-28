package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICpsDecl;

public final class CpsDecl implements ICpsDecl {
	private final IDecl decl;
	private final IRepDecl repDecl;
	
	public CpsDecl(final IDecl decl, final IRepDecl repDecl) {
		this.decl = decl;
		this.repDecl = repDecl;
	}

	@Override
	public IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CpsDecl(
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
