package week1.day2;

import java.util.Scanner;

public class MinMaxArray {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int min = 100000,max = 0;
        int [] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=inp.nextInt();
        }
        for(int i=0;i<num;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("min->"+min+" max->"+max);
    }
}