package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class Parameter {
    private final Modes flowMode;
    private final Modes mechMode;
    private final Modes changeMode;
    
    public Parameter(
            final Modes flowMode, 
            final Modes mechMode, 
            final Modes changeMode) {
        this.flowMode = flowMode;
        this.mechMode = mechMode;
        this.changeMode = changeMode;
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
}
