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
    Service service;
    Client clientAccount;
    ServicesOrganization org;
    int hoursRendered;
    String orderDetails;
    
    public ServiceOrder(Client client, Service s, ServicesOrganization servOrg, String orderDetails) {
        oID = "soID" + counter++;
        this.service = s;
        s.serviceOrdered(this);
        this.orderDetails = orderDetails;
        
        this.clientAccount = client;
        this.clientAccount.addClientServiceOrder(this);
        this.org = servOrg;
        this.org.getMasterOrderList().addServiceOrder(this);
        this.org.getE().getMSOL().addServiceOrder(this);
        
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
        return service;
    }

    public void setS(Service s) {
        this.service = s;
    }

   

    public Client getClient() {
        return clientAccount;
    }

    public void setClient(Client client) {
        this.clientAccount = client;
    }

    public ServicesOrganization getOrg() {
        return org;
    }

    public void setOrg(ServicesOrganization org) {
        this.org = org;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Client getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(Client clientAccount) {
        this.clientAccount = clientAccount;
    }

    public int getHoursRendered() {
        return hoursRendered;
    }

    public void setHoursRendered(int hoursRendered) {
        this.hoursRendered = hoursRendered;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

   
    
    
    
}
