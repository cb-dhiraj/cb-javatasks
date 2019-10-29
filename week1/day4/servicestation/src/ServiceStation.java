import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServiceStation extends Customer {
    private String Sname;
    private String Saddress;
    private long contact;

    static Scanner inp = new Scanner(System.in);

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSaddress(String saddress) {
        Saddress = saddress;
    }

    public String getSaddress() {
        return Saddress;
    }

    public void setConact(long conact) {
        this.contact = conact;
    }

    public long getConact() {
        return contact;
    }

    public static  void main(String args[]){
        List<ServiceStation> station=new ArrayList<ServiceStation>();
        ServiceStation invoice = new ServiceStation();
        while (true){
            System.out.println("Enter your choice: \n 1. Add new service \n 2. List the service charge of all vechicle \n 3. List the invoices");

            int choice=inp.nextInt();
            if(choice==1) {
                ServiceStation stations = new ServiceStation();

                System.out.println("Service station name: ");
                stations.setSname(inp.next());
                inp.nextLine();

                System.out.println("Address: " + stations.getSname());
                String address = inp.nextLine();
                stations.setSaddress(address);

                System.out.println("Contact Details: ");
                stations.setConact(inp.nextLong());

                personDetails(stations);

                vechicleDetails(stations);

                station.add(stations);

            }
            else if(choice ==2) {
                invoice.listServiceCharge(station);
            }
            else if(choice ==3) {
                invoice.listInvoice(station);
            }
        }
    }

    public static  void personDetails(ServiceStation obj){

        System.out.println("Owner name: ");
        obj.setName(inp.next());

        System.out.println("Age of person: ");
        obj.setAge(inp.nextInt());

        System.out.println("Contact no: ");
        obj.setConact(inp.nextLong());

        System.out.println("Mention if the owner of the vechicle is Employee(emp) or Customer(cus): ");
        String type=inp.next().toLowerCase();

        if(type.equals("emp")){
            System.out.println("Enter the employee id");
            obj.setEmpId(inp.nextInt());
            inp.nextLine();
            obj.setEmpName(obj.getName());
        }
    }

    public static void vechicleDetails(ServiceStation obj){

        System.out.println("Brand name: ");
        obj.setBrand(inp.next());

        System.out.println("Color of the car: ");
        obj.setColor(inp.next());

        System.out.println("What's the service ( car | bike | bus )");
        obj.setService(inp.next());

        obj.setServiceCharge(obj.getService());

    }
}