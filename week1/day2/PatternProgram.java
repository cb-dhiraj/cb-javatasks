package week1.day2;

import java.util.Scanner;

public class PatternProgram {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        int duplic = n;
        boolean flag = true;
        for(int start = 1 ; start<=n ; start++){
            for(int i = --duplic; i>0 ; i--){
                System.out.print(" ");
            }
            for(int j=1,k=start-1; j<=start || k>=1; j++){
                if(j<=start){
                    System.out.print(j+" ");
                }
                else if(k>=1){
                    System.out.print(k+" ");
                    k--;
                }
            }
            System.out.println();
        }
    }
}
