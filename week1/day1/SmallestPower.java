package week1.day1;

import java.util.Scanner;

public class SmallestPower {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int x = inp.nextInt();
        int y = inp.nextInt();
        for(int i=1;i<100;i++){
            if(Math.pow(x,i) > y) {
                System.out.println(i);
                break;
            }
        }
    }
}
