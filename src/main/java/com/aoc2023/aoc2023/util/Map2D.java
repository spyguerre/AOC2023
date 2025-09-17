package com.aoc2023.aoc2023.util;

import java.util.ArrayList;
import java.util.List;

public class Map2D<E> {
    protected final List<List<E>> grid;

    public Map2D(List<List<E>> grid) {
        this.grid = grid;
    }

    public Map2D() {
        this.grid = new ArrayList<>();
    }

    public List<List<E>> getGrid() {
        return grid;
    }

    public E get(int i, int j) {
        return this.grid.get(i).get(j);
    }

    public E get(Coordinates c) {
        if (areCoosInBounds(c)) {
            return this.grid.get(c.getI()).get(c.getJ());
        } else {
            return null;
        }
    }

    public int getHeight() {
        return this.grid.size();
    }

    public int getWidth() {
        return this.grid.getFirst().size();
    }

    public boolean areCoosInBounds(Coordinates c) {
        return 0 <= c.getI() && c.getI() < this.getHeight() && 0 <= c.getJ() && c.getJ() < this.getWidth();
    }

    public void printGrid() {
        for (List<E> line : grid) {
            StringBuilder prtLine = new StringBuilder();
            for (E e : line) {
                if (e != null) {
                    prtLine.append(e);
                } else {
                    prtLine.append("¤");
                }
            }
            System.out.println(prtLine);
        }
    }

    public List<Cell<E>> toList() {
        List<Cell<E>> result = new ArrayList<>();

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                result.add(new Cell<>(new Coordinates(i, j), this.get(i,j)));
            }
        }

        return result;
    }
}
