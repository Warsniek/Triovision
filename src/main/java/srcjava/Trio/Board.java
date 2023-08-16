package srcjava.Trio;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private String[][] grid;  //grille
    private List<Player> players; //joueurs
    private List<Card> exposedCards; //cartes retournées


//constructeur:
    public Board(int size) {
        grid = new String[size][size];
        players = new ArrayList<>();
        exposedCards = new ArrayList<>();
    }

//moov valide ou non
    public boolean isValidMove(int row, int col, Player player) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) {
            return grid[row][col].equals(player.getColor());
        }
        return false;
    }
//condition de réussite
    public boolean checkWinCondition(Card card) {
        String[][] layout = card.getLayout(); //recupere la position des cartes
        for (int i = 0; i <= grid.length - layout.length; i++) {
            for (int j = 0; j <= grid[i].length - layout[0].length; j++) {
                if (checkLayoutMatch(layout, i, j)) { //check les possitions
                    return true; // conditions remplies donc victoire
                }
            }
        }
        return false; //conditions non remplies donc vistoire
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


    // mouvement sur le plateau
    public void makeMove(int row, int col, Player player) {
        grid[row][col] = player.getColor();//mise a jour des info
        if (checkWinCondition(exposedCards.get(0))) {
            player.increaseScore(); //incremente les scores des joueurs
            exposedCards.remove(0); //supprime la cartes remportées par le joueur
        }
    }
//affiche le plateau
    public void displayBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}

