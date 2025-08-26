public class Main {
    public static void main(String[] args) {
        GasolineEngine gasolineEngine = new GasolineEngine();
        Car gasolineCar = new Car("Cool Car with gasoline engine", 25, gasolineEngine);
        Driver gasolineCarDriver = new Driver(gasolineCar);
        gasolineCarDriver.drive();

        ElectricEngine electricEngine = new ElectricEngine();
        Car electricCar = new Car("Cool Car with electric engine", 25, electricEngine);
        Driver electricCarDriver = new Driver(electricCar);
        electricCarDriver.drive();

        Truck truck = new Truck("Big Truck", 20, 2);
        Driver truckDriver = new Driver(truck);
        truckDriver.drive();
    }
}
