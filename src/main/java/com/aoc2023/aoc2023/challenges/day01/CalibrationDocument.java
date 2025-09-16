package com.aoc2023.aoc2023.challenges.day01;

import java.util.ArrayList;
import java.util.List;

public class CalibrationDocument {
    private final List<Line> lines;

    public CalibrationDocument(String input) {
        this.lines = new ArrayList<>();

        for (String line : input.split("\n")) {
            this.lines.add(new Line(line));
        }
    }

    public int getTotalCalibrationValue(boolean includeLetters) {
        int total = 0;
        for (Line line : lines) {
            total += line.getCalibrationValue(includeLetters);
        }

        return total;
    }
}
