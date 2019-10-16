package week1.day3.taxcalculator.generatetax;

public class Taxes {
    public static double calculateTax(String gender, int salary){
        double taxAmount;
        if(gender.equals("Male") && salary>=250000 && salary<500000){
            taxAmount = salary*0.05;
        }
        else if(salary>=500000 && salary<=1000000){
            taxAmount = salary*0.2;
        }
        else if(salary>1000000){
            taxAmount = salary*0.3;
        }
        else{
            return 0.0;
        }
        return taxAmount;
    }
}
