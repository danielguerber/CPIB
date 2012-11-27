package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepGlobImp;

public class RepGlobImp implements IRepGlobImp {
	private IGlobImp globImp;
	private IRepGlobImp repGlobImp;
	
	public RepGlobImp(IGlobImp globImp, IRepGlobImp repGlobImp) {
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
				"<RepGlobImp>\n" +
				globImp.toString(indent + '\t') +
				repGlobImp.toString(indent + '\t') +
				indent +
				"</RepGlobImp>\n";
	}
}
