package src;

public class Car implements src.Vehicle {
    @Override
    public void run() {
        System.out.println("Car is running");
    }

    @Override
    public void stop() {
        System.out.println("Car Engine is stopped");
    }

    @Override
    public void brake() {
        System.out.println("Car is idle");
    }
}
