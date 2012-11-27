package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public class AuxIdentExprList implements IAuxIdent {
	private IExprList exprList;
	private IAuxGlobInitList auxGlobInitList;
	
	public AuxIdentExprList(IExprList exprList, IAuxGlobInitList auxGlobInitList) {
		this.exprList = exprList;
		this.auxGlobInitList = auxGlobInitList;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(Ident ident) {
		return new abstsyn.implementation.ExprCall(
				ident, 
				exprList.toAbstrSyntax(),
				auxGlobInitList.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxIdentExprList>\n" +
				exprList.toString(indent + '\t') +
				auxGlobInitList.toString(indent + '\t') +
				indent +
				"</AuxIdentExprList>\n";
	}
}
