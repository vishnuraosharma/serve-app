/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Organization.ProductManagement.ProductReport;
import Organization.ProductManagement.ProductCatalog;
import Enterprise.Enterprise;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

/**
 *
 * @author vishnu rao-sharma
 */
public class ProductOrganization extends Organization {
    ProductCatalog productCatalog;
    ProductReport productreport;
    OrderDirectory orderDirectory;
    
    
    public ProductOrganization(String name, Enterprise e, String type) {
        super(name, e);
        super.type = type;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public ProductReport getProductreport() {
        return productreport;
    }

    public void setProductreport(ProductReport productreport) {
        this.productreport = productreport;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

   

    public Enterprise getParentEnterprise() {
        return parentEnterprise;
    }

    public void setParentEnterprise(Enterprise parentEnterprise) {
        this.parentEnterprise = parentEnterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getOrganizationManager() {
        return organizationManager;
    }

    public void setOrganizationManager(UserAccount organizationManager) {
        this.organizationManager = organizationManager;
    }

    public UserAccountDirectory getOrganizationAccounts() {
        return organizationAccounts;
    }

    public void setOrganizationAccounts(UserAccountDirectory organizationAccounts) {
        this.organizationAccounts = organizationAccounts;
    }
    
    
}
