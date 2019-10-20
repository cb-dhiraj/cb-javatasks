import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        String csv = "/Users/cb-dhiraj/Documents/list.csv";
        FileWriter writeCsv = new FileWriter("/Users/cb-dhiraj/Documents/newFile.csv",true);
        BufferedReader br = null;
        String line = "";
        HashSet<String> lines = new HashSet<>();
        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                if(!lines.contains(line)){
                    writeCsv.append(line+"\n");
                }
                if (lines.add(line)) {
                    System.out.println(line);
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
        System.out.println(lines);
        writeCsv.flush();
        writeCsv.close();
    }
}
