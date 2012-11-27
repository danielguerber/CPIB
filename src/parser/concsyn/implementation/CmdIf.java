package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdIf implements ICmd {
	private IExpr expr;
	private IBlockCmd ifCmd;
	private IBlockCmd elseCmd;
	
	public CmdIf(IExpr expr, IBlockCmd ifCmd, IBlockCmd elseCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdIf(
				expr.toAbstrSyntax(), 
				ifCmd.toAbstrSyntax(), 
				elseCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdIf>\n" +
				expr.toString(indent + '\t') +
				ifCmd.toString(indent + '\t') +
				elseCmd.toString(indent + '\t') +
				indent +
				"</CmdIf>\n";
	}
}
