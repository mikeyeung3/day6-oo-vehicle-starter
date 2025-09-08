package com.afs;

import java.util.List;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        System.out.print("No available position.");
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.equals(parkingTicket.parkingLot())) {
                return parkingLot.fetch(parkingTicket);
            }
        }
        System.out.print("Unrecognized parking ticket.");
        return null;
    }
}
