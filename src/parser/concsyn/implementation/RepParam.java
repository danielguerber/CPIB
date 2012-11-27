package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepParam;

public class RepParam implements IRepParam {
	private IParam param;
	private IRepParam repParam;
	
	public RepParam(IParam param, IRepParam repParam) {
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
				"<RepParam>\n" +
				param.toString(indent + '\t') +
				repParam.toString(indent + '\t') +
				indent +
				"</RepParam>\n";
	}
}
