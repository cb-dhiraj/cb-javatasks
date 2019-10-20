package src;

public class Truck implements src.Vehicle {
    @Override
    public void run() {
        System.out.println("Truck is running");
    }

    @Override
    public void stop() {
        System.out.println("Truck Engine is stopped");
    }

    @Override
    public void brake() {
        System.out.println("Truck is idle");
    }
}
