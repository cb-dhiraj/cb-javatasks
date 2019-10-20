import java.nio.file.Files;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("/Users/cb-dhiraj/Task/src/week2/wordcount/text.txt")));
        System.out.println(data);
    }
}
