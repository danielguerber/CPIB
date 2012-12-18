package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprStore implements IExpr {
	private final Ident ident;
	private final boolean isInit;
	
	public ExprStore(final Ident ident, final boolean isInit) {
		this.ident = ident;
		this.isInit = isInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprStore>\n"
				+ ident.toString(indent + '\t')
				+ indent
				+ "<IsInit>" + isInit + "</IsInit>\n"
				+ indent
				+ "</ExprStore>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}
	
	public Store getStore() {
	    return IMLCompiler.getScope().getStoreTable().getStore(
	            ident.getIdent().toString());
	}

    @Override
    public Types checkR() throws ContextError {
        Types type = IMLCompiler.getScope().getType(
                ident.getIdent().toString());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getIdent() + " not declared",
                    ident.getLine());
        } 

        if (isInit) {
            throw new ContextError(
                    "Initialization of "
                            + ident.getIdent() 
                            + " found in left part of an assignement",
                    ident.getLine());
        }
        
        if (!IMLCompiler.getScope().getStoreTable().getStore(
                ident.getIdent().toString()).isInitialized()) {
            throw new ContextError(
                    "Store "
                            + ident.getIdent() 
                            + " is not initialized",
                    ident.getLine());
        }
        
        return type;
    }

    @Override
    public Types checkL(final boolean canInit) throws ContextError {
        Types type = IMLCompiler.getScope().getType(
                ident.getIdent().toString());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getIdent() + " not declared",
                    ident.getLine());
        } 
        
        Store store = IMLCompiler.getScope().getStoreTable().getStore(
                ident.getIdent().toString());
        
        if (isInit) {
            if (canInit) {
                throw new ContextError(
                        "Store can not be initialized here " 
                                + "(loop or inout parameter)!",
                        ident.getLine());
            }
            if (store.isInitialized()) {
                throw new ContextError(
                        "Store "
                                + ident.getIdent() 
                                + " is already initialized",
                        ident.getLine());
            }
            store.initialize();
        } else if (!store.isInitialized()) {
            throw new ContextError(
                    "Store "
                            + ident.getIdent() 
                            + " is not initialized",
                    ident.getLine());
        } else if (!store.isWriteable()) {
            throw new ContextError(
                    "Store "
                            + ident.getIdent() 
                            + " is not writeable",
                    ident.getLine());
        }
        
        return type;
    }
}
