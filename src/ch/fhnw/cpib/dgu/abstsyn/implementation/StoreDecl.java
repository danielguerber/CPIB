package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;
import ch.fhnw.cpib.dgu.token.classes.Type;
import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class StoreDecl implements IStoreDecl {
	private final ChangeMode changeMode;
	private final Ident ident;
	private final Type type;
	
	public String getIdent() {
	    return ident.getIdent().toString();
	}
	
	public StoreDecl(final ChangeMode changeMode, 
	        final Ident ident, 
	        final Type type) {
		this.changeMode = changeMode;
		this.ident = ident;
		this.type = type;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<StoreDecl>\n"
				+ changeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ type.toString(indent + '\t')
				+ indent
				+ "</StoreDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public void checkDeclaration() throws ContextError {
        if (!IMLCompiler.getGlobalStoreTable().addStore((getStore()))) {
            throw new ContextError("Store already declared: "
                    + ident.getIdent(), ident.getLine());
        }
    }
    
    private Store getStore() {
        return new Store(
                ident.getIdent().toString(),
                type.getType(),
                changeMode.getMode() == Modes.CONST);
    }

    @Override
    public Types getType() {
        return type.getType();
    }

    @Override
    public void check(final boolean isGlobal) throws ContextError {
        if (!isGlobal) {
            check();
        }
    }

    @Override
    public Store check() throws ContextError {
        Store store = getStore();
        
        if (!IMLCompiler.getScope().getStoreTable().addStore(store)) {
            throw new ContextError("Ident already declared: "
                    + ident.getIdent(), ident.getLine());
        }
        
        return store;
    }
}
