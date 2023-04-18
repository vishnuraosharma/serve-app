/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;


import Person.Client.Client;
import Organization.ProductOrganization;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class ProductOrder {
    private static int counter = 0;
    String oID;
    String status;
    ArrayList<OrderItem> productsPurchased;
    Client client;
    ProductOrganization store;
    
    public ProductOrder(Client client, ProductOrganization store) {
        oID = "oID" + counter++;
        productsPurchased = new ArrayList();
        this.client = client;
        status = "in process";
        this.store = store;
        this.store.getMasterOrderList().addProductOrder(this);
        this.store.getConvenienceCastedEnterprise().getMPOL().addProductOrder(this);
    }
    
    public OrderItem moveFromCartToOrder(OrderItem oi){
        this.productsPurchased.add(oi);
        return oi;
    }
    
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

    public ArrayList<OrderItem> getProductsPurchased() {
        return productsPurchased;
    }

    public void setProductsPurchased(ArrayList<OrderItem> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    public ProductOrganization getStore() {
        return store;
    }

    public void setStore(ProductOrganization store) {
        this.store = store;
    }


    
    
    
}
