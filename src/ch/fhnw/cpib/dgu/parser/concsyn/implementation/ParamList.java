package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IParamList;

public final class ParamList implements IParamList {
	private final IAuxParamList auxParamList;
	
	public ParamList(final IAuxParamList auxParamList) {
		this.auxParamList = auxParamList;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam toAbstrSyntax() {
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
