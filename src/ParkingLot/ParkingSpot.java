package ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private final VehicleType type;

    public ParkingSpot(VehicleType type) {
        this.vehicle = null;
        this.type = type;
    }

    public boolean isBookedSpot(Vehicle vehicle) {
        return this.vehicle == vehicle;
    }

    public boolean isValidSpot(Vehicle vehicle) {
        return this.vehicle == null && vehicle.type() == this.type;
    }

    public void parkSpot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unParkSpot() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public String toString() {
        return (vehicle == null ? "Empty" : vehicle) + " Type : " + type;
    }
}
