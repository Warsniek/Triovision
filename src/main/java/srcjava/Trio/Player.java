package srcjava.Trio;

import java.util.Scanner;

public class Player {
    private String name; //nom
    private String color;//couleur
    private int score;//score
//constructeur
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    } //incremente le scorz

    public void takeTurn(Board board) { //tour du joueur
        board.displayBoard();//affiche board

        Scanner scanner = new Scanner(System.in);
//demande au joueur la rangée et la coonne
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter column: ");
        int col = scanner.nextInt();
//verification du moov
        if (board.isValidMove(row, col, this)) {
            board.makeMove(row, col, this);
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public int getTotalScore() {
        return score;
    } //renvoie le score total

}
