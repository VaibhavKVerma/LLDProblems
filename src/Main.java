import ParkingLot.ParkingSystem;
import TicTacToe.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();

        ParkingSystem parkingSystem = new ParkingSystem();
        parkingSystem.init();
    }
}