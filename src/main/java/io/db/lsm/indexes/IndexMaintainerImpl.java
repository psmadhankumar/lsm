package io.db.lsm.indexes;

import java.util.HashMap;
import java.util.Map;

public class IndexMaintainerImpl implements IndexMaintainer {

    Map<String, String[]> indexes = null;


    public IndexMaintainerImpl() {
        indexes = new HashMap<>();
    }

    @Override
    public void put(String key, String fileName, String startOffSet, String endOffSet) {

        System.out.println("key:" + key + " filename:" + fileName + " start:" + startOffSet + " end:" + endOffSet);
        if(indexes.get(key) != null) {
            System.out.println("Key already present in the map, overwriting");
        }

        //index keeps track of the fileName, start and end offset
        indexes.put(key, new String[]{fileName, startOffSet, endOffSet});

    }

    @Override
    public String get(String key) {
        return null;
    }
}
