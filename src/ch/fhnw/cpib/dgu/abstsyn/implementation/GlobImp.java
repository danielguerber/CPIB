package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.context.Routine.RoutineTypes;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;
import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class GlobImp implements IGlobImp {
	private final FlowMode flowMode;
	private final ChangeMode changeMode;
	private final Ident ident;
	private final IGlobImp globImp;
	
	public GlobImp(final FlowMode flowMode, 
	        final ChangeMode changeMode, 
	        final Ident ident, 
	        final IGlobImp globImp) {
		this.flowMode = flowMode;
		this.changeMode = changeMode;
		this.ident = ident;
		this.globImp = globImp;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobImp>\n"
				+ flowMode.toString(indent + '\t')
				+ changeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ indent
				+ "</GlobImp>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public void check(final Routine routine) throws ContextError {
        Store globalStore = IMLCompiler.getGlobalStoreTable().getStore(
                ident.getIdent().toString());
        
        if (globalStore == null) {
            throw new ContextError(
                    "Global import is not declared! Ident: "
                    + ident.getIdent(), ident.getLine());
        }
        
        if (globalStore.isConst() && changeMode.getMode() != Modes.CONST) {
            throw new ContextError(
                    "Cannot import global constant as variable! Ident: "
                    + ident.getIdent(), ident.getLine());
        }
        
       Store localStore = new Store(
               globalStore.getIdent(),
               globalStore.getType(),
               changeMode.getMode() == Modes.CONST);
        
        if (!IMLCompiler.getScope().getStoreTable().addStore(localStore)) {
            throw new ContextError(
                    "Global ident already used! Ident: "
                    + ident.getIdent(), ident.getLine());
        }
        
        switch (flowMode.getMode()) {
            case IN:
                localStore.initialize();
                break;
            case INOUT:
                if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
                    throw new ContextError(
                            "FlowMode INOUT is not allowed for functions! "
                            + "Ident: " + ident.getIdent(), ident.getLine());
                }
                if (changeMode.getMode() == Modes.CONST) {
                    throw new ContextError(
                        "ChangeMode CONST is not allowed for FlowMode INOUT! "
                        + "Ident: " + ident.getIdent(), ident.getLine());
                }
                localStore.initialize();
                break;
            case OUT:
                if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
                    throw new ContextError(
                            "FlowMode OUT is not allowed for functions! Ident: "
                            + ident.getIdent(), ident.getLine());
                }
                break;
            default:
                throw new RuntimeException();
        }
        
        routine.addGlobImp(new ch.fhnw.cpib.dgu.context.GlobImp(
                flowMode.getMode(), 
                changeMode.getMode(), 
                ident.getIdent().toString()));
        
        globImp.check(routine);
    }
    
    @Override
    public void checkInit() throws ContextError {
        if (flowMode.getMode() == Modes.OUT) {
            if (!IMLCompiler.getScope().getStoreTable().getStore(
                    ident.getIdent().toString()).isInitialized()) {
                throw new ContextError(
                        "OUT global import is never initialized! Ident: "
                                + ident.getIdent(),
                        ident.getLine());
            }
        }
        
        globImp.checkInit();
    }
}
