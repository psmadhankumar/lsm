package io.db.lsm.indexes;

public interface IndexMaintainer {

    void put(String key, String fileName, String startOffSet, String endOffSet);

    String get(String key);
}
