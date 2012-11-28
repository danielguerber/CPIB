package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import abstsyn.IAbstSyn;

public final class CmdIf implements ICmd {
	private final IExpr expr;
	private final IBlockCmd ifCmd;
	private final IBlockCmd elseCmd;
	
	public CmdIf(final IExpr expr, 
	        final IBlockCmd ifCmd, 
	        final IBlockCmd elseCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
	}

	@Override
    public abstsyn.IAbstSyn.ICmd toAbstrSyntax(
            final IAbstSyn.ICmd repCmd) {
		return new abstsyn.implementation.CmdIf(
				expr.toAbstrSyntax(), 
				ifCmd.toAbstrSyntax(), 
				elseCmd.toAbstrSyntax(),
				repCmd);
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdIf>\n"
				+ expr.toString(indent + '\t')
				+ ifCmd.toString(indent + '\t')
				+ elseCmd.toString(indent + '\t')
				+ indent
				+ "</CmdIf>\n";
	}
}
