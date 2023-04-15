/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;

import Organization.ProductManagement.*;


/**
 *
 * @author vraosharma
 */
public class ProductSummary {
    Service subjectproduct;
    double productRevenue;
    
    public ProductSummary(Service p){
        
        productRevenue = p.productRevenue();
        subjectproduct = p; 
    }
    
}
