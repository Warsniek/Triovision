package srcjava.Console;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList("Bob", "Boby", "Alice", "Fred");
        List<String> playerColors = Arrays.asList("vert", "bleu", "rouge", "jaune");
        int boardSize = 4;

        Game game = new Game(boardSize, playerNames, playerColors);

        game.play();
    }

}

