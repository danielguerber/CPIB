package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobInitList;
import abstsyn.IAbstSyn.IGlobInit;

public class AuxGlobInitList implements IAuxGlobInitList {
	private IGlobInitList globInitList;
	
	public AuxGlobInitList(IGlobInitList globInitList) {
		this.globInitList = globInitList;
	}

	@Override
	public IGlobInit toAbstrSyntax() {
		return globInitList.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxGlobInitList>\n" +
				globInitList.toString(indent + '\t') +
				indent +
				"</AuxGlobInitList>\n";
	}
}
