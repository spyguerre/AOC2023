package com.aoc2023.aoc2023.challenges.day02;

import java.util.ArrayList;
import java.util.List;

public class GameList extends ArrayList<Game> {
    private List<Game> games = new ArrayList<>();

    public GameList(String input) {
        for (String line : input.split("\n")) {
            games.add(new Game(line));
        }
    }

    public int getSumOfPossibleGamesIDs(int red, int green, int blue) {
        int sum = 0;

        for (Game game : games) {
            if (game.isPossible(red, green, blue)) {
                sum += game.getId();
            }
        }

        return sum;
    }

    public int getSumOfPower() {
        int sum = 0;

        for (Game game : games) {
            sum += game.getPower();
        }

        return sum;
    }
}
