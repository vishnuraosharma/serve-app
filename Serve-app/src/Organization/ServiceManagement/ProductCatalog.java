/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;

import Organization.ProductManagement.*;
import java.util.ArrayList;

/**
 *
 * @author vishnu rao-sharma
 */
public class ProductCatalog {
    ArrayList<Service> allProducts;
    ArrayList<ProductSummary> productReport;
    
    public ProductCatalog(){
        allProducts = new ArrayList();
        
    }
    
    public Service newPharmacyProduct(String n, double p, String category, boolean perscribed){
        Service prod = new Service(n, p, category, perscribed);
        this.allProducts.add(prod); 
        return prod;
    }
    
    public Service removeProduct(Service p){
        this.allProducts.remove(p);
        return p;
    }
    
    public ArrayList<ProductSummary> generateProductReport(){
        for (Service p : allProducts){
            ProductSummary ps = new ProductSummary(p);
            productReport.add(ps);
        }
        return this.productReport;
    }

    public ArrayList<Service> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ArrayList<Service> allProducts) {
        this.allProducts = allProducts;
    }

    public ArrayList<ProductSummary> getProductReport() {
        return productReport;
    }

    public void setProductReport(ArrayList<ProductSummary> productReport) {
        this.productReport = productReport;
    }
    
    
}
