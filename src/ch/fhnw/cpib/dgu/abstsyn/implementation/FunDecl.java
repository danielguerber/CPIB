package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.context.Function;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.HeapTooSmallError;

public final class FunDecl implements IDecl {
	private final Ident ident;
	private final IParam param;
	private final IStoreDecl returnDecl;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public FunDecl(final Ident ident, 
	        final IParam param, 
	        final IStoreDecl returnDecl,
			final IGlobImp globImp, 
			final ICpsDecl cpsDecl, 
			final ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.returnDecl = returnDecl;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FunDecl>\n"
				+ ident.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ returnDecl.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</FunDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public void checkDeclaration() throws ContextError {
        Function function = new Function(
                ident.getIdent().toString(),
                returnDecl.getType());
        IMLCompiler.setScope(function.getScope());
        if (!IMLCompiler.getRoutineTable().addRoutine(function)) {
            throw new ContextError("Routine already declared: "
                    + ident.getIdent(), ident.getLine());
        }
        
        param.check(function);
        IMLCompiler.setScope(null);
    }

    @Override
    public int check(final int locals) 
            throws ContextError, HeapTooSmallError {
        if (locals >= 0) {
            throw new ContextError(
                    "Function declarations are only allowed globally!", 
                    ident.getLine());
        }
        
        Routine routine = IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        IMLCompiler.setScope(routine.getScope());
        
        Store retStore = returnDecl.check();
        retStore.setAddress(-routine.getParamList().size() - 1);
        retStore.setReference(false);
        retStore.setRelative(true);
        
        globImp.check(routine);
        
        int localsCount 
            = param.calculateAddress(routine.getParamList().size(), 0);
        
        cpsDecl.check(localsCount);
        cmd.check(false);
        
        if (!routine.getScope().getStoreTable().getStore(
                returnDecl.getIdent()).isInitialized()) {
            throw new ContextError(
                    "Return value never initialized! Function: "
                    + ident.getIdent(), ident.getLine());
        }
        
        IMLCompiler.setScope(null);
        return -1;
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = loc;
        Routine routine = IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        IMLCompiler.setScope(routine.getScope());
        
        routine.setAddress(loc1);
        IMLCompiler.getVM().Enter(
                loc1++, 
                routine.getInOutCopyCount() + cpsDecl.getCount(), 
                0);
        loc1 = param.codeIn(
                loc1, 
                routine.getParamList().size(), 
                0);
        
        loc1 = cmd.code(loc1);
        
        loc1 = param.codeOut(loc1, 
               routine.getParamList().size(),
               0);
        
        IMLCompiler.getVM().Return(loc1++, 1);
                
        IMLCompiler.setScope(null);
        
        return loc1;
    }
}
