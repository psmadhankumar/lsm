package io.db.lsm.indexes;

public interface IndexMaintainer {

    void put(String key, int startOffSet, int endOffSet);

    String get(String key);
}
