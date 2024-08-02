package ParkingLot;

import java.util.ArrayList;

public class Level {
    private final ArrayList<ParkingSpot> parkingSpots;

    public Level() {
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public boolean checkParkingSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isValidSpot(vehicle)) return true;
        }
        return false;
    }

    public void parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isValidSpot(vehicle)) {
                parkingSpot.parkSpot(vehicle);
                return;
            }
        }
    }

    public void unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isBookedSpot(vehicle)) {
                parkingSpot.unParkSpot();
            }
        }
    }

    @Override
    public String toString() {
        return parkingSpots.stream().map(ParkingSpot::toString)
                .reduce((s1, s2) -> s1 + "," + s2)
                .orElse("");
    }
}
