package week1.day3.taxcalculator.generatetax;

import week1.day3.taxcalculator.employee.Employee;

import java.util.*;

public class GenerateTax {
    public void addEmployees(String name, String gender, int salary, Map<String, List<String>> employeeList){
        List<String> details = new ArrayList<String>();
        Employee employee = new Employee();
        employee.name = name;
        employee.gender = gender;
        employee.salary = salary;
        employee.tax = Taxes.calculateTax(employee.gender, employee.salary);
        details.add(employee.name);
        details.add(employee.gender);
        details.add(Integer.toString(employee.salary));
        details.add(Double.toString(employee.tax));
        employeeList.put(name,details);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Employee employee = new Employee();
        GenerateTax tax = new GenerateTax();
        Map<String, List<String>> employeeList = new HashMap<String, List<String>>();
        while(true){
            System.out.println("1. Add Employee: \n 2. View details of an Employee \n 3. View all Employees");
            int choice = in.nextInt();
            if(choice == 1){
                in.nextLine();
                System.out.println("Employee name: ");
                employee.name = in.nextLine();
                System.out.println("Employee gender: ");
                employee.gender = in.nextLine();
                System.out.println("Employee salary: ");
                employee.salary = in.nextInt();
                tax.addEmployees(employee.name, employee.gender, employee.salary, employeeList);
            }
            else if(choice == 2){
                in.nextLine();
                System.out.println("Enter name of an employee: ");
                String employeeSearch = in.nextLine();
                System.out.println(employeeList.get(employeeSearch));
            }
            else if(choice == 3){
                in.nextLine();
                Set<String> keys = employeeList.keySet();
                for(String key: keys){
                    System.out.println(employeeList.get(key));
                }
            }
        }
    }
}
