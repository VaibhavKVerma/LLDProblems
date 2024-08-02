package ParkingLot;

public record Vehicle(String numberPlate, VehicleType type) {
    @Override
    public String toString() {
        return "Vehicle : " + numberPlate;
    }
}
