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

public final class Param implements IParam {
	private final FlowMode flowMode;
	private final MechMode mechMode;
	private final IStoreDecl storeDecl;
	private final IParam param;
	
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
        Store store = storeDecl.check();
        
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
}
