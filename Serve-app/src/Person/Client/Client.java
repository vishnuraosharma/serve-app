/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person.Client;

import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductOrder;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceOrder;
import Person.Person;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class Client extends Person{
    String emergencyContactName;
    String emergencyContactNumber;
    ArrayList<ProductOrder> prodOrders;
    ArrayList<ServiceOrder> servOrders;
    ArrayList<Service> unfulfilledServices;
    ArrayList<Product> perscripedMeds;
   
    
    public Client(){
        emergencyContactName = "Mom";
        emergencyContactNumber = "8457418165";
        prodOrders = new  ArrayList<ProductOrder>();
        servOrders = new ArrayList<ServiceOrder>();
        unfulfilledServices = new ArrayList<>();
        perscripedMeds = new ArrayList<>();
    }
    
    public ProductOrder addClientProductOrder(ProductOrder o){
        this.prodOrders.add(o);
        return o;
    }
    
    public ServiceOrder addClientServiceOrder(ServiceOrder so){
        this.servOrders.add(so);
        return so;
    }

    public ArrayList<ProductOrder> getProdOrders() {
        return prodOrders;
    }

    public void setProdOrders(ArrayList<ProductOrder> prodOrders) {
        this.prodOrders = prodOrders;
    }

    public ArrayList<ServiceOrder> getServOrders() {
        return servOrders;
    }

    public void setServOrders(ArrayList<ServiceOrder> servOrders) {
        this.servOrders = servOrders;
    }

    public ArrayList<Service> getUnfulfilledServices() {
        return unfulfilledServices;
    }

    public void setUnfulfilledServices(ArrayList<Service> unfulfilledServices) {
        this.unfulfilledServices = unfulfilledServices;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public ArrayList<Product> getPerscripedMeds() {
        return perscripedMeds;
    }

    public void setPerscripedMeds(ArrayList<Product> perscripedMeds) {
        this.perscripedMeds = perscripedMeds;
    }
    
}
