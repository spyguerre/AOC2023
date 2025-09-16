package com.aoc2023.aoc2023.challenges.day01;

import com.aoc2023.aoc2023.FileReaderAOC;

public class Day01 {
    static String input = FileReaderAOC.readFile(1);

    public static int part1() {
        return new CalibrationDocument(input).getTotalCalibrationValue(false);
    }

    public static int part2() {
        return new CalibrationDocument(input).getTotalCalibrationValue(true);
    }
}
