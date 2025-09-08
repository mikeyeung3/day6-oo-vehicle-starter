package com.afs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarTest {
    // Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    void should_return_parking_ticket_when_park_given_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        assertNotNull(parkingTicket);
    }
    //  Case 2 - Given a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_and_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(parkingTicket);
        assertNotNull(fetchedCar);
    }
    //  Case 3 - Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    //  Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    //  Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    //  Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
}
