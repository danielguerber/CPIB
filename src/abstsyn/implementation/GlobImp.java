package abstsyn.implementation;

import token.classes.Ident;
import token.classes.Mode.ChangeMode;
import token.classes.Mode.FlowMode;
import abstsyn.IAbstSyn.IGlobImp;

public class GlobImp implements IGlobImp {
	private FlowMode flowMode;
	private ChangeMode changeMode;
	private Ident ident;
	private IGlobImp globImp;
	
	public GlobImp(FlowMode flowMode, ChangeMode changeMode, Ident ident, IGlobImp globImp) {
		this.flowMode = flowMode;
		this.changeMode = changeMode;
		this.ident = ident;
		this.globImp = globImp;
	}
}
