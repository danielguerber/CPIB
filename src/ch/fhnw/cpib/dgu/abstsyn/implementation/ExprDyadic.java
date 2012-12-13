package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Operator;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprDyadic implements IExpr {
	private final Operator operator;
	private final IExpr expr1;
	private final IExpr expr2;
	
	public ExprDyadic(final Operator operator, 
	        final IExpr expr1, 
	        final IExpr expr2) {
		this.operator = operator;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprDyadic>\n"
				+ operator.toString(indent + '\t')
				+ expr1.toString(indent + '\t')
				+ expr2.toString(indent + '\t')
				+ indent
				+ "</ExprDyadic>\n";
	}
	
	@Override
	public int getLine() {
	    return operator.getLine();
	}
	
	@Override
	public Types check() throws ContextError {
	    Types type1 = expr1.check();
	    Types type2 = expr2.check();
	    
	    switch(operator.getOperator()) {
	        case PLUS:
	        case MINUS:
	        case TIMES:
	        case DIV:
	        case MOD:
	            if (type1 == Types.INT32 
	                && type2 == Types.INT32) {
	                return Types.INT32;
	            } else {
	                throw new ContextError(
	                        "Type error in Operator "
	                        + operator.getOperator(),
	                        operator.getLine());
	            }
	        case EQ:
	        case NE:
	            if (type1 == Types.BOOL
	                && type2 == Types.BOOL) {
	                return Types.BOOL;
	            }
	        case GT:
	        case LT:
	        case GE:
	        case LE:
	            if (type1 == Types.INT32 
                    && type2 == Types.INT32) {
                    return Types.INT32;
                } else {
                    throw new ContextError(
                            "Type error in Operator "
                            + operator.getOperator(),
                            operator.getLine());
                }
	        case CAND:
	        case COR:
	            if (type1 == Types.BOOL
                    && type2 == Types.BOOL) {
                    return Types.BOOL;
                } else {
                    throw new ContextError(
                            "Type error in Operator "
                            + operator.getOperator(),
                            operator.getLine());
                }
	        default:
	            throw new RuntimeException();
	    }
	}

    @Override
    public Types checkAssign() throws ContextError {
        throw new ContextError(
                "Found operator " 
                + operator.getOperator() 
                + "in the left part of an assignement",
                operator.getLine());
    }
}
