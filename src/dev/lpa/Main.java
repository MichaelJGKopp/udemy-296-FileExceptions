package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String filename = "testing.csv";

        testFile(filename);

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.out.println("Exiting program");
            return;
        }
        System.out.println("File exists");
    }

    public static void testFile(String filename) {

        Path path = Paths.get(filename);
        FileReader fileReader = null;
        try // (FileReader fileReader = new FileReader(filename))
        {
//            List<String> lines = Files.readAllLines(path);
            fileReader = new FileReader(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("File read attempt completed");
        }
        System.out.println("File read successfully");
    }

    public static void testFile2(String filename) {

        try {
            FileReader reader2 = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File exists and able to use as a resource");
    }//            System.out.println("File '" + filename + "' does not exist");
}
