import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String csv = "/Users/cb-dhiraj/Documents/phoneDir.csv";
        BufferedReader br = null;
        String line = "";
        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
               String[] arr = line.split("[,]");
               if(map.get(arr[0]) == null){
                   Map<String, String> mapValues = new HashMap<String, String>();
                   mapValues.put("phone", arr[1]);
                   mapValues.put("home", arr[2]);
                   mapValues.put("work", arr[3]);
                   mapValues.put("address",arr[4]);
                   map.put(arr[0], mapValues);
               }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }
}
