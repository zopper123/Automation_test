package utils;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileUtility {

    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE);
    }

    public static List<String> readAllLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public static void appendToFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
    }
}
