package ParkingLot;

import java.util.Scanner;

public class ParkingSystem {

    private void parkVehicle(ParkingLot parkingLot,Scanner sc) {
        VehicleType vehicleType = getVehicleType(sc);
        System.out.print("Enter Vehicle Number Plate: ");
        String numberPlate = sc.next();
        boolean isParked = parkingLot.parkVehicle(new Vehicle(numberPlate, vehicleType));
        System.out.println(isParked ? "Vehicle Parked" : "Vehicle Not Parked");
    }

    private void unParkVehicle(ParkingLot parkingLot,Scanner sc) {
        VehicleType vehicleType = getVehicleType(sc);
        System.out.print("Enter Vehicle Number Plate: ");
        String numberPlate = sc.next();
        boolean isUnparked = parkingLot.unParkVehicle(new Vehicle(numberPlate, vehicleType));
        System.out.println(isUnparked ? "Vehicle UnParked" : "Vehicle Not UnParked");
    }

    private VehicleType getVehicleType(Scanner sc) {
        System.out.print("Enter Vehicle Type: ");
        try {
            return VehicleType.valueOf(sc.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid vehicle type entered. Defaulting to CAR.");
            return VehicleType.CAR;
        }
    }

    public void init() {
        ParkingLot parkingLot = new ParkingLot();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Levels : ");
        int level = sc.nextInt();
        for (int i = 0; i < level; i++) {
            parkingLot.addLevel(new Level());
        }

        int curr = 0;
        while (curr < level) {
            System.out.print("Enter number of parking spots at Level " + curr + " : ");
            int spots = sc.nextInt();
            Level currLevel = parkingLot.getLevel(curr);
            for (int spot = 0; spot < spots; spot++) {
                System.out.print("Enter Vehicle Type for Spot - " + spot + " (CAR, MOTORCYCLE, TRUCK): ");
                VehicleType vehicleType = getVehicleType(sc);
                currLevel.addParkingSpot(new ParkingSpot(vehicleType));
            }
            curr++;
        }

        boolean finish = false;

        while (!finish) {
            System.out.println("""
            Select Option :
            1. Park Vehicle
            2. UnPark Vehicle
            3. Print Parking Lot
            4. End
            """);
            int input = sc.nextInt();
            switch (input) {
                case 1 -> parkVehicle(parkingLot,sc);
                case 2 -> unParkVehicle(parkingLot,sc);
                case 3 -> parkingLot.printParkingLot();
                case 4 -> finish = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

/*
Requirements :
ParkingLot -> Levels -> ParkingSpots -> Vehicle(cars, motorcycles, and trucks)
*/
