package ch.fhnw.cpib.dgu.context;

import java.util.Map;
import java.util.TreeMap;

import ch.fhnw.cpib.dgu.token.enums.Types;

public final class RoutineTable {
    private Map<String, Routine> routineMap;
    
    public RoutineTable() {
        routineMap = new TreeMap<String, Routine>();
    }
    
    public boolean addRoutine(final Routine routine) {
        if (!routineMap.containsKey(routine.getIdent())) {
            routineMap.put(routine.getIdent(), routine);
            return true;
        } else {
            return false;
        }
    }

    public Types getType(final String ident) {
        if (routineMap.containsKey(ident)) {
            return routineMap.get(ident).getType();
        } else {
            return null;
        }
    }

    public Routine getRoutine(final String ident) {
        return routineMap.get(ident);
    }
    
    public Map<String, Routine> getTable() {
        return routineMap;
    }
}
