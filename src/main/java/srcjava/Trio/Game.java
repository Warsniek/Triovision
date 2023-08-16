package srcjava.Trio;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board; //plateau
    private List<Player> players; //joueurs differnets
    private Deck deck;//deck des cartes
    private List<Card> exposedCards; //cartes retournées


    //constructeur
    public Game(int boardSize, List<String> playerNames, List<String> playerColors) {
        board = new Board(boardSize);
        players = new ArrayList<>();
        deck = new Deck();
        exposedCards = new ArrayList<>();

        //pioche 12 cartes pour les exposer
        for (int i = 0; i < 12; i++) {
            Card card = deck.drawCard();
            exposedCards.add(card);
        }
//création des différents players
        for (int i = 0; i < playerNames.size(); i++) {
            Player player = new Player(playerNames.get(i), playerColors.get(i));
            players.add(player);
        }
    }

//initialise le jeu
    public void initialize() {
        deck.shuffle();
        drawInitialExposedCards();
        displayInitialSetup();
    }
//pioche les cartes
    private void drawInitialExposedCards() {
        for (int i = 0; i < 12; i++) {
            Card card = deck.drawCard();
            if (card != null) {
                exposedCards.add(card);
            }
        }
    }
//affiche le debut de la partie avec toutes les initialisations
    private void displayInitialSetup() {
        System.out.println("Initial game setup:");
        for (int i = 0; i < 12; i++) {
            System.out.println("Exposed Card " + (i + 1) + ": " + exposedCards.get(i).toString());
        }
    }

    public void play() {
        initialize(); //initialisation du jeu
//continu jusqu'a ce que le jeu soit fini
        //boucle d'avancement qui exécute les check, scores finaux, les gaganats ou s'il y a une égalité
        while (!isGameOver()) {
            for (Player player : players) {
                player.takeTurn(board);
                if (isGameOver()) {
                    displayFinalScores();
                    return;
                }
            }
        }
    }


//check si le jeu est bien fini
    public boolean isGameOver() {
        return deck.isEmpty() || exposedCards.isEmpty();
    }

    public void displayFinalScores() {
        List<Player> winners = determineWinners();

        System.out.println("Final scores:");
        for (Player player : players) {
            System.out.println(player.getName() + " - Score: " + player.getTotalScore());
        }

        if (winners.size() == 1) {
            System.out.println("Winner: " + winners.get(0).getName());
        } else {
            System.out.println("It's a tie between:");
            for (Player winner : winners) {
                System.out.println(winner.getName());
            }
        }
    }

    private List<Player> determineWinners() {
        List<Player> winners = new ArrayList<>();
        int highestScore = -1;

        for (Player player : players) {
            if (player.getTotalScore() > highestScore) {
                highestScore = player.getTotalScore();
                winners.clear();
                winners.add(player);
            } else if (player.getTotalScore() == highestScore) {
                winners.add(player);
            }
        }

        return winners;
    }

}