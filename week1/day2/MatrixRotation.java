package week1.day2;

import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        int [][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = inp.nextInt();
            }
        }
        System.out.println("Enter 1 for Left rotation or 2 for Right rotation");
        int rot = inp.nextInt();
        if(rot==1){
            for(int i=n-1;i>=0;i--){
                for(int j=0;j<n;j++){
                    System.out.print(arr[j][i]+" ");
                }
                System.out.println();
            }
        }
        else{
            for(int i=0;i<n;i++){
                for(int j=n-1;j>=0;j--){
                    System.out.print(arr[j][i]+" ");
                }
                System.out.println();
            }
        }
    }
}
