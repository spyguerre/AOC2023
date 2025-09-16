package com.aoc2023.aoc2023.challenges.day01;

public class Line {
    private final String text;

    public Line(String text) {
        this.text = text;
    }

    // Part 1
    private int getFirstDigit() {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return Character.getNumericValue(text.charAt(i));
            }
        }

        throw new IllegalArgumentException();
    }

    // Part 1
    private int getLastDigit() {
        for (int i = text.length() - 1; i >= 0; i--) {
            if (Character.isDigit(text.charAt(i))) {
                return Character.getNumericValue(text.charAt(i));
            }
        }

        throw new IllegalArgumentException();
    }

    // Use false for Part 1, true for Part 2
    public int getCalibrationValue(boolean includeLetters) {
        if (!includeLetters) {
            return 10*getFirstDigit() + getLastDigit();
        } else {
            return new DigitList(text).getCalibrationValue();
        }
    }
}
