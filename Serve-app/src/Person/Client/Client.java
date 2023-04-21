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
import java.util.Date;

/**
 *
 * @author siqiyang
 */
public class Client extends Person {
//    private String username;
//    private String password;
    private ArrayList<ProductOrder> prodOrders;
    private ArrayList<ServiceOrder> servOrders;
    private ArrayList<Service> unfulfilledServices;
    private ArrayList<Product> perscripedMeds;

    public Client(String name) {
        super(name);
//        this.username = username;
//        this.password = password;
        this.prodOrders = new ArrayList<>();
        this.servOrders = new ArrayList<>();
        this.unfulfilledServices = new ArrayList<>();
        this.perscripedMeds = new ArrayList<>();
    }
    public Client(Person p) {
        super(p.getName(), p.getSsn(), p.getAddress(), p.getDob(), p.getEmail(), p.getEmergencyContactNumber(), p.getEmergencyContactName(), p.getOccupation(), p.getContactNum());
//        this.username = username;
//        this.password = password;
        this.prodOrders = new ArrayList<>();
        this.servOrders = new ArrayList<>();
        this.unfulfilledServices = new ArrayList<>();
        this.perscripedMeds = new ArrayList<>();
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

//    public String getEmergencyContactName() {
//        return emergencyContactName;
//    }
//
//    public void setEmergencyContactName(String emergencyContactName) {
//        this.emergencyContactName = emergencyContactName;
//    }
//
//    public String getEmergencyContactNumber() {
//        return emergencyContactNumber;
//    }
//
//    public void setEmergencyContactNumber(String emergencyContactNumber) {
//        this.emergencyContactNumber = emergencyContactNumber;
//    }

    public ArrayList<Product> getPerscribedMeds() {
        return perscripedMeds;
    }

    public void setPerscripedMeds(ArrayList<Product> perscripedMeds) {
        this.perscripedMeds = perscripedMeds;
    }
    
}
