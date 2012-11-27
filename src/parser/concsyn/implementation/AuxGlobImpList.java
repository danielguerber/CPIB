package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;

public class AuxGlobImpList implements IAuxGlobImpList {
	private IGlobImpList globImpList;
	
	public AuxGlobImpList(IGlobImpList globImpList) {
		this.globImpList = globImpList;
	}

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return globImpList.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxGlobImpList>\n" +
				globImpList.toString(indent + '\t') +
				indent +
				"</AuxGlobImpList>\n";
	}
}
