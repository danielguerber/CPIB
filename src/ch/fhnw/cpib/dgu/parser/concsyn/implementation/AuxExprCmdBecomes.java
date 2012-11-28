package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxExprCmd;

public final class AuxExprCmdBecomes implements IAuxExprCmd {
	private final IExpr expr;
	
	public AuxExprCmdBecomes(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return expr.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxExprCmdBecomes>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</AuxExprCmdBecomes>\n";
	}
}
