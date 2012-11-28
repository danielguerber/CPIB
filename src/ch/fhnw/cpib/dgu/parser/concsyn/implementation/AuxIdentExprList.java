package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.implementation.ExprCall;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxIdent;
import ch.fhnw.cpib.dgu.token.classes.Ident;

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
	public IAbstSyn.IExpr toAbstrSyntax(final Ident ident) {
		return new ExprCall(
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
