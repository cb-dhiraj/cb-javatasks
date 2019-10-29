import java.util.List;

class Invoice{

    public void listServiceCharge(List<ServiceStation> station){

        for (ServiceStation service : station){
            System.out.println(service.getBrand()+" = > "+service.getServiceCharge());
        }

    }

    public void listInvoice(List<ServiceStation> station){

        if(station.size()==0){
            System.out.println("IsEmpty...!");
        }
        else{
            for (ServiceStation service : station){
                System.out.println(service.getName() + " " + service.getBrand() + " " + service.getServiceCharge() + "  " + service.getEmpName());
            }
        }

    }

};