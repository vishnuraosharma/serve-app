/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author vishnu rao-sharma
 */
public class ProductCatalog {
    ArrayList<Product> allProducts;
    ArrayList<ProductSummary> productReport;
    
    public ProductCatalog(){
        allProducts = new ArrayList();
        
    }
    
    public Product newPharmacyProduct(String n, double p, String category, boolean perscribed){
        Product prod = new Product(n, p, category, perscribed);
        this.allProducts.add(prod); 
        return prod;
    }
    
    public Product removeProduct(Product p){
        this.allProducts.remove(p);
        return p;
    }
    
    public ArrayList<ProductSummary> generateProductReport(){
        for (Product p : allProducts){
            ProductSummary ps = new ProductSummary(p);
            productReport.add(ps);
        }
        return this.productReport;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public ArrayList<ProductSummary> getProductReport() {
        return productReport;
    }

    public void setProductReport(ArrayList<ProductSummary> productReport) {
        this.productReport = productReport;
    }

    public Product newProduct(String n, double p, String cat) {
        Product prod = new Product(n, p, cat);
        prod.setCategory(cat);
        this.allProducts.add(prod); 
        return prod;
    }
    
    public Product findProductByName(String name){
        for(Product p: this.getAllProducts()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    
}
