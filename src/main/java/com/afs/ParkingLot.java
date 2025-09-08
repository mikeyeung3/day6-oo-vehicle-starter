package com.afs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ParkingLot {
    private final HashMap<ParkingTicket, Car> parkingMap = new HashMap<>();
    private final Set<Car> cars = new HashSet<>();
    private final Set<Integer> occupiedPositions = new HashSet<>();
    private final Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (cars.contains(car)) return null;

        if (cars.size() >= capacity) {
            System.out.print("No available position.");
            return null;
        }
        Integer position = findNextAvailablePosition();

        ParkingTicket parkingTicket = new ParkingTicket(car, position, this);
        parkingMap.put(parkingTicket, car);
        cars.add(car);
        occupiedPositions.add(position);
        return parkingTicket;
    }

    private Integer findNextAvailablePosition() {
        return IntStream.rangeClosed(1, capacity)
                .filter(i -> !occupiedPositions.contains(i))
                .boxed()
                .findFirst()
                .orElse(null);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingMap.containsKey(parkingTicket)) {
            Car car = parkingMap.get(parkingTicket);
            parkingMap.remove(parkingTicket);
            cars.remove(car);
            occupiedPositions.remove(parkingTicket.position());
            return car;
        }
        System.out.print("Unrecognized parking ticket.");
        return null;
    }
}