package week1.day2;

import java.util.Scanner;

public class IndicesSummation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String word = inp.nextLine();
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum=sum+((int)(word.charAt(i))-96);
        }
        System.out.println(sum);
    }
}
