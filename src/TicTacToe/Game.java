package TicTacToe;

import Utils.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final ArrayList<Player> players;
    private int turn;
    private final int size;

    public Game(int size) {
        this.players = new ArrayList<>(size - 1);
        this.board = new Board(size);
        this.turn = 0;
        this.size = size;
    }

    private char validSymbol() {
        Scanner scanner = new Scanner(System.in);
        char symbol;
        boolean askAgain = false;
        while (true) {
            System.out.print((askAgain ? "Again" : "") + "Enter symbol: ");
            symbol = scanner.next().charAt(0);
            boolean find = false;
            for (Player player : players) {
                if (player.symbol() == symbol) {
                    find = true;
                    break;
                }
            }
            if (!find) return symbol;
            askAgain = true;
        }
    }

    private void addPlayer() {
        System.out.print("Enter player Name: ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();
        char symbol = validSymbol();
        this.players.add(new Player(playerName, symbol));
    }

    private Pair validIndex() {
        Scanner scanner = new Scanner(System.in);
        boolean askAgain = false;
        while (true) {
            System.out.println((askAgain ? "Again " : "") + "Player number : " + players.get(turn).toString() + " turn. Enter position separated by comma");
            String input = scanner.next();
            String[] temp = input.split(",");
            Pair position = new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            if (temp.length == 2 && board.validMove(position)) {
                return position;
            }
            askAgain = true;
        }
    }

    public void init() {
        while (players.size() < size - 1) {
            addPlayer();
        }
        while (true) {
            if (board.isFull()) {
                System.out.println("Game Draw");
                return;
            }
            Pair indexes = validIndex();
            board.makeMove(indexes, players.get(turn).symbol());
            board.printBoard();
            if (board.isWinner(indexes)) {
                System.out.println("Player " + players.get(turn).name() + " has won.");
                return;
            }
            turn = (turn + 1) % players.size();
        }
    }
}
