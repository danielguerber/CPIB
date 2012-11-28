package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;

public final class AuxParamList implements IAuxParamList {
	private final IParam param;
	private final IRepParam repParam;
	
	public AuxParamList(final IParam param, final IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return param.toAbstrSyntax(repParam);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxParamList>\n"
				+ param.toString(indent + '\t')
				+ repParam.toString(indent + '\t')
				+ indent
				+ "</AuxParamList>\n";
	}
}
