package com.aoc2023.aoc2023.util;

import java.util.ArrayList;

public class CharMap2D extends Map2D<Character> {
    public CharMap2D(String input) {
        super();

        for (String line : input.split("\n")) {
            this.grid.add(new ArrayList<>());
            for (Character c : line.toCharArray()) {
                if (c != '\r' && c != '\n') {
                    this.grid.getLast().add(c);
                }
            }
        }
    }
}
