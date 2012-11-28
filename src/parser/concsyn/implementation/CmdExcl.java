package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import abstsyn.IAbstSyn;

public final class CmdExcl  implements ICmd {
	private final IExpr expr;
	
	public CmdExcl(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new abstsyn.implementation.CmdOut(expr.toAbstrSyntax(), repCmd);
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
