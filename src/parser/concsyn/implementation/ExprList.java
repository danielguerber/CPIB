package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExprList;

public class ExprList implements IExprList {
	private IAuxExprList auxExprList;

	public ExprList(IAuxExprList auxExprList) {
		this.auxExprList = auxExprList;
	}

	@Override
	public abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return auxExprList.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprList>\n" +
				auxExprList.toString(indent + '\t') +
				indent +
				"</ExprList>\n";
	}
}
