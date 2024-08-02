package ParkingLot;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Level> levels;

    public ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }

    public Level getLevel(int index) {
        return this.levels.get(index);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level level:levels) {
            if(level.checkParkingSpot(vehicle)) {
                level.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for(Level level:levels) {
            if(level.checkParkingSpot(vehicle)) {
                level.unParkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void printParkingLot() {
        for(Level level: levels) {
            System.out.println("Level");
            System.out.println(level.toString());
        }
    }

}