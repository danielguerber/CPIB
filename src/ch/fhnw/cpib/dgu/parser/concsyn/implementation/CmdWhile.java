package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;

public final class CmdWhile implements ICmd {
	private final IExpr expr;
	private final IBlockCmd blockCmd;
	
	public CmdWhile(final IExpr expr, final IBlockCmd blockCmd) {
		this.expr = expr;
		this.blockCmd = blockCmd;
	}

	@Override
	public IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CmdWhile(
				expr.toAbstrSyntax(), 
				blockCmd.toAbstrSyntax(),
				repCmd);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CmdWhile>\n"
				+ expr.toString(indent + '\t')
				+ blockCmd.toString(indent + '\t')
				+ indent
				+ "</CmdWhile>\n";
	}
}
