package ch.fhnw.cpib.dgu.abstsyn.implementation;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList;
import ch.fhnw.cpib.dgu.context.Parameter;
import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class ExprList implements IExprList {
	private final IExpr expr;
	private final IExprList exprList;
	private Parameter param;
	
	public ExprList(final IExpr expr, final IExprList exprList) {
		this.expr = expr;
		this.exprList = exprList;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprList>\n"
				+ expr.toString(indent + '\t')
				+ exprList.toString(indent + '\t')
				+ indent
				+ "</ExprList>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(
            final List<Parameter> paramList, 
            final Set<String> aliasList,
            final boolean canInit) 
                    throws ContextError {
        if (paramList.size() <= 0) {
            throw new ContextError(
                    "Routione takes less parameters than provided. ",
                    expr.getLine());
        }
        
        param = paramList.get(0);
        paramList.remove(0);
        
        Types type;
        
        switch(param.getFlowMode()) {
            case IN:
                if (param.getMechMode() == Modes.COPY) {
                    type = expr.checkR();
                } else {
                    type = expr.checkL(false);
                    
                    if (!(expr instanceof ExprStore)) {
                        throw new ContextError(
                                "Only stores can be used as IN REF parameter!",
                                expr.getLine());
                    }
                    
                    if (aliasList.contains(
                            ((ExprStore) expr).getStore().getIdent())) {
                        throw new ContextError(
                                "Store is already used a parameter!",
                                expr.getLine());
                    }
                    
                    aliasList.add(((ExprStore) expr).getStore().getIdent());
                }
                break;
            case INOUT:
                type = checkINOUTstore(false, aliasList);
                break;
            case OUT:
                type = checkINOUTstore(canInit, aliasList);
                break;
            default:
                throw new RuntimeException();
        }
        
        if (type != param.getType()) {
            throw new ContextError(
                    "Wrong paramter type!",
                    expr.getLine());
        }
        
        exprList.check(paramList, aliasList, canInit);
    }
    
    private Types checkINOUTstore(
            final boolean canInit, 
            final Set<String> aliasList) throws ContextError {
        
        Types type = expr.checkL(canInit);
        
        if (!(expr instanceof ExprStore)) {
            throw new ContextError(
                    "Only stores can be used as INOUT/OUT parameter!",
                    expr.getLine());
        }
        
        if (aliasList.contains(
                ((ExprStore) expr).getStore().getIdent())) {
            throw new ContextError(
                    "Store is already used a parameter!",
                    expr.getLine());
        }
        
        if (!((ExprStore) expr).getStore().isWriteable()) {
            throw new ContextError(
                    "INOUT/OUT parameter is not writeable!",
                    expr.getLine());
        }
        
        aliasList.add(((ExprStore) expr).getStore().getIdent());
        
        return type;
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1;
        if (param.getFlowMode() == Modes.IN
                && param.getMechMode() == Modes.COPY) {
            loc1 = expr.code(loc);
        } else {
            loc1 = ((ExprStore) expr).codeRef(loc);
        }
        return exprList.code(loc1);
    }
}
