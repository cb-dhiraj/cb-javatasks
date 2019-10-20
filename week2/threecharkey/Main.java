import java.util.*;

class Main{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int noOfWords, commonChar;
		String commonCharWord="";
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		System.out.println("Enter number of words to be entered: ");
		noOfWords = inp.nextInt();
		inp.nextLine();
		System.out.println("Now enter "+noOfWords+" words");
		String[] arr = new String[noOfWords];
		for(int i=0; i<noOfWords; i++){
			arr[i] = inp.nextLine();
		}
		System.out.println("How many first common characters: ");
		commonChar = inp.nextInt();
		inp.nextLine();
		int i=0;
		while(i<noOfWords)
		{
			for(int j=0; j<commonChar; j++){
				commonCharWord += arr[i].charAt(j);
			}
			if(map.get(commonCharWord) != null){
				List<String> values = map.get(commonCharWord);
				values.add(arr[i]);
				map.put(commonCharWord, values);
			}
			else{
				List<String> values = new ArrayList<String>();
				values.add(arr[i]);
				map.put(commonCharWord, values);
			}
			i++;
			commonCharWord="";
		}
		System.out.println(map);
	}
}