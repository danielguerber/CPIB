package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;

public class AuxParamList implements IAuxParamList {
	private IParam param;
	private IRepParam repParam;
	
	public AuxParamList(IParam param, IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return param.toAbstrSyntax(repParam);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxParamList>\n" +
				param.toString(indent + '\t') +
				repParam.toString(indent + '\t') +
				indent +
				"</AuxParamList>\n";
	}
}
