package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Types;

public final class Function extends Routine {
    
    public Function(final String ident, final Types type) {
        super(ident, type, RoutineTypes.FUNCTION);
    }
    
}
