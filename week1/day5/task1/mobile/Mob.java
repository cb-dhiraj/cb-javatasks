import java.util.*;
interface MobileInterface{
	int remainingCharge();
	String name();
}
public class Mob{
	int charge;
	String name;
	public static void main(String[] args)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner inp = new Scanner(System.in);
		Mob mob = new Mob();
		MobileInterface mobile = new MobileInterface(){
			@Override
			public int remainingCharge(){
				System.out.println("Charge: ");
				mob.charge = inp.nextInt();
				return mob.charge;
			}
			@Override
			public String name(){
				System.out.println("Name: ");
				mob.name = inp.nextLine();
				return mob.name;
			}
		};
		while(true)
		{
			String name = mobile.name();
			int charge = mobile.remainingCharge();
			inp.nextLine();
			map.put(name, charge);
		}
	}
}