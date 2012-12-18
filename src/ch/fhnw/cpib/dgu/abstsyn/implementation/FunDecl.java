package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.context.Function;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.token.classes.Ident;

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
    public void check(final boolean isGlobal) throws ContextError {
        if (!isGlobal) {
            throw new ContextError(
                    "Function declarations are only allowed globally!", 
                    ident.getLine());
        }
        
        Routine routine = IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        IMLCompiler.setScope(routine.getScope());
        
        returnDecl.check();
        globImp.check(routine);
        cpsDecl.check(false);
        cmd.check(false);
        
        if (!routine.getScope().getStoreTable().getStore(
                returnDecl.getIdent()).isInitialized()) {
            throw new ContextError(
                    "Return value never initialized! Function: "
                    + ident.getIdent(), ident.getLine());
        }
        
        IMLCompiler.setScope(null);
    }
}
