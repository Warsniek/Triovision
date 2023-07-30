package srcjava.Console;

public class Cartes {
    private String nom;
    private Pions.Couleur premierPion;
    private Pions.Couleur deuxiemePion;
    private Pions.Couleur troisiemePion;

    public Cartes (String nom, Pions.Couleur premierPion, Pions.Couleur deuxiemePion, Pions.Couleur troisiemePion) {
        this.nom = nom;
        this.premierPion = premierPion;
        this.deuxiemePion = deuxiemePion;
        this.troisiemePion = troisiemePion;
    }

    // Vérifier si la carte peut être gagnée en reproduisant sa disposition de pions sur le plateau
    public boolean estGagnante(Pions.Couleur[] plateau) {
        int premierPionPosition = trouverPositionPion(plateau, premierPion);
        int deuxiemePionPosition = trouverPositionPion(plateau, deuxiemePion);
        int troisiemePionPosition = trouverPositionPion(plateau, troisiemePion);

        // Vérifier si les pions sont disposés dans l'ordre indiqué par la carte
        return (premierPionPosition != -1 && deuxiemePionPosition != -1 && troisiemePionPosition != -1)
                && (premierPionPosition < deuxiemePionPosition && deuxiemePionPosition < troisiemePionPosition);
    }

    // Trouver la position d'un pion sur le plateau
    private int trouverPositionPion(Pions.Couleur[] plateau, Pions.Couleur couleurPion) {
        for (int i = 0; i < plateau.length; i++) {
            if (plateau[i] == couleurPion) {
                return i;
            }
        }
        return -1; // Retourne -1 si le pion n'est pas trouvé sur le plateau
    }

    // Obtenir le nom de la carte
    public String getNom() {
        return nom;
    }

    // Obtenir la première couleur de pion sur la carte
    public Pions.Couleur getPremierPion() {
        return premierPion;
    }

    // Obtenir la deuxième couleur de pion sur la carte
    public Pions.Couleur getDeuxiemePion() {
        return deuxiemePion;
    }

    // Obtenir la troisième couleur de pion sur la carte
    public Pions.Couleur getTroisiemePion() {
        return troisiemePion;
    }
}
