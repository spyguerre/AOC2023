package com.aoc2023.aoc2023.challenges.day01;

import java.util.ArrayList;
import java.util.List;

public class DigitList extends ArrayList<Digit> {
    private final List<Digit> digits = new ArrayList<>();

    public DigitList(String text) {
        String[] digitsStrings = new String[]{
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "1",   "2",   "3",     "4",     "5",   "6",   "7",     "8",     "9"
        };

        for (int i = 0; i < digitsStrings.length; i++) {
            String digitString = digitsStrings[i];
            int k = 0; // Index at which to start looking for the next occurence of the string within this.text
            int digitIndex = text.indexOf(digitString, k);
            while (digitIndex != -1) {
                digits.add(new Digit(i%9+1, digitIndex));
                k = digitIndex + 1;
                digitIndex = text.indexOf(digitString, k);
            }
        }
    }

    public int getCalibrationValue() {
        sortList();

        return 10*digits.getFirst().getValue() + digits.getLast().getValue();
    }

    private void sortList() {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < digits.size() - 1; i++) {
                if (digits.get(i).getLocation() >= digits.get(i + 1).getLocation()) {
                    flag = true;
                    // Invert both Digits
                    Digit temp = digits.get(i);
                    digits.set(i, digits.get(i+1));
                    digits.set(i + 1, temp);
                }
            }
        }
    }
}
