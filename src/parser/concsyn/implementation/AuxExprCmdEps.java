package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;

public class AuxExprCmdEps implements IAuxExprCmd {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new abstsyn.implementation.ExprEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<AuxExprCmdEps />\n";
	}
}
