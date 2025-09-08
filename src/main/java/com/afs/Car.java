package com.afs;

public class Car {
    final String licensePlate;
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return licensePlate.equals(car.licensePlate);
    }

    @Override
    public int hashCode() {
        return licensePlate.hashCode();
    }
}
