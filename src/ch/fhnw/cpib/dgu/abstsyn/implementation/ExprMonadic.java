package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Base;
import ch.fhnw.cpib.dgu.token.classes.Operator.AddOpr;
import ch.fhnw.cpib.dgu.token.enums.Terminals;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprMonadic implements IExpr {
	private final Base operator;
	private final IExpr expr;
	
	public ExprMonadic(final Base operator, final IExpr expr) {
		this.operator = operator;
		this.expr = expr;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprMonadic>\n"
				+ operator.toString(indent + '\t')
				+ expr.toString(indent + '\t')
				+ indent
				+ "</ExprMonadic>\n";
	}
	
	@Override
	public int getLine() {
	    return operator.getLine();
	}
	
	@Override
	public Types checkR() throws ContextError {
	    Types type = expr.checkR();
        
	    if (operator.getTerminal() == Terminals.ADDOPR) {
	        switch(((AddOpr) operator).getOperator()) {
	            case PLUS:
    	        case MINUS:
                    if (type == Types.INT32) {
                        return Types.INT32;
                    } else {
                        throw new ContextError(
                                "Type error in Operator "
                                + ((AddOpr) operator).getOperator(),
                                operator.getLine());
                    }
    	        default:
                    throw new RuntimeException();
                  
	        }
	    } else if (operator.getTerminal() == Terminals.NOT) {
	        if (type == Types.BOOL) {
	            return Types.BOOL;
	        } else {
	            throw new ContextError(
                        "Type error in Operator "
                        + operator.getTerminal(),
                        operator.getLine());
	        }
	    } else {
	        throw new RuntimeException();
	    }
	}
	
	@Override
    public Types checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found operator " 
                + operator.getTerminal() 
                + "in the left part of an assignement",
                operator.getLine());
    }
}

