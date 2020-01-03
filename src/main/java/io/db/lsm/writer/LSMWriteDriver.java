package io.db.lsm.writer;

public interface LSMWriteDriver {
    void write(String key, String value);
}
