package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.implementation.CmdIn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;

public final class CmdQuest implements ICmd {
	private final IExpr expr;
	
	public CmdQuest(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new CmdIn(expr.toAbstrSyntax(), repCmd);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CmdQuest>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</CmdQuest>\n";
	}
}
