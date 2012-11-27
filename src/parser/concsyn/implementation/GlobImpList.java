package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImpList;

public class GlobImpList implements IGlobImpList {
	private IGlobImp globImp;
	private IRepGlobImp repGlobImp;
	
	public GlobImpList(IGlobImp globImp, IRepGlobImp repGlobImp) {
		this.globImp = globImp;
		this.repGlobImp = repGlobImp;
	}

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return globImp.toAbstrSyntax(repGlobImp);
	}	
	
	@Override
	public String toString(String indent) {
		return indent +
				"<GlobImpList>\n" +
				globImp.toString(indent + '\t') +
				repGlobImp.toString(indent + '\t') +
				indent +
				"</GlobImpList>\n";
	}
}
