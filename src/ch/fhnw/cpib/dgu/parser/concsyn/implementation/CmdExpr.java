package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;

public final class CmdExpr implements ICmd {
	private final IExpr expr;
	private final IAuxExprCmd auxExprCmd;
	
	public CmdExpr(final IExpr expr, final IAuxExprCmd auxExprCmd) {
		this.expr = expr;
		this.auxExprCmd = auxExprCmd;
	}

	@Override
	public IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CmdExpr(
				expr.toAbstrSyntax(), 
				auxExprCmd.toAbstrSyntax(),
				repCmd);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CmdExpr>\n"
				+ expr.toString(indent + '\t')
				+ auxExprCmd.toString(indent + '\t')
				+ indent
				+ "</CmdExpr>\n";
	}
}
