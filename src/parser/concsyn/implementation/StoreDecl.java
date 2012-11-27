package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;
import token.classes.Type;

public class StoreDecl implements IStoreDecl {
	private IAuxChangeMode auxChangeMode;
	private Ident ident;
	private Type type;
	
	public StoreDecl(IAuxChangeMode auxChangeMode, Ident ident, Type type) {
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
		this.type = type;
	}

	@Override
	public abstsyn.IAbstSyn.IStoreDecl toAbstrSyntax() {
		return new abstsyn.implementation.StoreDecl(
				auxChangeMode.toAbstrSyntax(),
				ident,
				type);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<StoreDecl>\n" +
				auxChangeMode.toString(indent + '\t') +
				ident.toString(indent + '\t') +
				type.toString(indent + '\t') +
				indent +
				"</StoreDecl>\n";
	}
}
