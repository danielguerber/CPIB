package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Base;
import ch.fhnw.cpib.dgu.token.classes.Operator.AddOpr;
import ch.fhnw.cpib.dgu.token.enums.Operators;
import ch.fhnw.cpib.dgu.token.enums.Terminals;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

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

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = expr.code(loc);
        if (operator.getTerminal() == Terminals.ADDOPR) {
            if (((AddOpr) operator).getOperator() == Operators.MINUS) {
                IMLCompiler.getVM().IntInv(loc1);
                return loc1 + 1;
            } else {
                return loc1;
            }
        } else if (operator.getTerminal() == Terminals.NOT) {
            IMLCompiler.getVM().CondJump(loc1++, loc1 + 2);
            IMLCompiler.getVM().IntLoad(loc1++, 0);
            IMLCompiler.getVM().UncondJump(loc1++, loc1 + 1);
            IMLCompiler.getVM().IntLoad(loc1++, 1);
            return loc1;
        } else {
            throw new RuntimeException();
        }
    }
}

