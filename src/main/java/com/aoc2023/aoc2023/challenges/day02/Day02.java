package com.aoc2023.aoc2023.challenges.day02;

import com.aoc2023.aoc2023.FileReaderAOC;

public class Day02 {
    static String input = FileReaderAOC.readFile(2);

    public static int part1() {
        return new GameList(input).getSumOfPossibleGamesIDs(12, 13, 14);
    }

    public static int part2() {
        return new GameList(input).getSumOfPower();
    }
}
