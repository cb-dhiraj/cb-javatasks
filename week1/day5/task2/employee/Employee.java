import java.util.*;

interface EmployeeDetails{
	void setName(String name);
	void setAge(int age);
	void setSalary(int salary);
}

public class Employee implements Comparable<Employee>{
	int salary;
	String name;
	int age;

	public String getName(){
		return this.name;
	}

	public int getSalary(){
		return this.salary;
	}

	public int getAge(){
		return this.age;
	}

	@Override
    public int compareTo(Employee emp) {
        return this.getName().compareTo(emp.getName());
    }

	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String name; int salary, age;
		ArrayList<Employee> list = new ArrayList<Employee>();
		while(true){
			Employee emp = new Employee();
			EmployeeDetails empDetails = new EmployeeDetails(){
			@Override
			public void setName(String name){
				emp.name = name;
			}

			@Override
			public void setSalary(int salary){
				emp.salary = salary;
			}

			@Override
			public void setAge(int age){
				emp.age = age;
			}
		};
			System.out.println("Name: ");
			name = inp.nextLine();

			System.out.println("Age: ");
			age = inp.nextInt();
			inp.nextLine();

			System.out.println("Salary: ");
			salary = inp.nextInt();

			empDetails.setAge(age);
			empDetails.setName(name);
			empDetails.setSalary(salary);

			list.add(emp);

			inp.nextLine();
			System.out.println("Do you want to sort based on \n 1. Name or \n 2. Age or \n 3. Salary");
			int choice = inp.nextInt();
			inp.nextLine();
			if(choice == 1){
				Collections.sort(list, Employee.NameComparator);
				for(Employee emp2 : list){
					System.out.println("[name: "+ emp2.getName() + ", age: "+ emp2.getAge()+", salary: "+emp2.getSalary()+"]");
				}
			}
			else if(choice == 2){
				Collections.sort(list, Employee.AgeComparator);
				for(Employee emp2 : list){
					System.out.println("[name: "+ emp2.getName() + ", age: "+ emp2.getAge()+", salary: "+emp2.getSalary()+"]");
				}
			}
			else if(choice == 3){
				Collections.sort(list, Employee.SalaryComparator);
				for(Employee emp2 : list){
					System.out.println("[name: "+ emp2.getName() + ", age: "+ emp2.getAge()+", salary: "+emp2.getSalary()+"]");
				}
			}
		}
	}
}