package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class Parameter {
    private final Modes flowMode;
    private final Modes mechMode;
    private final Modes changeMode;
    private final Types type;
    
    public Parameter(
            final Modes flowMode, 
            final Modes mechMode, 
            final Modes changeMode,
            final Types type) {
        this.flowMode = flowMode;
        this.mechMode = mechMode;
        this.changeMode = changeMode;
        this.type = type;
    }

    public Modes getFlowMode() {
        return flowMode;
    }

    public Modes getMechMode() {
        return mechMode;
    }

    public Modes getChangeMode() {
        return changeMode;
    }
    
    public Types getType() {
        return type;
    }
}
