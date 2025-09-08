package com.afs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_twice_given_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car("ABC-123");
        Car car2 = new Car("DEF-456");
        ParkingTicket parkingTicket1 = parkingLot.park(car1);
        ParkingTicket parkingTicket2 = parkingLot.park(car2);
        Car fetchedCar1 = parkingLot.fetch(parkingTicket1);
        Car fetchedCar2 = parkingLot.fetch(parkingTicket2);
        assertNotNull(fetchedCar1);
        assertNotNull(fetchedCar2);
    }
    //  Case 4 - Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_wrong_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC-123");
        parkingLot.park(car);
        ParkingTicket wrongTicket = new ParkingTicket(new Car("XYZ-789"), 99, parkingLot);
        Car fetchedCar = parkingLot.fetch(wrongTicket);
        assertNull(fetchedCar);
    }
    //  Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_used_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);
        Car fetchedCarAgain = parkingLot.fetch(parkingTicket);
        assertNull(fetchedCarAgain);
    }
    //  Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
    @Test
    void should_return_nothing_when_park_given_parking_lot_without_any_position_and_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car("CAR-" + i));
        }
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        assertNull(parkingTicket);
    }
}
