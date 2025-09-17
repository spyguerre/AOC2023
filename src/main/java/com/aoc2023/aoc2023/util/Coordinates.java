package com.aoc2023.aoc2023.util;

import java.util.Objects;

public class Coordinates {
    public static final Coordinates[] dir4 = {
            new Coordinates(0, 1),
            new Coordinates(1, 0),
            new Coordinates(0, -1),
            new Coordinates(-1, 0)
    };
    public static final Coordinates[] dir8 = {
            new Coordinates(0, 1),
            new Coordinates(1, 1),
            new Coordinates(1, 0),
            new Coordinates(1, -1),
            new Coordinates(0, -1),
            new Coordinates(-1, -1),
            new Coordinates(-1, 0),
            new Coordinates(-1, 1)
    };

    private Integer i;
    private Integer j;

    public Coordinates(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public void incrI() {
        this.i++;
    }

    public void decrI() {
        this.i--;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public void incrJ() {
        this.j++;
    }

    public void decrJ() {
        this.j--;
    }

    public Coordinates copy() {
        return new Coordinates(i, j);
    }

    public Coordinates add(Coordinates c) {
        return new Coordinates(i + c.i, j + c.j);
    }

    public Coordinates multiply(int k) {
        return new Coordinates(i * k, j * k);
    }

    public String toString() {
        return "(" + i + ", " + j + ")";
    }

    public boolean equals(Coordinates c2) {
        return Objects.equals(i, c2.getI()) && Objects.equals(j, c2.getJ());
    }
}
