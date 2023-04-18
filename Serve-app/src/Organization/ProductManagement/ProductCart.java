/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;

import Organization.ProductOrganization;
import Person.Client.Client;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class ProductCart {
    ArrayList<OrderItem> productCart;
    
    public ProductCart(){
        productCart = new ArrayList<>();
    }
    
    //add to cart
    public OrderItem addToCart(Product p, int qty){
        OrderItem oi = new OrderItem(p, qty);
        productCart.add(oi);
        return oi;
    }
    
    //process cart/ order items, add each order item to selected product's <OrderItem>
    public ProductOrder processCart(Client client, ProductOrganization store){
        ProductOrder po = new ProductOrder(client, store);
        if (this.productCart != null){
            for(OrderItem oi : productCart){
                po.moveFromCartToOrder(oi);
                oi.associatedOrder = po;
                oi.selectedProduct.addOrderItem(oi);
            }
             
        }
        client.addClientProductOrder(po);
        emptyCart();
        return po;
    }
    //empty cart, create new product cart
    public void emptyCart(){
        this.productCart = new ArrayList<>(); 
    }

    public ArrayList<OrderItem> getCartOrderItems() {
        return productCart;
    }

    public void setCartOrderItems(ArrayList<OrderItem> productCart) {
        this.productCart = productCart;
    }
    
    
    
}
