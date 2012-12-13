package ch.fhnw.cpib.dgu.context;

import java.util.Map;
import java.util.TreeMap;

import ch.fhnw.cpib.dgu.token.enums.Types;

public final class StoreTable {
    private Map<String, Store> storeMap;
    
    public StoreTable() {
        storeMap = new TreeMap<String, Store>();
    }
    
    public boolean addStore(final Store store) {
        if (!storeMap.containsKey(store.getIdent())) {
            storeMap.put(store.getIdent(), store);
            return true;
        } else {
            return false;
        }
    }

    public Types getType(final String ident) {
        if (storeMap.containsKey(ident)) {
            return storeMap.get(ident).getType();
        } else {
            return null;
        }
    }

    public Store getStore(final String ident) {
        return storeMap.get(ident);
    }
    
    public Map<String, Store> getTable() {
        return storeMap;
    }
}
