package srcjava.Console;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Pions {
    //couleur
    public enum Couleur{
        ROUGE,
        BLEU,
        VERT,
        JAUNE
    }
    private List<Couleur> pions;

    public Pions() {
        pions = new ArrayList<>();
        initialiserPions();
    }

    // Initialiser les pions
    private void initialiserPions() {
        for (int i = 0; i < 2; i++) {
            pions.add(Couleur.ROUGE);
            pions.add(Couleur.BLEU);
            pions.add(Couleur.VERT);
            pions.add(Couleur.JAUNE);
        }
    }

}
