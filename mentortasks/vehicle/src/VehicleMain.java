package src;

import java.util.Scanner;

public class VehicleMain {


    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int startChoice;
        while(true){
            System.out.println("Start 1. Car \n2. Bike \n3. Truck");
            startChoice = inp.nextInt();
            inp.nextLine();
            if(startChoice == 1){
                Vehicle car = new  Car();
                VehicleRun.vehicleMotion(car);
            }
            else if(startChoice == 2){
                Vehicle bike = new Bike();
                VehicleRun.vehicleMotion(bike);
            }
            else if(startChoice == 3){
                Vehicle truck = new Truck();
                VehicleRun.vehicleMotion(truck);
            }
        }
    }
}
