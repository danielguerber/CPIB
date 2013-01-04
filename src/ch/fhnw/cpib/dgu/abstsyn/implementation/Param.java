package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam;
import ch.fhnw.cpib.dgu.context.Parameter;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.context.Routine.RoutineTypes;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.MechMode;
import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class Param implements IParam {
	private final FlowMode flowMode;
	private final MechMode mechMode;
	private final IStoreDecl storeDecl;
	private final IParam param;
	private Store store;
	
	public Param(final FlowMode flowMode, 
	        final MechMode mechMode, 
	        final IStoreDecl storeDecl,
			final IParam param) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.storeDecl = storeDecl;
		this.param = param;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Param>\n"
				+ flowMode.toString(indent + '\t')
				+ mechMode.toString(indent + '\t')
				+ storeDecl.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ indent
				+ "</Param>\n";
	}
	
	@Override
	public int getLine() {
	    return storeDecl.getLine();
	}

    @Override
    public void check(final Routine routine) throws ContextError {
        store = storeDecl.check();
        switch (flowMode.getMode()) {
            case IN:
                if (mechMode.getMode() == Modes.REF  && !store.isConst()) {
                    throw new ContextError(
                            "IN reference parameter can not be var! Ident: "
                                    + store.getIdent(),
                            storeDecl.getLine());
                }
                store.initialize();
                break;
            case INOUT:
                if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
                    throw new ContextError(
                            "INOUT parameter in function declaration! Ident: "
                                    + store.getIdent(),
                            storeDecl.getLine());
                }
                if (store.isConst()) {
                    throw new ContextError(
                            "INOUT parameter can not be constant! Ident: "
                                    + store.getIdent(),
                            storeDecl.getLine());
                }
                store.initialize();
                break;
            case OUT:
                if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
                    throw new ContextError(
                            "OUT parameter in function declaration! Ident: "
                                    + store.getIdent(),
                            storeDecl.getLine());
                }
                break;
            default:
                break;
        }
        
        Modes changeMode = Modes.CONST;
        if (!store.isConst()) {
            changeMode = Modes.VAR;
        }
        
        routine.addParam(new Parameter(
                flowMode.getMode(), 
                mechMode.getMode(), 
                changeMode,
                store.getType()));
        
        param.check(routine);
    }

    @Override
    public void checkInit() throws ContextError {
        if (flowMode.getMode() == Modes.OUT) {
            if (!IMLCompiler.getScope().getStoreTable().getStore(
                    storeDecl.getIdent()).isInitialized()) {
                throw new ContextError(
                        "OUT parameter is never initialized! Ident: "
                                + storeDecl.getIdent(),
                        storeDecl.getLine());
            }
        }
        
        param.checkInit();
    }

    @Override
    public int calculateAddress(final int count, final int locals) {
        int locals1 = locals;
        if (flowMode.getMode() == Modes.IN
                || mechMode.getMode() == Modes.REF) {
            store.setAddress(-count);
            store.setRelative(true);
            if (mechMode.getMode() == Modes.REF) {
                store.setReference(true);
            } else {
                store.setReference(false);
            }
            
        } else {
            store.setAddress(2 + ++locals1);
            store.setRelative(true);
            store.setReference(false);
        }
        return param.calculateAddress(count - 1, locals1);
    }

    @Override
    public int codeIn(final int loc, final int count, final int locals) 
            throws CodeTooSmallError {
        int locals1 = locals;
        int loc1 = loc;
        if (flowMode.getMode() != Modes.IN
                && mechMode.getMode() == Modes.COPY) {
            if (flowMode.getMode() == Modes.INOUT) {
                IMLCompiler.getVM().CopyIn(loc1++, -count, 3 + locals1);
            }
            locals1++;
        }
        return param.codeIn(loc1, count - 1, locals1);
    }
    
    @Override
    public int codeOut(final int loc, final int count, final int locals) 
            throws CodeTooSmallError {
        int locals1 = locals;
        int loc1 = loc;
        if (flowMode.getMode() != Modes.IN
                && mechMode.getMode() == Modes.COPY) {
            IMLCompiler.getVM().CopyOut(loc1++, 2 + ++locals1, -count);
        }
        return param.codeOut(loc1, count - 1, locals1);
    }
}
