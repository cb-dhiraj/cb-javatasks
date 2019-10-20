package src;

import java.util.Scanner;

public class VehicleRun {
    static void vehicleMotion(Vehicle vehicle){
        Scanner inp = new Scanner(System.in);
        int choice=0;
        boolean stop = false;
        while(!stop){
                vehicle.run();
                System.out.println("1. Stop Engine \n2. Apply Brake");
                choice = inp.nextInt();
                inp.nextLine();
            if(choice == 1){
                vehicle.stop();
                stop = true;
            }
            else if(choice == 2){
                vehicle.brake();
                System.out.println("1. Start Engine \n2. Stop Engine");
                choice = inp.nextInt();
                inp.nextLine();
                if(choice == 2){
                   stop = true;
                }
            }
        }
    }
}
