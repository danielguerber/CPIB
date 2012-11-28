package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IExprList;

public final class ExprList implements IExprList {
	private final IAuxExprList auxExprList;

	public ExprList(final IAuxExprList auxExprList) {
		this.auxExprList = auxExprList;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return auxExprList.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprList>\n"
				+ auxExprList.toString(indent + '\t')
				+ indent
				+ "</ExprList>\n";
	}
}
