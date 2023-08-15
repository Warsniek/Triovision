package srcjava.Console;

public class Card {
    private String[][] layout;

    public Card(String[][] layout) {
        this.layout = layout;
    }

    public String[][] getLayout() {
        return layout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                sb.append(layout[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

