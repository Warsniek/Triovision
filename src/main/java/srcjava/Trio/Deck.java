package srcjava.Trio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    private List<Card> cards;
    private Stack<Card> drawPile;

    public Deck() {
        cards = new ArrayList<>(); //list de cartes qu'il y a dans le dsck
        drawPile = new Stack<>(); //pile de carte a sortir

        // Possibilité d'ajouter des cartes en ajoutant des layout
        String[][] layout1 = {{"X", "J"}, {"X", "V"}, {"B", "X"}};
        String[][] layout2 = {{"X", "V"}, {"X", "R"}, {"J", "X"}};

        cards.add(new Card(layout1));
        cards.add(new Card(layout2));

        fillDrawPile(); //rempli la pioche
    }


    //possibilité de poiocher une carte si pas de solution
    public Card drawCard() {
        if (!drawPile.isEmpty()) {
            return drawPile.pop();
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    } //melange les cartes

    public void fillDrawPile() {
        shuffle();
        for (Card card : cards) {
            drawPile.push(card);
        }
    }

    public boolean isEmpty() {
        return drawPile.isEmpty();
    } //check si la pile est tjrs remplie

}
