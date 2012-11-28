package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxExprCmd;

public final class AuxExprCmdEps implements IAuxExprCmd {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ExprEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxExprCmdEps />\n";
	}
}
