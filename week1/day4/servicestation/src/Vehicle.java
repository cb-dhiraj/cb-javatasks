import java.util.*;

class Vechicle extends Invoice{

    private String brand;
    private String color;
    private String service;
    private int serviceCharge;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setServiceCharge(String service) {

        if((service.toLowerCase()).equals("bike")){
            this.serviceCharge = 400;
        }
        else if((service.toLowerCase()).equals("car")){

            this.serviceCharge = 1000;
        }
        else {

            this.serviceCharge=5000;
        }

    }

    public int getServiceCharge() {
        return serviceCharge;
    }
}
