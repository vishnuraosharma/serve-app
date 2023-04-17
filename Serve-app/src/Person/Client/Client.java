/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person.Client;

import Organization.ProductManagement.ProductOrder;
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
   
    
    public Client(){
        emergencyContactName = "Mom";
        emergencyContactNumber = "8457418165";
        prodOrders = new  ArrayList<ProductOrder>();
        servOrders = new ArrayList<ServiceOrder>();
    }
    
    public ProductOrder addClientProductOrder(ProductOrder o){
        this.prodOrders.add(o);
        return o;
    }
    
    public ServiceOrder addClientServiceOrder(ServiceOrder so){
        this.servOrders.add(so);
        return so;
    }
    
}
