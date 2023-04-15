/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person.Client;

import Organization.ServiceManagement.Order;
import Person.Person;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class Client extends Person{
    String emergencyContactName;
    String emergencyContactNumber;
    ArrayList<Order> orders;
    
    public Client(){
        
    }
    
    public Order addClientOrder(Order o){
        this.orders.add(o);
        return o;
    }
    
}
