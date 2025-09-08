package com.afs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new java.io.PrintStream(outputStream));
    }

    // Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.
    @Test
    void should_return_parking_ticket_when_park_given_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        assertNotNull(parkingTicket);
    }
    //  Case 2 - Given a parking lot with a parked car, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_and_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(parkingTicket);
        assertNotNull(fetchedCar);
    }
    //  Case 3 - Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_twice_given_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        ParkingLot parkingLot = new ParkingLot(10);
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
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        parkingLot.park(car);
        ParkingTicket wrongTicket = new ParkingTicket(new Car("XYZ-789"), 99, parkingLot);
        Car fetchedCar = parkingLot.fetch(wrongTicket);
        assertNull(fetchedCar);
    }
    //  Case 5 - Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing.
    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_used_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);
        Car fetchedCarAgain = parkingLot.fetch(parkingTicket);
        assertNull(fetchedCarAgain);
    }
    //  Case 6 - Given a parking lot without any position, and a car, When park the car, Then return nothing
    @Test
    void should_return_nothing_when_park_given_parking_lot_without_any_position_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car("CAR-" + i));
        }
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        assertNull(parkingTicket);
    }

    // Story 2
    // Case 1 - Given a parking lot, and an unrecognized ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_nothing_with_error_message_when_fetch_given_parking_lot_and_unrecognized_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        parkingLot.park(car);
        ParkingTicket unrecognizedTicket = new ParkingTicket(new Car("XYZ-789"), 99, parkingLot);
        Car fetchedCar = parkingLot.fetch(unrecognizedTicket);
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", outputStream.toString());
    }
    // Case 2 - Given a parking lot, and a used ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_nothing_with_error_message_when_fetch_given_parking_lot_and_used_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);
        Car fetchedCarAgain = parkingLot.fetch(parkingTicket);
        assertNull(fetchedCarAgain);
        assertEquals("Unrecognized parking ticket.", outputStream.toString());
    }
    // Case 3 - Given a parking lot without any position, and a car, When park the car, Then return nothing with error message "No available position."
    @Test
    void should_return_nothing_with_error_message_when_park_given_parking_lot_without_any_position_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car("CAR-" + i));
        }
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingLot.park(car);
        assertNull(parkingTicket);
        assertEquals("No available position.", outputStream.toString());
    }

    // Story 3
    // Case 1 - Given a parking lot, a standard parking boy, and a car, When park the car, Then return a parking ticket.
    @Test
    void should_return_parking_ticket_when_park_given_parking_lot_standard_parking_boy_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        Car car = new Car("ABC-123");
        assertNotNull(parkingBoy.park(car));
    }
    // Case 2 - Given a parking lot with a parked car, a standard parking boy, and a parking ticket, When fetch the car, Then return the parked car.
    @Test
    void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_standard_parking_boy_and_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingBoy.park(car);
        assertNotNull(parkingBoy.fetch(parkingTicket));
    }

    // Case 3 - Given a parking lot with two parked cars, a standard parking boy, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_twice_given_parking_lot_with_two_parked_cars_standard_parking_soy_and_two_parking_tickets() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        Car car1 = new Car("ABC-123");
        Car car2 = new Car("DEF-456");
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        assertEquals(car1, parkingBoy.fetch(parkingTicket1));
        assertEquals(car2, parkingBoy.fetch(parkingTicket2));
    }
    // Case 4 - Given a parking lot, a standard parking boy, and a wrong parking ticket, When fetch the car. Then return nothing with error message "Unrecognized parking ticket.”
    @Test
    void should_return_nothing_with_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_wrong_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        Car car = new Car("ABC-123");
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket(new Car("XYZ-789"), 99, parkingLot);
        Car fetchedCar = parkingBoy.fetch(wrongTicket);
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", outputStream.toString());
    }
    // Case 5 - Given a parking lot, a standard parking boy, and a used parking ticket, When fetch the car. Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_nothing_with_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_used_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);
        Car fetchedCarAgain = parkingBoy.fetch(parkingTicket);
        assertNull(fetchedCarAgain);
        assertEquals("Unrecognized parking ticket.", outputStream.toString());
    }
    // Case 6 - Given a parking lot without any position, a standard parking boy, and a car, When park the car, Then return nothing with error message "No available position."
    @Test
    void should_return_nothing_with_error_message_when_park_given_parking_lot_without_any_position_standard_parking_boy_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot)));
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car("CAR-" + i));
        }
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingBoy.park(car);
        assertNull(parkingTicket);
        assertEquals("No available position.", outputStream.toString());
    }

    // Story
    // Case 1 - Given a standard parking boy, who manage two parking lots, both with available position, and a car, When park the car, Then the car will be parked to the first parking lot
    @Test
    void should_park_to_first_parking_lot_when_park_given_standard_parking_boy_manage_two_parking_lots_both_with_available_position_and_car() {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ArrayList<>(List.of(parkingLot1, parkingLot2)));
        Car car = new Car("ABC-123");
        ParkingTicket parkingTicket = parkingBoy.park(car);
        assertNotNull(parkingTicket);
        assertEquals(parkingLot1, parkingTicket.parkingLot());
    }
    // Case 2 - Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car, When park the car, Then the car will be parked to the second parking lot
//Case 3 - Given a standard parking boy, who manage two parking lots, both with a parked car, and two parking ticket, When fetch the car twice, Then return the right car with each ticket
//Case 4 - Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.”
//Case 5 - Given a standard parking boy, who manage two parking lots, and a used ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."
//Case 6 - Given a standard parking boy, who manage two parking lots, both without any position, and a car, When park the car, Then return nothing with error message "No available position."

}
