package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IDecl;
import ch.fhnw.cpib.dgu.context.Procedure;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.token.classes.Ident;

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
    public void check(final boolean isGlobal) throws ContextError {
        if (!isGlobal) {
            throw new ContextError(
                    "Procedure declarations are only allowed globally!", 
                    ident.getLine());
        }
        
        Routine symbol = IMLCompiler.getRoutineTable().getRoutine(
                ident.getIdent().toString());
        IMLCompiler.setScope(symbol.getScope());
        
        globImp.check(symbol);
        cpsDecl.check(false);
        cmd.check(false);
        param.checkInit();
        globImp.checkInit();
        
        IMLCompiler.setScope(null);
    }
}
