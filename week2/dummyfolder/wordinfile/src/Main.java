import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/cb-dhiraj/wordinfile/src/textWrite.txt", true));
        int num=0, i=1, index=0;
        String word="";
        Scanner inp = new Scanner(System.in);
        FileReader file = new FileReader("/Users/cb-dhiraj/Task/src/week2/wordcount/src/text.txt");
        Scanner in = new Scanner(file);
        System.out.println("Enter word to be searched: ");
        word = inp.nextLine();
        writer.append(word + "\n");
        while(in.hasNextLine()){
            String currentLine = in.nextLine();
            while(currentLine.indexOf(word, index) != -1){
                index = currentLine.indexOf(word,index);
                writer.append(i + " : " + index + "\n");
                System.out.println(i + " : " + index);
                ++index;
            }
            i++;
            index = 0;
        }
        writer.close();
    }
}
