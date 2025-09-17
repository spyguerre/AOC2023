package com.aoc2023.aoc2023.challenges.day03;

import com.aoc2023.aoc2023.FileReaderAOC;

public class Day03 {
    static String input = FileReaderAOC.readFile(3);

    public static int part1() {
        return new EngineSchematic(input).getPartNumbersSum();
    }

    public static int part2() {
        return new EngineSchematic(input).getGearRatioSum();
    }
}
