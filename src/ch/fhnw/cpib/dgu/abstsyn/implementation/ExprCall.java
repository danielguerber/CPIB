package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprCall implements IExpr {
	private final Ident ident;
	private final IExprList exprList;
	private final IGlobInit globInit;
	
	public ExprCall(final Ident ident, 
	        final IExprList exprList, 
	        final IGlobInit globInit) {
		this.ident = ident;
		this.exprList = exprList;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprCall>\n"
				+ ident.toString(indent + '\t')
				+ exprList.toString(indent + '\t')
				+ globInit.toString(indent + '\t')
				+ indent
				+ "</ExprCall>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public Types check() throws ContextError {
        Types type = IMLCompiler.getSymbolTable().getType(
                ident.getIdent().toString());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getIdent() + " not declared",
                    ident.getLine());
        } else if (type == Types.PROC) {
            throw new ContextError(
                    "Procedure call found in a expression: "
                            + ident.getIdent() + "",
                    ident.getLine());
        }
        
        if (globInit instanceof GlobInit) {
            throw new ContextError(
                    "GlobInitList is only allowed for procedure calls", 
                    globInit.getLine());
        }
        
        
        // TODO Parameter check
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
        } else if (type != Types.PROC) {
            throw new ContextError(
                    "Function call "
                            + ident.getIdent() 
                            + " found in left part of an assignement",
                    ident.getLine());
        }

        
        // TODO Parameter check
        return type;
    }
}
