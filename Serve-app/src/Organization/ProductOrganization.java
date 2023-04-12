/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;

/**
 *
 * @author siqiyang
 */
public class ProductOrganization extends Organization {
    ProductCatalog productCatalog;
    ProductReport productreport;
    OrderDirectory orderDirectory;
    final String type = "product";
    
    public ProductOrganization(String name, Enterprise e) {
        super(name, e);
    }
    
    
}
