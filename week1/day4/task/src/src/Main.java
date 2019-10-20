package src;
import src.birds.*;
import src.mammals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List <Object> items = new ArrayList<Object>();
    static List<String> animalsFly = new ArrayList<String>();
    static List<String> animalsHerbivorous = new ArrayList<String>();

    static void mammalsPrint(Mammals obj, String animal){
        System.out.println(animal +" have locomotion as "+ obj.modeOfLoco());
        items.add(obj);
        if(obj.isHerbivorous()){
            animalsHerbivorous.add(animal);
            System.out.println(animal+" is Herbivorous");
        }
        else{ System.out.println(animal+" is not Herbivorous"); }
        if(obj.modeOfLoco() == "air"){
            animalsFly.add(animal);
            System.out.println(animal + " can fly");
        }
        else{ System.out.println(animal+" can't fly"); }
        obj.hasMammaryGlands();
    }

    static void mammalsPrint(Birds obj, String animal){
        System.out.println(animal +" have locomotion as "+ obj.modeOfLoco());
        items.add(obj);
        if(obj.isHerbivorous()){
            animalsHerbivorous.add(animal);
            System.out.println(animal+" is Herbivorous");
        }
        else{ System.out.println(animal+" is not Herbivorous"); }
        if(obj.modeOfLoco() == "air"){
            animalsFly.add(animal);
            System.out.println(animal + " can fly");
        }
        else{ System.out.println(animal+" can't fly"); }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String animal;
        while(true){
            System.out.println("Choose One of the animals \n 1. Dog \n 2. Cow \n 3. Bat \n 4. Parrot \n 5. Ostrich");
            int choice = in.nextInt();

            if(choice == 1 || choice == 2 || choice == 3){
                if(choice == 1){
                    Mammals obj = new Dogs();
                    animal = "Dog";
                    mammalsPrint(obj, animal);
                }
                else if(choice == 2){
                    Mammals obj = new Cow();
                    animal = "Cow";
                    mammalsPrint(obj, animal);
                }
                else if(choice == 3){
                    Mammals obj = new Bats();
                    animal = "Bat";
                    mammalsPrint(obj, animal);
                }
            }
            else if(choice == 4 || choice == 5){
                if(choice == 4){
                    Birds obj = new Parrot();
                    animal = "Parrot";
                    mammalsPrint(obj, animal);
                }
                else if(choice == 5){
                    Birds obj = new Ostrich();
                    animal = "Ostrich";
                    mammalsPrint(obj, animal);
                }
            }
            System.out.println(animalsFly);
        }
    }
}
