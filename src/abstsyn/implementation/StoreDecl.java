package abstsyn.implementation;

import token.classes.Ident;
import token.classes.Mode.ChangeMode;
import token.classes.Type;
import abstsyn.IAbstSyn.IStoreDecl;

public class StoreDecl implements IStoreDecl {
	private final ChangeMode changeMode;
	private final Ident ident;
	private final Type type;
	
	public StoreDecl(ChangeMode changeMode, Ident ident, Type type) {
		this.changeMode = changeMode;
		this.ident = ident;
		this.type = type;
	}
}
