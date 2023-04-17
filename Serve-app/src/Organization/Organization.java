/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

/**
 *
 * @author vishnu rao-sharma
 */
public class Organization {
    Enterprise parentEnterprise;
    String name;
    UserAccount organizationManager;
    UserAccountDirectory organizationAccounts;
    String type = "";
        



    public Organization(String name, Enterprise e) {
        this.name = name;
        this.parentEnterprise = e;
        this.organizationManager = null;
        this.organizationAccounts = new UserAccountDirectory();

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

    public void setOrganizationManager(UserAccount OrganizationManager) {
        this.organizationManager = OrganizationManager;
    }

    public UserAccountDirectory getOrganizationAccountDirectory() {
        return organizationAccounts;
    }

    public void setOrganizationAccountDirectory(UserAccountDirectory organizationAccounts) {
        this.organizationAccounts = organizationAccounts;
    }

    public Enterprise getE() {
        return parentEnterprise;
    }

    public void setE(Enterprise e) {
        this.parentEnterprise = e;
    }

    public String getOrganizationType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    @Override
    public String toString() {
        return String.valueOf(name);
    }    

   
    
}
