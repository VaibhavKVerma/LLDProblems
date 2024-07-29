package TicTacToe;

public record Player(String name, Character symbol) {
    @Override
    public String toString() {
        return this.name + " turn to move";
    }
}
