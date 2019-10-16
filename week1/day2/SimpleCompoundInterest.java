package week1.day2;

import java.util.Scanner;

public class SimpleCompoundInterest {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double principle = inp.nextDouble();
        double year = inp.nextDouble();
        double interest = inp.nextDouble()/100;
        double simpleInterest = principle * interest * year;
        double compoundInterest = principle * ((Math.pow(1+interest,year))-1);
        System.out.println(simpleInterest+ " "+ compoundInterest);
    }
}
