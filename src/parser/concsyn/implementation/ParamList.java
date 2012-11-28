package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParamList;

public final class ParamList implements IParamList {
	private final IAuxParamList auxParamList;
	
	public ParamList(final IAuxParamList auxParamList) {
		this.auxParamList = auxParamList;
	}

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return auxParamList.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ParamList>\n"
				+ auxParamList.toString(indent + '\t')
				+ indent
				+ "</ParamList>\n";
	}
}
