package abstsyn.implementation;

import token.classes.Ident;
import token.classes.Mode.ChangeMode;
import token.classes.Mode.FlowMode;
import abstsyn.IAbstSyn.IGlobImp;

public final class GlobImp implements IGlobImp {
	private final FlowMode flowMode;
	private final ChangeMode changeMode;
	private final Ident ident;
	private final IGlobImp globImp;
	
	public GlobImp(final FlowMode flowMode, 
	        final ChangeMode changeMode, 
	        final Ident ident, 
	        final IGlobImp globImp) {
		this.flowMode = flowMode;
		this.changeMode = changeMode;
		this.ident = ident;
		this.globImp = globImp;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobImp>\n"
				+ flowMode.toString(indent + '\t')
				+ changeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ indent
				+ "</GlobImp>\n";
	}
}
