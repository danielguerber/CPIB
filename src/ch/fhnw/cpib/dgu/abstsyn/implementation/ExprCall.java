package ch.fhnw.cpib.dgu.abstsyn.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.context.Parameter;
import ch.fhnw.cpib.dgu.context.Routine;
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
    public Types checkR() throws ContextError {
        Types type = IMLCompiler.getRoutineTable().getType(
                ident.getIdent().toString());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getIdent() + " not declared",
                    ident.getLine());
        } else if (type == Types.PROC) {
            throw new ContextError(
                    "Procedure call found in an expression: "
                            + ident.getIdent() + "",
                    ident.getLine());
        }
        
        if (globInit instanceof GlobInit) {
            throw new ContextError(
                    "GlobInitList is only allowed for procedure calls", 
                    globInit.getLine());
        }
        
        Routine routine =  IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        
        List<Parameter> paramList 
            = new ArrayList<Parameter>(routine.getParamList());
        
        Set<String> aliasList = new HashSet<String>();
        
        exprList.check(paramList, aliasList, false);
        
        for (ch.fhnw.cpib.dgu.context.GlobImp globImp 
                : routine.getGlobImpList()) {
            if (!IMLCompiler.getScope().getStoreTable().getStore(
                    globImp.getIdent()).isInitialized()) {
                throw new ContextError(
                        "Global import of function not initialized! Ident: "
                            + globImp.getIdent(), 
                        ident.getLine());
            }
            
            if (aliasList.contains(globImp.getIdent())) {
                throw new ContextError(
                        "Global import is already used as a parameter! Ident: "
                            + globImp.getIdent(), 
                        ident.getLine());
            }
        }
        
        return type;
    }

    @Override
    public Types checkL(final boolean canInit) throws ContextError {
        Types type = IMLCompiler.getRoutineTable().getType(
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

        Routine routine =  IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        
        List<Parameter> paramList 
            = new ArrayList<Parameter>(routine.getParamList());
        
        Set<String> aliasList = new HashSet<String>();
        
        exprList.check(paramList, aliasList, canInit);
        
        Set<String> globInits = globInit.check(new HashSet<String>());
        
        for (ch.fhnw.cpib.dgu.context.GlobImp globImp 
                : routine.getGlobImpList()) {
            
            switch (globImp.getFlowMode()) {
                case IN:
                case INOUT:
                    if (!IMLCompiler.getScope().getStoreTable().getStore(
                            globImp.getIdent()).isInitialized()) {
                        throw new ContextError(
                                "Global import of function not initialized!" 
                                    + " Ident: " + globImp.getIdent(), 
                                ident.getLine());
                    }
                    break;
                case OUT:
                    if (globInits.contains(globImp.getIdent())) {
                        IMLCompiler.getScope().getStoreTable().getStore(
                                globImp.getIdent()).initialize();
                        globInits.remove(globImp.getIdent());
                    }
                    break;
                default:
                    throw new RuntimeException();
            }
            
            if (aliasList.contains(globImp.getIdent())) {
                throw new ContextError(
                        "Global import is already used as a parameter! Ident: "
                            + globImp.getIdent(), 
                        ident.getLine());
            }
        }
        
        if (globInits.size() > 0) {
            throw new ContextError(
                    "Global init is not importet! Ident: "
                        + globInits.iterator().next(), 
                    ident.getLine());
        }
        
        return type;
    }
}
