package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepParam;

public final class RepParam implements IRepParam {
	private final IParam param;
	private final IRepParam repParam;
	
	public RepParam(final IParam param, final IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return param.toAbstrSyntax(repParam);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<RepParam>\n"
				+ param.toString(indent + '\t')
				+ repParam.toString(indent + '\t')
				+ indent
				+ "</RepParam>\n";
	}
}
