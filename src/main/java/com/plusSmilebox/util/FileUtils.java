package com.plusSmilebox.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> readFileToStringList(String filename, int noOfLinesToRead) {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(filename);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null && count++ < noOfLinesToRead) {
                result.add(line);
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> readFileToStringList(String filename) {
        return readFileToStringList(filename, Integer.MAX_VALUE);
    }
}
