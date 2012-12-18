package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class GlobImp {
    private final Modes flowMode;
    private final Modes changeMode;
    private final String ident;
    
    public Modes getFlowMode() {
        return flowMode;
    }

    public Modes getChangeMode() {
        return changeMode;
    }

    public String getIdent() {
        return ident;
    }

    public GlobImp(
            final Modes flowMode,
            final Modes changeMode,
            final String ident) {
        this.flowMode = flowMode;
        this.changeMode = changeMode;
        this.ident = ident;
    } 
}
