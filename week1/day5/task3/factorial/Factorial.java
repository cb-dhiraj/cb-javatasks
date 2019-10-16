import java.util.*;

class Factorial implements Iterable<Integer>
{
	int lowerLimit=0, upperLimit=0, number=0;

	Factorial(int lowerLimit, int upperLimit){
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.number = lowerLimit;
	}
	
	class IteratorClass implements Iterator<Integer>{
		int lowerLimit, upperLimit, number;
		public IteratorClass(Factorial factorial)
		{
			this.lowerLimit = factorial.lowerLimit;
			this.number = factorial.number;
			this.upperLimit = factorial.upperLimit;
		}

		public boolean hasNext()
		{
			if(this.number <= this.upperLimit){
				return true;
			}
			return false;
		}

		public Integer next()
		{
			this.number += 1;
			return this.number-1;
		}
	}

	public Iterator<Integer> iterator()
	{
		return new Factorial.IteratorClass(this);
	}

	public String toString(ArrayList<Integer> list)
	{
		String strResult="";
		for(int i=0; i<list.size(); i++){
			strResult += Integer.toString(list.get(i))+", ";
		}
		return strResult;
	}

	public static void main(String[] args) 
	{
		Scanner inp = new Scanner(System.in);
		ArrayList<Integer> factorialList = new ArrayList<Integer>();
		System.out.println("lowerLimit: ");
		int lowerLimit = inp.nextInt();
		System.out.println("upperLimit: ");
		int upperLimit = inp.nextInt();
		Factorial fact = new Factorial(lowerLimit, upperLimit);
		for(int x : fact)
		{
			int i, result=1;  
  			int number=5;  
  			for(i=1;i<=x;i++)
  			{    
      			result=result*i;    
  			}
  			factorialList.add(result);   
		}
		System.out.println(fact.toString(factorialList));
	}
}