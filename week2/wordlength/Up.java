import java.util.*;

class Main{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int noOfWords;
		HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
		System.out.println("Enter number of words to be entered: ");
		noOfWords = inp.nextInt();
		inp.nextLine();
		System.out.println("Now enter "+noOfWords+" words");
		String[] arr = new String[noOfWords];
		for(int i=0; i<noOfWords; i++){
			arr[0] = inp.nextLine();
		}
		int i=0;
		while(i<noOfWords){
			int lengthOfWord = arr[i].length();
			if(map.get(lengthOfWord) != null){
				List<String> values = map.get(lengthOfWord);
				values.add(arr[i]);
				map.put(lengthOfWord, values);
			}
			else{
				List<String> values = new ArrayList<String>();
				values.add(arr[i]);
				map.put(lengthOfWord, values);
			}
			i++;
		}
		System.out.println(map);
	}
}