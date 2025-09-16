package com.aoc2023.aoc2023.challenges.day02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private final int id;
    private final List<Handful> handfuls = new ArrayList<>();

    public Game(String line) {
        // Retrieve Game ID
        Pattern pattern = Pattern.compile("Game (\\d*):");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Invalid game: " + line);
        }

        // Count handfuls taken
        String[] handfulTexts = line.split(":")[1].split(";");

        // Retrieve cube data from each handful
        for (String handfulText : handfulTexts) {
            handfuls.add(new Handful(handfulText));
        }
    }

    public boolean isPossible(int red, int green, int blue) {
        boolean possible = true;
        for (Handful handful : handfuls) {
            possible = possible && handful.isPossible(red, green, blue);
        }

        return possible;
    }

    // Returns length 3 array with smallest amount of (resp.) red, green, and blue cubes.
    private int[] getMin() {
        int[] min = new int[]{0, 0, 0};

        for (Handful handful : handfuls) {
            if (handful.getRed() >= min[0]) {
                min[0] = handful.getRed();
            }

            if (handful.getGreen() >= min[1]) {
                min[1] = handful.getGreen();
            }

            if (handful.getBlue() >= min[2]) {
                min[2] = handful.getBlue();
            }
        }

        return min;
    }

    public int getPower() {
        int[] min = getMin();
        return min[0] * min[1] * min[2];
    }

    public int getId() {
        return id;
    }
}
