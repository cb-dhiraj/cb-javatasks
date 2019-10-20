import java.util.*;

class Main{

	public static void printDetails(Map<Integer, Map<String, String>> map, String searchItem, String searchWord){
		map.forEach((key, value) -> {
			if(value.get(searchItem).equals(searchWord)){
				System.out.println(map.get(key));
			}
		});
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Boolean exit = true;
		int choice, viewChoice, i=0;
		String name, phone, work, home, address, searchWord;
		Map<Integer, Map<String, String>> map = new HashMap<Integer, Map<String, String>>();
		Map<String, String> mapValues = new HashMap<String, String>();
		while(exit){
			System.out.println("1. Phone directory \n2. Add Details \n3. Exit");
			choice = inp.nextInt();
			inp.nextLine();
			if(choice == 1){
				System.out.println("1. Search by name (or) \n2. phone number \n3. work number \n4. home number ");
				viewChoice = inp.nextInt();
				inp.nextLine();
				if(viewChoice == 1){
					System.out.println("Name to be searched: ");
					searchWord = inp.nextLine();
					printDetails(map, "name", searchWord);
				}
				else if(viewChoice == 2){
					System.out.println("Phone number to be searched: ");
					searchWord = inp.nextLine();
					printDetails(map, "phone", searchWord);
				}
				else if(viewChoice == 3){
					System.out.println("Work number to be searched: ");
					searchWord = inp.nextLine();
					printDetails(map, "work", searchWord);
				}
				else if(viewChoice == 4){
					System.out.println("Home number to be searched: ");
					searchWord = inp.nextLine();
					printDetails(map, "home", searchWord);
				}

			}
			else if(choice == 2){
				System.out.println("Name: ");
				name = inp.nextLine();
				System.out.println("Phone number: ");
				phone = inp.nextLine();
				System.out.println("work number: ");
				work = inp.nextLine();
				System.out.println("home number: ");
				home = inp.nextLine();
				System.out.println("address: ");
				address = inp.nextLine();
				mapValues.put("name", name);
				mapValues.put("address", address);
				mapValues.put("phone", phone);
				mapValues.put("work", work);
				mapValues.put("home", home);
				map.put(i, mapValues);
				i++;
			}
			else{
				exit = false;
			}
		}
	}
}