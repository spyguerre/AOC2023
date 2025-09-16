package com.aoc2023.aoc2023.challenges.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handful {
    private final int red;
    private final int green;
    private final int blue;

    public Handful(String inputText) {
        Pattern patternRed = Pattern.compile("(\\d*) red");
        Pattern patternGreen = Pattern.compile("(\\d*) green");
        Pattern patternBlue = Pattern.compile("(\\d*) blue");

        Matcher matcherRed = patternRed.matcher(inputText);
        Matcher matcherGreen = patternGreen.matcher(inputText);
        Matcher matcherBlue = patternBlue.matcher(inputText);

        this.red = matcherRed.find() ? Integer.parseInt(matcherRed.group(1)) : 0;
        this.green = matcherGreen.find() ? Integer.parseInt(matcherGreen.group(1)) : 0;
        this.blue = matcherBlue.find() ? Integer.parseInt(matcherBlue.group(1)) : 0;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isPossible(int red, int green, int blue) {
        return this.red <= red && this.green <= green && this.blue <= blue;
    }
}
