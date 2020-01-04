package io.db.lsm;

import io.db.lsm.file.utils.SegmentFileUtils;

import java.io.IOException;

public class MainClassToTest {

    public static void main(String[] args) {
        SegmentFileUtils fileUtils = new SegmentFileUtils();
        try {
            fileUtils.writeToFile("Madhan","Hello World, for Madhan");
            fileUtils.writeToFile("Vijay","Hello World, for Vijay");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
