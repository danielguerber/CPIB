package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.implementation.CmdOut;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;

public final class CmdExcl  implements ICmd {
	private final IExpr expr;
	
	public CmdExcl(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new CmdOut(expr.toAbstrSyntax(), repCmd);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CmdExcl>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</CmdExcl>\n";
	}
}
