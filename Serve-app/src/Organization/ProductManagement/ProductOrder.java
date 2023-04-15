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
    UserAccount client;
    ProductOrganization store;
    UserAccount pharmacist;
    
    public ProductOrder(UserAccount client) {
        oID = "pID" + counter++;
        productsPurchased = new ArrayList();
        this.client = client;
        Client tiedClied = (Client) client.getPerson();
        tiedClied.addClientProductOrder(this);
        status = "in process";
    }
    
    public OrderItem addToCart(Product p, int qty, ProductOrder o){
        OrderItem oi = new OrderItem(p, qty, this);
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

    public UserAccount getClient() {
        return client;
    }

    public void setClient(UserAccount client) {
        this.client = client;
    }

    public ProductOrganization getStore() {
        return store;
    }

    public void setStore(ProductOrganization store) {
        this.store = store;
    }

    public UserAccount getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(UserAccount pharmacist) {
        this.pharmacist = pharmacist;
    }
    
    
    
}
