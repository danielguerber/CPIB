package ch.fhnw.cpib.dgu.context;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.cpib.dgu.token.enums.Types;

public abstract class Routine extends Symbol {
    
    private Scope scope;
    private RoutineTypes routineType;
    private List<Parameter> paramList = new ArrayList<Parameter>();
    
    protected Routine(
            final String ident, 
            final Types type, 
            final RoutineTypes routineType) {
        super(ident, type);
        this.routineType = routineType;
        this.scope = new Scope();
    }
    
    public final Scope getScope() {
        return scope;
    }
    
    public final RoutineTypes getRoutineType() {
        return routineType;
    }
    
    public final List<Parameter> getParamList() {
        return paramList;
    }
    
    public final void addParam(final Parameter param) {
        paramList.add(param);
    }
    
    public enum RoutineTypes {
        FUNCTION,
        PROCEDURE
    }
}