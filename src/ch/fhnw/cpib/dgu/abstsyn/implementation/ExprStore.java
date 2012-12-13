package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
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

    @Override
    public Types check() throws ContextError {
        //TODO: check code!
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
        
        if (!IMLCompiler.getScope().getSymbolTable().getSymbol(
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
    public Types checkAssign() throws ContextError {
        Types type = IMLCompiler.getSymbolTable().getType(
                ident.getIdent().toString());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getIdent() + " not declared",
                    ident.getLine());
        } 

        if (isInit) {
            if (!IMLCompiler.getScope().initStore(
                    ident.getIdent().toString())) {
                throw new ContextError(
                        "Store "
                                + ident.getIdent() 
                                + " is already initialized",
                        ident.getLine());
            }
        } else if (!IMLCompiler.getScope().isInitialized(
                ident.getIdent().toString())) {
            throw new ContextError(
                    "Store "
                            + ident.getIdent() 
                            + " is not initialized",
                    ident.getLine());
        }
        
        return type;
    }
}
