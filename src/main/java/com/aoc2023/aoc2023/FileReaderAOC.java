package com.aoc2023.aoc2023;

public class FileReaderAOC {
    public static String readFile(int day) {
        try {
            return java.nio.file.Files.readString(java.nio.file.Path.of("src/main/java/com/aoc2023/aoc2023/challenges/day" + String.format("%02d", day) + "/input.txt"));
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
