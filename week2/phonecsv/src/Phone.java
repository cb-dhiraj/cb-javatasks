import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.apache.commons.csv.*;

public class Phone {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        String csv = "/Users/cb-dhiraj/Documents/phoneDir.csv";
        Reader reader = Files.newBufferedReader(Paths.get(csv));
        Boolean exit = true;
        int choice, viewChoice;
        String name, phone, work, home, address, searchWord;
        while(exit) {
            System.out.println("1. Phone directory \n2. Add Details \n3. Exit");
            choice = inp.nextInt();
            inp.nextLine();
            if(choice == 1){
                CSVParser parseCsv = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Name","Phone","Home","Work","Address")
                        .withIgnoreHeaderCase()
                        .withTrim());
                System.out.println("1. Search by name  \n2. Search by number ");
                viewChoice = inp.nextInt();
                inp.nextLine();
                if(viewChoice == 1){
                    System.out.println("Name to be searched: ");
                    searchWord = inp.nextLine();
                    for(CSVRecord item : parseCsv){
                        name = item.get("Name");
                        if(searchWord.equals(name)){
                            System.out.println("Name: " + item.get("Name") + ", Phone: " + item.get("Phone") + ", Home: " + item.get("Home") + ", Work: " + item.get("Work") + ", Address: " + item.get("Address"));
                        }
                    }
                }
                else if(viewChoice == 2){
                    System.out.println("Phone number to be searched: ");
                    searchWord = inp.nextLine();
                    for(CSVRecord item : parseCsv){
                        if(item.get("Phone").equals(searchWord) || item.get("Home").equals(searchWord) || item.get("Work").equals(searchWord)){
                            System.out.println("Name: " + item.get("Name") + ", Phone: " + item.get("Phone") + ", Home: " + item.get("Home") + ", Work: " + item.get("Work") + ", Address: " + item.get("Address"));
                        }
                    }
                }
            }
            else if(choice == 2){
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(csv));
                CSVPrinter addCsv = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Name","Phone","Home","Work","Address"));
                List<String> list = new ArrayList<>();
                System.out.println("Name: ");
                name = inp.nextLine();
                list.add(name);
                System.out.println("Phone number: ");
                phone = inp.nextLine();
                list.add(phone);
                System.out.println("home number: ");
                home = inp.nextLine();
                list.add(home);
                System.out.println("work number: ");
                work = inp.nextLine();
                list.add(work);
                System.out.println("address: ");
                address = inp.nextLine();
                list.add(address);
                addCsv.printRecord(list);
                addCsv.flush();
            }
            else{
                exit = false;
            }
        }
    }
}
