/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;


/**
 *
 * @author vraosharma
 */
public class OrderItem {
    Product selectedProduct;
    int quantity;
    ProductOrder associatedOrder;
    
    public OrderItem(Product p, int q, ProductOrder o) {
        selectedProduct = p;
        p.addOrderItem(this); //make sure product links back to the item
        quantity = q;
        this.associatedOrder = o;
    }

    public OrderItem(Product p, int qty) {
        selectedProduct = p;
        quantity = qty;
    }
    
    public double getOrderItemRevenue(){
        return this.selectedProduct.getPrice() * quantity;
    }
    
}
