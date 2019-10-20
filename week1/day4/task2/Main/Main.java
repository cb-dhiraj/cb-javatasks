import java.util.Scanner;
import java.util.*;
class Main{
public static void main(String[] args) {
	Scanner inp = new Scanner(System.in);
	int choice, model=0, horsePower=0, length=0, discount=0;
	String colour="", type="";
	ArrayList<ArrayList<String> > carList = new ArrayList< ArrayList<String>>();
	ArrayList<String> list = new ArrayList<String>();
	while(true){
		System.out.println("Choose one of the car from below options! \n 1. Ford \n 2. Benz \n 3. Audi");
	choice = inp.nextInt();
	if(choice == 1){
		// inp.nextLine();
		list.add("Car: ford");
		System.out.println("Model year: ");
		model = inp.nextInt();
		// inp.nextLine();
		System.out.println("Horse power: ");
		horsePower = inp.nextInt();

		inp.nextLine();
		System.out.println("Colour: ");
		colour = inp.nextLine();

		System.out.println("Type of car: (Sedan or Hatchback): ");
		type = inp.nextLine();

		System.out.println("Length of car in feet ");
		length = inp.nextInt();

		Ford ford = new Ford(colour, model, horsePower);
		discount = ford.getDiscount();
	}
	if(choice == 2){
		list.add("Car: Benz");
		// inp.nextLine();
		System.out.println("Model year: ");
		model = inp.nextInt();
		// inp.nextLine();
		System.out.println("Horse power: ");
		horsePower = inp.nextInt();

		inp.nextLine();
		System.out.println("Colour: ");
		colour = inp.nextLine();

		System.out.println("Type of car: (Sedan or Hatchback): ");
		type = inp.nextLine();

		System.out.println("Length of car in feet ");
		length = inp.nextInt();

		Benz benz = new Benz(colour, model, horsePower);
		discount = benz.getDiscount();
	}
	if(choice == 3){
		list.add("Car: Audi");
		// inp.nextLine();
		System.out.println("Model year: ");
		model = inp.nextInt();
		// inp.nextLine();
		System.out.println("Horse power: ");
		horsePower = inp.nextInt();

		inp.nextLine();
		System.out.println("Colour: ");
		colour = inp.nextLine();

		System.out.println("Type of car: (Sedan or Hatchback): ");
		type = inp.nextLine();

		System.out.println("Length of car in feet ");
		length = inp.nextInt();

		Audi audi = new Audi(colour, model, horsePower);
		discount = audi.getDiscount();
	}
	list.add("Model: " + Integer.toString(model));
	list.add("Horse power: " + Integer.toString(horsePower));
	list.add("Colour: " + colour);
	list.add("Car type: " + type);
	list.add("Length: " + Integer.toString(length));
	Types types = new Types(type, length);
	discount = discount + types.getDiscount();
	System.out.println("Discount amount is: "+  discount);
	list.add("Discount: " + Integer.toString(discount));
	carList.add(list);
System.out.println(carList);
	}
}
}