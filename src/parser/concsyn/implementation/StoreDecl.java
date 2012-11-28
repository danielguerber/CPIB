package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;
import token.classes.Type;

public final class StoreDecl implements IStoreDecl {
	private final IAuxChangeMode auxChangeMode;
	private final Ident ident;
	private final Type type;
	
	public StoreDecl(
	        final IAuxChangeMode auxChangeMode, 
	        final Ident ident, 
	        final Type type) {
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
	public String toString(final String indent) {
		return indent
				+ "<StoreDecl>\n"
				+ auxChangeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ type.toString(indent + '\t')
				+ indent
				+ "</StoreDecl>\n";
	}
}
