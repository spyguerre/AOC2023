package com.aoc2023.aoc2023.util;

public class Cell<E> {
    private final Coordinates coos;
    private E content;

    public Cell(final Coordinates coos, final E content) {
        this.coos = coos;
        this.content = content;
    }

    public Coordinates getCoos() {
        return coos;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }
}
