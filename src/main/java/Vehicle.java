public class Vehicle {
    private final String name;
    private Integer speed;
    private Integer acceleration;

    public Vehicle(String name, Integer speed, Integer acceleration) {
        this.name = name;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    public void speedUp(){
        speed += acceleration;
        System.out.println(String.format("%s: speed up to %d km/h", name, speed));
    }

}
