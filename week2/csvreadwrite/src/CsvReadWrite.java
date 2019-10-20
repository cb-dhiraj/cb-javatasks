import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.apache.commons.csv.*;

public class CsvReadWrite {
    public static void main(String[] args) throws IOException {
        int i=0;
        HashSet<List<String>> set = new HashSet<List<String>>();
        String csvRead = "/Users/cb-dhiraj/Documents/list.csv";
        String csvWrite = "/Users/cb-dhiraj/Documents/newFile.csv";
        Reader reader = Files.newBufferedReader(Paths.get(csvRead));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvWrite));
        CSVPrinter addCsv = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name","Age","Gender","Phone"));
        CSVParser parseCsv = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Name","Age","Gender","Phone")
                .withIgnoreHeaderCase()
                .withTrim());
        for(CSVRecord item : parseCsv){
            if(i!=0){
                List<String> list = new ArrayList<>();
                list.add(item.get("Name"));
                list.add(item.get("Age"));
                list.add(item.get("Gender"));
                list.add(item.get("Phone"));
                if(!set.contains(list)){
                    set.add(list);
                    addCsv.printRecord(list);
                }
            }
            i=1;
        }
        addCsv.close();
        System.out.println(set);
    }
}
