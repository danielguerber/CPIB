package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public final class AuxIdentExprList implements IAuxIdent {
	private final IExprList exprList;
	private final IAuxGlobInitList auxGlobInitList;
	
	public AuxIdentExprList(
	        final IExprList exprList, 
	        final IAuxGlobInitList auxGlobInitList) {
		this.exprList = exprList;
		this.auxGlobInitList = auxGlobInitList;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(final Ident ident) {
		return new abstsyn.implementation.ExprCall(
				ident, 
				exprList.toAbstrSyntax(),
				auxGlobInitList.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxIdentExprList>\n"
				+ exprList.toString(indent + '\t')
				+ auxGlobInitList.toString(indent + '\t')
				+ indent
				+ "</AuxIdentExprList>\n";
	}
}
