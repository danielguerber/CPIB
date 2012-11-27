package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IDecl;

public class ProcDecl implements IDecl {
	private Ident ident;
	private IParam param;
	private IGlobImp globImp;
	private ICpsDecl cpsDecl;
	private ICmd cmd;
	
	public ProcDecl(Ident ident, IParam param,
			IGlobImp globImp, ICpsDecl cpsDecl, ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
}
