package io.db.lsm.reader;

public interface LSMReadDriver {
    String get(String key);
}
