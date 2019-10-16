package week1.day3;

import java.util.Scanner;

public class Animal {
    String animalName;
    String animalColour;
    int animalLegs;
    public Animal(String name){
        this.animalName = name;
    }
    public void colour(String col){
        this.animalColour = col;
        System.out.println(this.animalName+ " is " + this.animalColour+" in colour!");
    }
    public void noOfLegs(int num){
        this.animalLegs = num;
        System.out.println(this.animalName+ " has "+ this.animalLegs +" legs!");
    }

    public static void main(String[] args) {
        int animalCount=1;
        Scanner inp = new Scanner(System.in);
        while(true){
            String name = inp.next();
            String colour = inp.next();
            int legs = inp.nextInt();
            Animal animals = new Animal(name);
            animals.colour(colour);
            animals.noOfLegs(legs);
            System.out.println(animalCount++);
        }
    }
}

