package com.aoc2023.aoc2023.challenges.day03;

import com.aoc2023.aoc2023.util.Coordinates;

import java.util.List;

public class MapNumber {
    private int value;
    private final Coordinates coos;

    public MapNumber(int value, Coordinates coos) {
        this.value = value;
        this.coos = coos;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Coordinates getCoos() {
        return this.coos;
    }

    public int getLength() {
        return String.valueOf(this.value).length();
    }

    public boolean isPartNumber(EngineSchematic schematic) {
        return isPartNumber(schematic, null);
    }

    public boolean isPartNumber(EngineSchematic schematic, List<Coordinates> starCoordinatesList) {
        boolean isPart = false;
        Coordinates coosCopy = getCoos().copy();

        for (int k = 0; k < getLength(); k++) {
            for (Coordinates dir : Coordinates.dir8) {
                Character charValue = schematic.get(coosCopy.add(dir));
                if (charValue != null && !Character.isDigit(charValue) && charValue != '.') {
                    isPart = true;
                    if (charValue == '*' && starCoordinatesList != null) {
                        starCoordinatesList.add(coosCopy.add(dir));
                    }
                }
            }

            coosCopy.incrJ();
        }

        return isPart;
    }

    public boolean equals(MapNumber n2) {
        return this.value == n2.value && this.coos.equals(n2.coos);
    }
}
