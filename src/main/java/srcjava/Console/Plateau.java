package srcjava.Console;

public class Plateau {
    private Pions.Couleur[] cases;   //cases uniquement dans plateau

    public Plateau() {
        cases = new Pions.Couleur[8];
    }

    // Mettre un pion sur une case du plateau
    public void placerPion(int position, Pions.Couleur couleur) {
        if (position >= 1 && position <= 8) {
            cases[position - 1] = couleur;
        } else {
            System.out.println("Position invalide.");
        }
    }


    // Vérifier si une case du plateau est vide
    public boolean estCaseVide(int position) {
        if (position >= 1 && position <= 8) {
            return cases[position - 1] == null;
        } else {
            System.out.println("Position invalide.");
            return false;
        }
    }

    // Afficher l'état du plateau
    public void afficherPlateau() {
        System.out.println("Plateau de jeu :");
        for (int i = 0; i < cases.length; i++) {
            System.out.println("Case " + (i + 1) + ": " + (cases[i] != null ? cases[i] : "Vide"));
        }
        System.out.println();
    }

    // Obtenir une copie des pions sur le plateau pour le game
    public Pions.Couleur[] getPionsSurPlateau() {
        return cases.clone();
    }

}
