package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Operator;
import ch.fhnw.cpib.dgu.token.enums.Operators;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class ExprDyadic implements IExpr {
	private final Operator operator;
	private final IExpr expr1;
	private final IExpr expr2;
	private ContextError error;
	
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
	public Types checkR() throws ContextError {
	    if (error != null) {
	        throw error;
	    }
	    
	    Types type1 = expr1.checkR();
	    Types type2 = expr2.checkR();
	    
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
                    return Types.BOOL;
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
    public Types checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found operator " 
                + operator.getOperator() 
                + "in the left part of an assignement",
                operator.getLine());
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = expr1.code(loc);
        if (operator.getOperator() != Operators.CAND 
                && operator.getOperator() != Operators.COR) {
            loc1 = expr2.code(loc1);
            switch (operator.getOperator()) {
                case PLUS:
                    IMLCompiler.getVM().IntAdd(loc1);
                    break;
                case MINUS:
                    IMLCompiler.getVM().IntSub(loc1);
                    break;
                case TIMES:
                    IMLCompiler.getVM().IntMult(loc1);
                    break;
                case DIV:
                    IMLCompiler.getVM().IntDiv(loc1);
                    break;
                case MOD:
                    IMLCompiler.getVM().IntMod(loc1);
                    break;
                case EQ:
                    IMLCompiler.getVM().IntEQ(loc1);
                    break;
                case NE:
                    IMLCompiler.getVM().IntNE(loc1);
                    break;
                case GT:
                    IMLCompiler.getVM().IntGT(loc1);
                    break;
                case LT:
                    IMLCompiler.getVM().IntLT(loc1);
                    break;
                case GE:
                    IMLCompiler.getVM().IntGE(loc1);
                    break;
                case LE:
                    IMLCompiler.getVM().IntLE(loc1);
                    break;
                default:
                    throw new RuntimeException();
            }
            return loc1 + 1;
        } else if (operator.getOperator() == Operators.CAND) {
            int loc2 = expr2.code(loc1 + 1);
            IMLCompiler.getVM().UncondJump(loc2++, loc2 + 1);
            IMLCompiler.getVM().CondJump(loc1, loc2);
            IMLCompiler.getVM().IntLoad(loc2++, 0);
            return loc2;
        } else {
            int loc2 = expr2.code(loc1 + 2);
            IMLCompiler.getVM().UncondJump(loc2++, loc2 + 1);
            IMLCompiler.getVM().CondJump(loc1, loc1 + 2);
            IMLCompiler.getVM().UncondJump(loc1 + 1, loc2);
            IMLCompiler.getVM().IntLoad(loc2++, 1);
            return loc2;
        }
    }

    public void setError(final ContextError contextError) {
        error = contextError;
    }
}
