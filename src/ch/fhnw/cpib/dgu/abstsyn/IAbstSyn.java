package ch.fhnw.cpib.dgu.abstsyn;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.dgu.context.Parameter;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.cpib.dgu.context.Store;
import ch.fhnw.cpib.dgu.token.enums.Types;

public interface IAbstSyn {
	public interface IProgram extends IAbstSyn {
	    void check() throws ContextError;
	}
	
	public interface ICpsDecl extends IAbstSyn {
	    void checkDeclaration() throws ContextError;
	    void check(boolean isGlobal) throws ContextError;
	}
	public interface IDecl extends IAbstSyn {
	    void checkDeclaration() throws ContextError;
	    void check(boolean isGlobal) throws ContextError;
	}
	public interface IStoreDecl extends IDecl {
        Types getType();
        String getIdent();
        Store check() throws ContextError;
    }
	
	public interface ICmd extends IAbstSyn {
	    void check(boolean canInit) throws ContextError;
	}
	public interface IParam extends IAbstSyn {
	    void check(Routine routine) throws ContextError;
	    void checkInit() throws ContextError;
	}
	public interface IGlobImp extends IAbstSyn {
	    void check(Routine routine) throws ContextError;
	    void checkInit() throws ContextError;
	}
	public interface IExpr extends IAbstSyn {
	    Types checkR() throws ContextError;
	    Types checkL(boolean canInit) throws ContextError;
	}
	public interface IExprList extends IAbstSyn {
	    void check(
	            List<Parameter> paramList, 
	            Set<String> aliasList, 
	            boolean canInit)
	            throws ContextError;
	}
	public interface IGlobInit extends IAbstSyn {
	    Set<String> check(Set<String> initList)
	            throws ContextError;
	}
	
	String toString(String indent);
	int getLine();
	
	@SuppressWarnings("serial")
    public static final class ContextError extends Exception {
        public ContextError(final String errorMessage, final int line) {
            super(errorMessage + "\n\tat line:" + line);
            
        }
    }
}
