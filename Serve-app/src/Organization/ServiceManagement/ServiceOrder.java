/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;


import Organization.ServicesOrganization;
import Person.Client.Client;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class ServiceOrder {
    private static int counter = 0;
    String oID;
    String status;
    Service s;
    UserAccount clientAccount;
    ServicesOrganization org;
    int hoursRendered;
    
    public ServiceOrder(UserAccount client, Service s) {
        oID = "soID" + counter++;
        this.s = s;
        s.serviceOrdered(this);
        this.clientAccount = client;
        Client tiedClied = (Client) client.getPerson();
        tiedClied.addClientServiceOrder(this);
        status = "in process";
    }
    
//    public OrderItem addToCart(Service p, int qty, ServiceOrder o){
//        OrderItem oi = new OrderItem(p, qty, this);
//        this.productsPurchased.add(oi);
//        return oi;
//    }
    
    public void CancelOrder(){
        status = "Cancelled";
    }
    
    public void Submit(){
        status = "Submitted";
    }

    public static int getCounter() {
        return counter;
    }


    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
    }

   

    public UserAccount getClient() {
        return clientAccount;
    }

    public void setClient(UserAccount client) {
        this.clientAccount = client;
    }

    public ServicesOrganization getOrg() {
        return org;
    }

    public void setOrg(ServicesOrganization org) {
        this.org = org;
    }

   
    
    
    
}
