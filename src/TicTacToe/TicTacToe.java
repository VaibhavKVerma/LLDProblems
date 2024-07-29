package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the grid : ");
        int size = sc.nextInt();
        Game game = new Game(size);
        game.init();
    }
}
