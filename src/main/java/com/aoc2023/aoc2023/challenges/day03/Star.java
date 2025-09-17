package com.aoc2023.aoc2023.challenges.day03;

import com.aoc2023.aoc2023.util.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Star {
    private final Coordinates coos;
    private final List<MapNumber> adjNumbers = new ArrayList<>();

    public Star(Coordinates coos) {
        this.coos = coos;
    }

    public Coordinates getCoos() {
        return coos;
    }

    public List<MapNumber> getAdjacentNumbers() {
        return adjNumbers;
    }

    public int getGearRatio() {
        if (adjNumbers.size() == 2) {
            int res = 1;
            for (MapNumber number : adjNumbers) {
                res *= number.getValue();
            }
            return res;
        } else {
            return 0;
        }
    }

    public String toString() {
        return getGearRatio() == 0 ? "_" : "*";
    }
}
