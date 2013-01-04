package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.context.Procedure;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.HeapTooSmallError;

public final class ProcDecl implements IDecl {
	private final Ident ident;
	private final IParam param;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public ProcDecl(final Ident ident, final IParam param,
			final IGlobImp globImp, final ICpsDecl cpsDecl, final ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ProcDecl>\n"
				+ ident.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</ProcDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public void checkDeclaration() throws ContextError {
        Procedure procedure = new Procedure(
                ident.getIdent().toString());
        IMLCompiler.setScope(procedure.getScope());
        
        if (!IMLCompiler.getRoutineTable().addRoutine(procedure)) {
            throw new ContextError("Ident already declared: "
                    + ident.getIdent(), ident.getLine());
        }
        
        param.check(procedure);
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
        
        globImp.check(routine);
        
        int localsCount 
            = param.calculateAddress(routine.getParamList().size(), 0);
        
        cpsDecl.check(localsCount);
        cmd.check(false);
        
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
        
        IMLCompiler.getVM().Return(loc1++, 0);
                
        IMLCompiler.setScope(null);
        return loc1;
    }
}
