public class Car extends Vehicle {
    private Engine engine;

    public Car(String name, Integer speed, Engine engine) {
        super(name, speed, engine.getAccelerate());
        this.engine = engine;
    }
}
