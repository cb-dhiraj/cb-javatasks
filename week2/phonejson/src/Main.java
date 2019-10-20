import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner inp = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        String jsonFile = "/Users/cb-dhiraj/Documents/js.json";
        Reader reader = new FileReader(jsonFile);
        Object jsonObj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) jsonObj;
        Boolean exit = true;
        int choice, viewChoice, i=0;
        String name, phone, work, home, address, searchWord;
        while(exit){
            System.out.println("1. Phone directory \n2. Add Details \n3. Exit");
            choice = inp.nextInt();
            inp.nextLine();
            if(choice == 1){
                System.out.println("1. Search by name  \n2. Search by number ");
                viewChoice = inp.nextInt();
                inp.nextLine();
                if(viewChoice == 1) {
                    System.out.println("Name to be searched: ");
                    searchWord = inp.nextLine();
                    for(int j=0; j<jsonObject.size(); j++){
                        JSONObject user = (JSONObject) jsonObject.get(Integer.toString(j));
                        String userName = (String) user.get("Name");
                        if(searchWord.equals(userName)){
                            String userPhone = (String) user.get("Phone");
                            String userHome = (String) user.get("Home");
                            String userWork = (String) user.get("Work");
                            String userAddress = (String) user.get("Address");
                            System.out.println("Name: " + userName + " Phone Number: " + userPhone + " Home Number: " + userHome + " Work Number: " + userWork + " Address: " + userAddress);
                        }
                    }
                }
                else if(viewChoice == 2){
                    System.out.println("Phone Number to be searched: ");
                    searchWord = inp.nextLine();
                    for(int j=0; j<jsonObject.size(); j++){
                        JSONObject user = (JSONObject) jsonObject.get(j);
                        String userPhone = (String) user.get("Phone");
                        String userHome = (String) user.get("Home");
                        String userWork = (String) user.get("Work");
                        if(userPhone == searchWord || userHome == searchWord || userWork == searchWord){
                            String userName = (String) user.get("Name");
                            String userAddress = (String) user.get("Address");
                            System.out.println("Name: " + userName + " Phone Number: " + userPhone + " Home Number: " + userHome + " Work Number: " + userWork + " Address: " + userAddress);
                        }
                    }
                }
            }
            else if(choice == 2){
                JSONObject userValues = new JSONObject();
                System.out.println("Name: ");
                name = inp.nextLine();
                userValues.put("Name", name);
                System.out.println("Phone number: ");
                phone = inp.nextLine();
                userValues.put("Phone", phone);
                System.out.println("home number: ");
                home = inp.nextLine();
                userValues.put("Home", home);
                System.out.println("work number: ");
                work = inp.nextLine();
                userValues.put("Work", work);
                System.out.println("address: ");
                address = inp.nextLine();
                userValues.put("Address", address);

                jsonObject.put(Integer.toString(i), userValues);
                try (FileWriter file = new FileWriter(jsonFile)) {
                    file.write(jsonObject.toJSONString());
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ++i;
            }
            else if(choice == 3){
                exit = false;
            }
        }
    }
}
