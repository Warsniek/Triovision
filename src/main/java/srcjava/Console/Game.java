package srcjava.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Pions pions;
    private Plateau plateau;
    private List<Cartes> cartes;

    public Game() {
        pions = new Pions();
        plateau = new Plateau();
        cartes = new ArrayList<>();
        initialiserCartes();
    }

    // Initialiser les cartes du jeu
    private void initialiserCartes() {
        cartes.add(new Cartes("Carte1", Pions.Couleur.BLEU, Pions.Couleur.ROUGE, Pions.Couleur.VERT));
        cartes.add(new Cartes("Carte2", Pions.Couleur.VERT, Pions.Couleur.JAUNE, Pions.Couleur.BLEU));
        cartes.add(new Cartes("Carte3", Pions.Couleur.ROUGE, Pions.Couleur.VERT, Pions.Couleur.JAUNE));
        //plus de carte?
    }

    // Mélanger les cartes
    private void melangerCartes() {
        Collections.shuffle(cartes);
    }

    // Afficher les cartes exposées
    private void afficherCartesExposees() {
        System.out.println("Cartes exposées :");
        for (int i = 0; i < cartes.size(); i++) {
            System.out.println((i + 1) + ". " + cartes.get(i).getNom());
        }
    }

    // Jouer une partie
    public void jouerPartie() {
        System.out.println("Bienvenue dans Triovision !");
        Scanner scanner = new Scanner(System.in);

        int tourActuel = 1;

        while (tourActuel <= NOMBRE_DE_TOURS) {
            melangerCartes();
            afficherCartesExposees();

            System.out.print("Entrez le numéro de la carte que vous souhaitez reproduire : ");
            int numeroCarte = scanner.nextInt();

            if (numeroCarte >= 1 && numeroCarte <= cartes.size()) {
                Carte carteEnCours = cartes.get(numeroCarte - 1);
                System.out.println("Carte en cours : " + carteEnCours.getNom());

                // Afficher le plateau initial avant le déplacement des pions
                plateau.afficherPlateau();

                System.out.print("Entrez la position du pion à déplacer : ");
                int positionDepart = scanner.nextInt();
                System.out.print("Entrez la nouvelle position du pion : ");
                int positionArrivee = scanner.nextInt();

                plateau.placerPion(positionArrivee, plateau.getPionsSurPlateau()[positionDepart - 1]);

                if (carteEnCours.estGagnante(plateau.getPionsSurPlateau())) {
                    System.out.println("Bravo ! Vous avez gagné la carte " + carteEnCours.getNom() + ".");
                    cartes.remove(carteEnCours);
                } else {
                    System.out.println("Désolé, la carte n'a pas été reproduite correctement.");
                    // Remettre le pion à sa position d'origine
                    plateau.placerPion(positionDepart, plateau.getPionsSurPlateau()[positionArrivee - 1]);
                }


                // Afficher le plateau initial avant le déplacement des pions
                plateau.afficherPlateau();

                System.out.print("Entrez la position du pion à déplacer : ");
                int positionDepart = scanner.nextInt();
                System.out.print("Entrez la nouvelle position du pion : ");
                int positionArrivee = scanner.nextInt();

                plateau.placerPion(positionArrivee, plateau.getPionsSurPlateau()[positionDepart - 1]);

                if (carteEnCours.estGagnante(plateau.getPionsSurPlateau())) {
                    System.out.println("Bravo ! Vous avez gagné la carte " + carteEnCours.getNom() + ".");
                    cartes.remove(carteEnCours);
                } else {
                    System.out.println("Désolé, la carte n'a pas été reproduite correctement.");
                    // Remettre le pion à sa position d'origine
                    plateau.placerPion(positionDepart, plateau.getPionsSurPlateau()[positionArrivee - 1]);
                }

                // Afficher le plateau après le déplacement des pions
                plateau.afficherPlateau();
            } else {
                System.out.println("Numéro de carte invalide.");
            }

            System.out.println();
        }

        System.out.println("Fin de la partie !");
        System.out.println("Vous avez gagné " + (cartes.size() == 0 ? "toutes les cartes !" : cartes.size() + " carte(s)."));
    }

    public static void main(String[] args) {
        Game jeu = new Game();
        jeu.jouerPartie();
    }
}
