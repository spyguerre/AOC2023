package com.aoc2023.aoc2023.challenges.day03;

import com.aoc2023.aoc2023.util.Cell;
import com.aoc2023.aoc2023.util.CharMap2D;
import com.aoc2023.aoc2023.util.Coordinates;
import com.aoc2023.aoc2023.util.Map2D;

import java.util.ArrayList;
import java.util.List;

public class EngineSchematic extends CharMap2D {
    private final Map2D<Star> starsMap = new Map2D<>();

    public EngineSchematic(String input) {
        super(input);
        initStarsMap();
    }

    private void initStarsMap() {
        for (int i = 0; i < getHeight(); i++) {
            starsMap.getGrid().add(new ArrayList<>());
            for (int j = 0; j < getWidth(); j++) {
                starsMap.getGrid().getLast().add(this.get(i, j) == '*' ? new Star(new Coordinates(i, j)) : null);
            }
        }
    }

    private List<MapNumber> parseNumbers() {
        List<MapNumber> numbers = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            int currentNumber = 0;

            for (int j = 0; j < getWidth(); j++) {
                if (Character.isDigit(this.get(i, j))) {
                    currentNumber *= 10;
                    currentNumber += Character.getNumericValue(this.get(i, j));
                } else {
                    if (currentNumber != 0) {
                        Coordinates coos = new Coordinates(i, j);
                        MapNumber mapNumber = new MapNumber(currentNumber, coos);
                        mapNumber.getCoos().setJ(mapNumber.getCoos().getJ() - mapNumber.getLength()); // Set coordinates to start of number instead of end
                        numbers.add(mapNumber);
                    }
                    currentNumber = 0;
                }
            }
            if (currentNumber != 0) {
                Coordinates coos = new Coordinates(i, getWidth());
                MapNumber mapNumber = new MapNumber(currentNumber, coos);
                mapNumber.getCoos().setJ(mapNumber.getCoos().getJ() - mapNumber.getLength()); // Set coordinates to start of number instead of end
                numbers.add(mapNumber);
            }
        }

        return numbers;
    }

    private List<MapNumber> getPartNumbers() {
        List<MapNumber> allNumbers = parseNumbers();

        List<MapNumber> partNumbers = new ArrayList<>();

        for (MapNumber number : allNumbers) {
            if (number.isPartNumber(this)) {
                partNumbers.add(number);
            }
        }

        return partNumbers;
    }

    public int getPartNumbersSum() {
        List<MapNumber> partNumbers = getPartNumbers();
        int sum = 0;

        for (MapNumber number : partNumbers) {
            sum += number.getValue();
        }

        return sum;
    }

    private void iterStarsAdjacency() {
        List<MapNumber> allNumbers = parseNumbers();

        for (MapNumber number : allNumbers) {
            List<Coordinates> starCoosList = new ArrayList<>();
            if (number.isPartNumber(this, starCoosList)) { // Fills the stars coos list with coordinates of adjacent stars
                for (Coordinates starCoos : starCoosList) {
                    // Check that the number isn't already in the list
                    boolean exists = false;
                    List<MapNumber> adjNumbers = starsMap.get(starCoos).getAdjacentNumbers();
                    for (MapNumber adjNumber : adjNumbers) {
                        if (adjNumber.equals(number)) {
                            exists = true;
                        }
                    }
                    if (!exists) {
                        starsMap.get(starCoos).getAdjacentNumbers().add(number);
                    }
                }
            }
        }
    }

    public int getGearRatioSum() {
        iterStarsAdjacency();

        int sum = 0;

        for (Cell<Star> starCell : starsMap.toList()) {
            sum += starCell.getContent() != null ? starCell.getContent().getGearRatio() : 0;
        }

        return sum;
    }
}
