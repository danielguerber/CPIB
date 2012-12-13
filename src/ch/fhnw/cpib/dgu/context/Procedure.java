package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Types;

public class Procedure extends Routine {

    public Procedure(final String ident) {
        super(ident, Types.PROC, RoutineTypes.PROCEDURE);
    }

}
