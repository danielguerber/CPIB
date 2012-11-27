package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IDecl;

public class FunDecl implements IDecl {
	private Ident ident;
	private IParam param;
	private IStoreDecl returnDecl;
	private IGlobImp globImp;
	private ICpsDecl cpsDecl;
	private ICmd cmd;
	
	public FunDecl(Ident ident, IParam param, IStoreDecl returnDecl,
			IGlobImp globImp, ICpsDecl cpsDecl, ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.returnDecl = returnDecl;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
}
