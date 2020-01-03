package io.db.lsm.file.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;

public class SegmentFileUtils {


    public void writeToFile(String key, String msg) throws IOException {
        RandomAccessFile writer = createSegmentFile();

        System.out.println(writer.length());
        long oldPointer = writer.length();
        System.out.println("oldPointer:" + oldPointer);
        writer.seek(oldPointer);
        writer.writeUTF(key+"," +msg);
        //long newPointer = writer.getFilePointer();
        //System.out.println("newPointer:" + newPointer);
        writer.seek(0);
        byte[] bytes = new byte[100];
        writer.read(bytes);
        writer.close();
        System.out.println(new String(bytes));
    }

    private RandomAccessFile createSegmentFile() throws IOException {

        Properties props = System.getProperties();
        String directory = props.getProperty("user.dir");

        String fileName= "Segment_File.txt";
        File file = new File(directory + "/" + fileName);
        //FileOutputStream fileOutputStream = new FileOutputStream(file);

        //OutputStream stream = new BufferedOutputStream(fileOutputStream);
        //OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.defaultCharset());
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        return randomAccessFile;
    }
}
