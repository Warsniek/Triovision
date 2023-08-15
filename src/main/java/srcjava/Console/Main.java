package srcjava.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine(); 

        List<String> playerNames = new ArrayList<>();
        List<String> playerColors = new ArrayList<>();
        int boardSize = numberOfPlayers;

        String[] validColors = {"bleu", "vert", "jaune", "rouge"};

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            playerNames.add(playerName);

            String playerColor;
            while (true) {
                System.out.print("Enter color for player " + (i + 1) + " (bleu/vert/jaune/rouge): ");
                playerColor = scanner.nextLine();
                if (isValidColor(playerColor, validColors)) {
                    break;
                } else {
                    System.out.println("Invalid color. Please choose from bleu, vert, jaune, or rouge.");
                }
            }
            playerColors.add(playerColor);
        }

        Game game = new Game(boardSize, playerNames, playerColors);

        game.play();

        scanner.close();
    }

    private static boolean isValidColor(String color, String[] validColors) {
        for (String validColor : validColors) {
            if (validColor.equals(color.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
