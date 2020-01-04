package io.db.lsm.file.utils;

import io.db.lsm.factory.IndexFactory;
import io.db.lsm.indexes.IndexMaintainer;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;

public class SegmentFileUtils {

    static IndexMaintainer indexMaintainer = null;

    static {
        indexMaintainer = IndexFactory.getIndexMaintainerInstance();
    }

    public void writeToFile(@NotNull String key, @NotNull String msg) throws IOException {
        RandomAccessFile randomAccessFile = createSegmentFile();

        //long currentTime = System.currentTimeMillis();
        int keyLength = key.length();
        int msgLength = msg.length();

        byte kFirstByte = (byte)(keyLength & 0xFF);
        byte kSecondByte = (byte)((keyLength >> 8) & 0xFF);

        byte mFirstByte = (byte)(msgLength & 0xFF);
        byte mSecondByte = (byte)((msgLength >> 8) & 0xFF);
        byte mThirdByte = (byte)((msgLength >> 16) & 0xFF);
        byte mFourthByte = (byte)((msgLength >> 24) & 0xFF);

        //StringBuilder sb = new StringBuilder();
        //sb.append(kFirstByte).append(kSecondByte);
        //sb.append(mFirstByte).append(mSecondByte).append(mThirdByte).append(mFourthByte);

        long oldPointer = randomAccessFile.length();
        System.out.println("Writing starts at position:" + oldPointer);
        randomAccessFile.seek(oldPointer);
        randomAccessFile.writeUTF(key + msg);

        indexMaintainer.put(key, getCurrentFileName(),String.valueOf(oldPointer), String.valueOf(randomAccessFile.length()));
    }

    private RandomAccessFile createSegmentFile() throws IOException {

        Properties props = System.getProperties();
        String directory = props.getProperty("user.dir");

        File file = new File(directory + "/" + getCurrentFileName());
        //FileOutputStream fileOutputStream = new FileOutputStream(file);

        //OutputStream stream = new BufferedOutputStream(fileOutputStream);
        //OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.defaultCharset());
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        return randomAccessFile;
    }

    private String getCurrentFileName() {
        return "Segment_File.txt";
    }
}
