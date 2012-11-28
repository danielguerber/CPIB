package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;

public final class AuxExprCmdEps implements IAuxExprCmd {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new abstsyn.implementation.ExprEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxExprCmdEps />\n";
	}
}
