package src;

public class Bike implements src.Vehicle {
    @Override
    public void run() {
        System.out.println("Bike is running");
    }

    @Override
    public void stop() {
        System.out.println("Bike Engine is stopped");
    }

    @Override
    public void brake() {
        System.out.println("Bike is idle");
    }
}
