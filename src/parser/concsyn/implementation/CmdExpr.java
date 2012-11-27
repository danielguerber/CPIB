package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdExpr implements ICmd{
	private IExpr expr;
	private IAuxExprCmd auxExprCmd;
	
	public CmdExpr(IExpr expr, IAuxExprCmd auxExprCmd) {
		this.expr = expr;
		this.auxExprCmd = auxExprCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdExpr(
				expr.toAbstrSyntax(), 
				auxExprCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdExpr>\n" +
				expr.toString(indent + '\t') +
				auxExprCmd.toString(indent + '\t') +
				indent +
				"</CmdExpr>\n";
	}
}
