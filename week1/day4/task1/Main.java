package week1.day4.task1;
import week1.day4.task1.mammals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Object> items = new ArrayList<Object>();
        List<String> animalsFly = new ArrayList<String>();
        List<String> animalsHerbivorous = new ArrayList<String>();
        while(true){
            System.out.println("Choose One of the animals \n 1. Dog \n 2. Cow \n 3. Bat \n 4. Parrot \n 5. Ostrich");
            int choice = in.nextInt();
            if(choice == 1){
                Dogs dog = new Dogs();
                System.out.println("Dogs have locomotion as "+ dog.modeOfLoco());
                items.add(dog);
                if(dog.isHerbivorous()){
                    animalsHerbivorous.add("Dog");
                }
                if(dog.modeOfLoco() == "fly"){
                    animalsFly.add("Dog");
                }
            }
            else if(choice == 2){
                Cow cow = new Cow();
                System.out.println("Cows have locomotion as "+ cow.modeOfLoco());
                items.add(cow);
                if(cow.isHerbivorous()){
                    animalsHerbivorous.add("Cow");
                }
                if(cow.modeOfLoco() == "fly"){
                    animalsFly.add("Cow");
                }
            }
            else if(choice == 3){
                Bat bat = new Bat();
                System.out.println("Cows have locomotion as "+ cow.modeOfLoco());
                items.add(bat);
                if(cow.isHerbivorous()){
                    animalsHerbivorous.add("Dogs");
                }
                if(cow.modeOfLoco() == "fly"){
                    animalsFly.add("Cow");
                }
            }
            else if(choice == 4){
                Cow cow = new Cow();
                System.out.println("Cows have locomotion as "+ cow.modeOfLoco());
                items.add(cow);
                if(cow.isHerbivorous()){
                    animalsHerbivorous.add("Dogs");
                }
                if(cow.modeOfLoco() == "fly"){
                    animalsFly.add("Cow");
                }
            }
        }
    }
}
