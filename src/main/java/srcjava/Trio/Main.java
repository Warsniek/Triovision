package srcjava.Trio;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: "); //nb de joueurs
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        List<String> playerNames = new ArrayList<>(); //nom
        List<String> playerColors = new ArrayList<>();//couelurs
        int boardSize = numberOfPlayers;

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            playerNames.add(playerName);

            System.out.print("Enter color for player " + (i + 1) + ": ");
            String playerColor = scanner.nextLine();
            playerColors.add(playerColor);
        }

        Game game = new Game(boardSize, playerNames, playerColors); //instance de la classe game avec toutes les données

        game.play(); //lancement du jeu

        scanner.close();
    }
}
