package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import abstsyn.IAbstSyn;

public final class CmdQuest implements ICmd {
	private final IExpr expr;
	
	public CmdQuest(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new abstsyn.implementation.CmdIn(expr.toAbstrSyntax(), repCmd);
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
