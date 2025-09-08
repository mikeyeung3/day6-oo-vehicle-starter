package com.afs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final Integer id;
    private final HashMap<ParkingTicket, Car> parkingMap = new HashMap<>();
    private final Set<Car> cars = new HashSet<>();
    private static final Integer capacity = 10;

    public ParkingLot(int id) {
        this.id = id;
    }

    public ParkingTicket park(Car car) {
        if (cars.contains(car) || cars.size() >= capacity) {
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket(car, cars.size() + 1, this);
        parkingMap.put(parkingTicket, car);
        cars.add(car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingMap.containsKey(parkingTicket)) {
            Car car = parkingMap.get(parkingTicket);
            parkingMap.remove(parkingTicket);
            cars.remove(car);
            return car;
        }
        return null;
    }
}
