package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Types;

public final class Store extends Symbol {
    private boolean writeable;
    private boolean initialized;
    private boolean isConst;
    
    public Store(
            final String ident, 
            final Types type, 
            final boolean isConst) {
        super(ident, type);
        this.writeable = true;
        this.initialized = false;
        this.isConst = isConst;
    }
    
    public boolean isConst() {
        return isConst;
    }

    public boolean isWriteable() {
        return writeable;
    }

    public boolean isInitialized() {
        return initialized;
    }
    
    public void initialize() { 
        initialized = true;
        if (isConst) {
            writeable = false;
        }
    }

}
