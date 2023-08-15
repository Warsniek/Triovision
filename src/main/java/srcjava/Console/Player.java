package srcjava/Console;

import java.util.Scanner;

public class Player {
    private String name;
    private String color;
    private int score;

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
    }

    public void takeTurn(Board board) {
        board.displayBoard();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter column: ");
        int col = scanner.nextInt();

        if (board.isValidMove(row, col, this)) {
            board.makeMove(row, col, this);
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public int getTotalScore() {
        return score;
    }

}
