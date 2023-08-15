package srcjava.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    private List<Card> cards;
    private Stack<Card> drawPile;

    public Deck() {
        cards = new ArrayList<>();
        drawPile = new Stack<>();

        // Possibilité d'ajouter des cartes en ajoutant des layout
        String[][] layout1 = {{"X", "J"}, {"X", "V"}, {"B", "X"}};
        String[][] layout2 = {{"X", "V"}, {"X", "R"}, {"J", "X"}};

        cards.add(new Card(layout1));
        cards.add(new Card(layout2));

        fillDrawPile();
    }

    public Card drawCard() {
        if (!drawPile.isEmpty()) {
            return drawPile.pop();
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void fillDrawPile() {
        shuffle();
        for (Card card : cards) {
            drawPile.push(card);
        }
    }

    public boolean isEmpty() {
        return drawPile.isEmpty();
    }

}
