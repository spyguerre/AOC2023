package com.aoc2023.aoc2023.challenges.day01;

public class Digit {
    private final int value;
    private final int location;

    public Digit(int value, int location) {
        this.value = value;
        this.location = location;
    }

    public int getValue() {
        return value;
    }

    public int getLocation() {
        return location;
    }
}
