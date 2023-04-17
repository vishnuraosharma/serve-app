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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductOrder getAssociatedOrder() {
        return associatedOrder;
    }

    public void setAssociatedOrder(ProductOrder associatedOrder) {
        this.associatedOrder = associatedOrder;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
}
