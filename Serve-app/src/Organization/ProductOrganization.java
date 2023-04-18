/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Convenience;
import Enterprise.Enterprise;
import Organization.ProductManagement.MasterProductOrderList;
import Organization.ProductManagement.ProductCatalog;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

/**
 *
 * @author vishnu rao-sharma
 */
public class ProductOrganization extends Organization {
    ProductCatalog productCatalog;
    MasterProductOrderList MPOL;
    Convenience convenienceCastedEnterprise;
    
    
    public ProductOrganization(String name, Enterprise e, String type) {
        super(name, e);
        super.type = type;
        this.convenienceCastedEnterprise = (Convenience) e;
        productCatalog = new ProductCatalog();
        MPOL = new MasterProductOrderList();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
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

    public MasterProductOrderList getMasterOrderList() {
        return MPOL;
    }

    public void setAllOrders(MasterProductOrderList allOrders) {
        this.MPOL = allOrders;
    }

    public Convenience getConvenienceCastedEnterprise() {
        return convenienceCastedEnterprise;
    }

    public void setConvenienceCastedEnterprise(Convenience ConvenienceCastedEnterprise) {
        this.convenienceCastedEnterprise = ConvenienceCastedEnterprise;
    }
    
    
}
