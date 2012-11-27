package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdWhile implements ICmd {
	private IExpr expr;
	private IBlockCmd blockCmd;
	
	public CmdWhile(IExpr expr, IBlockCmd blockCmd) {
		this.expr = expr;
		this.blockCmd = blockCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdWhile(
				expr.toAbstrSyntax(), 
				blockCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdWhile>\n" +
				expr.toString(indent + '\t') +
				blockCmd.toString(indent + '\t') +
				indent +
				"</CmdWhile>\n";
	}
}
