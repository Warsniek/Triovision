package srcjava.Console;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
package com.example.demo2;


public class Board {
    private String[][] grid;
    private List<Player> players;
    private List<Card> exposedCards;

    public Board(int size) {
        grid = new String[size][size];
        players = new ArrayList<>();
        exposedCards = new ArrayList<>();
    }

    public boolean isValidMove(int row, int col, Player player) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) {
            return grid[row][col].equals(player.getColor());
        }
        return false;
    }

    public boolean checkWinCondition(Card card) {
        String[][] layout = card.getLayout();
        for (int i = 0; i <= grid.length - layout.length; i++) {
            for (int j = 0; j <= grid[i].length - layout[0].length; j++) {
                if (checkLayoutMatch(layout, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLayoutMatch(String[][] layout, int startRow, int startCol) {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if (!layout[i][j].equals(grid[startRow + i][startCol + j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(int row, int col, Player player) {
        grid[row][col] = player.getColor();
        if (checkWinCondition(exposedCards.get(0))) {
            player.increaseScore();
            exposedCards.remove(0);
        }
    }

    public void displayBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}

