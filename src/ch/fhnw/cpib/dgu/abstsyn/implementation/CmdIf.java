package ch.fhnw.cpib.dgu.abstsyn.implementation;

import java.sql.Types;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;
import ch.fhnw.cpib.dgu.context.Scope;
import ch.fhnw.cpib.dgu.context.Store;

public final class CmdIf implements ICmd {
	private final IExpr expr;
	private final ICmd ifCmd;
	private final ICmd elseCmd;
	private final ICmd repCmd;
	
	public CmdIf(final IExpr expr, 
	        final ICmd ifCmd, 
	        final ICmd elseCmd, 
	        final ICmd repCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
		this.repCmd = repCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdIf>\n"
				+ expr.toString(indent + '\t')
				+ ifCmd.toString(indent + '\t')
				+ elseCmd.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdIf>\n";
	}
	
	@Override
    public int getLine() {
        return expr.getLine();
    }

    @Override
    public void check(final boolean canInit) throws ContextError {
        if (!expr.checkR().equals(Types.BOOLEAN)) {
            throw new ContextError(
                    "IF condition must be a boolean! ",
                     expr.getLine());
        }
        
        Scope parentScope = IMLCompiler.getScope();
        Scope ifScope 
            = new Scope(parentScope.getStoreTable().clone());
        Scope elseScope 
            = new Scope(parentScope.getStoreTable().clone());
        
        IMLCompiler.setScope(ifScope);
        ifCmd.check(canInit);
        IMLCompiler.setScope(elseScope);
        elseCmd.check(canInit);
        
        for (Store store : parentScope.getStoreTable().getTable().values()) {
            if (!store.isInitialized()) {
                Store storeIf 
                    = ifScope.getStoreTable().getStore(store.getIdent());
                Store storeElse 
                    = elseScope.getStoreTable().getStore(store.getIdent());
                
                if (storeIf.isInitialized() != storeElse.isInitialized()) {
                    throw new ContextError(
                            "Initialization must happen in both branches of an" 
                                    + " IF command! Ident: " + store.getIdent(),
                             expr.getLine());
                }
                
                if (storeIf.isInitialized()) {
                    store.initialize();
                }
            }
        }
        
        IMLCompiler.setScope(parentScope);
        
        repCmd.check(canInit);
    }
}
