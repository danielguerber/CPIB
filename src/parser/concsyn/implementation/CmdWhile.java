package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import abstsyn.IAbstSyn;

public final class CmdWhile implements ICmd {
	private final IExpr expr;
	private final IBlockCmd blockCmd;
	
	public CmdWhile(final IExpr expr, final IBlockCmd blockCmd) {
		this.expr = expr;
		this.blockCmd = blockCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new abstsyn.implementation.CmdWhile(
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
