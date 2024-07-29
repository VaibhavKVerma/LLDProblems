package TicTacToe;

import Utils.Pair;

public class Board {
    private final int size;
    private int moves;
    private final char[][] board;

    public Board(int size) {
        this.size = size;
        this.moves = 0;
        this.board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    public boolean isFull() {
        return moves == size * size;
    }

    public boolean validMove(Pair p) {
        int row = p.row(),col = p.col();
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-';
    }

    public void makeMove(Pair p, char symbol) {
        int row = p.row(),col = p.col();
        if (!validMove(p)) {
            throw new IllegalArgumentException("Invalid move!");
        }
        board[row][col] = symbol;
        moves++;
    }

    public boolean isWinner(Pair p) {
        int row = p.row(),col = p.col();
        char currentSymbol = board[row][col];
        int county = 0, countx = 0, countd1 = 0, countd2 = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][col] == currentSymbol) county++;
            if (board[row][i] == currentSymbol) countx++;
        }
        for (int i = 0; i < size; i++) {
            if (board[i][i] == currentSymbol) countd1++;
        }
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == currentSymbol) countd2++;
        }
        return county == size || countx == size || countd1 == size || countd2 == size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
