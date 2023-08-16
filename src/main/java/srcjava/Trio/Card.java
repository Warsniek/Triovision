package srcjava.Trio;

public class Card {
    private String[][] layout; //matrice de la carte

    public Card(String[][] layout) {
        this.layout = layout;
    }

    public String[][] getLayout() {
        return layout;
    } //permet de recuperer la postion de la carte et renvoie sa position


    //genere des cartes a la suite
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                sb.append(layout[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString(); //renvoie la chaine generée
    }
}

