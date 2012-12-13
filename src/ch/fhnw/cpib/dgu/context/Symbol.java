package ch.fhnw.cpib.dgu.context;

import ch.fhnw.cpib.dgu.token.enums.Types;

public abstract class Symbol {
    private String ident;
    private Types type;
    
    public final String getIdent() {
        return ident;
    }
    
    public final Types getType() {
        return type;
    }
    
    protected Symbol(final String ident, final Types type) {
        this.ident = ident;
        this.type = type;
    }
}
