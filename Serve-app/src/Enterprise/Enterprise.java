/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

import Organization.Organization;
import Organization.OrganizationDirectory;
import Organization.ServiceManagement.MasterServiceOrderList;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

/**
 *
 * @author siqiyang
 */
public class Enterprise {
    String name;
    OrganizationDirectory organizationDirectory;
    UserAccountDirectory useraccountDirectory;
    UserAccount enterpriseAdmin;
    MasterServiceOrderList MSOL;

    public Enterprise(String name) {
        this.name = name;        
        this.organizationDirectory = new OrganizationDirectory();
        this.useraccountDirectory = new UserAccountDirectory();
    }

    public Enterprise() {

        this.name = name;
        this.organizationDirectory = new OrganizationDirectory();
        this.useraccountDirectory = new UserAccountDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public UserAccountDirectory getUseraccountDirectory() {
        return useraccountDirectory;
    }

    public void setUseraccountDirectory(UserAccountDirectory useraccountDirectory) {
        this.useraccountDirectory = useraccountDirectory;
    }

    public UserAccount getEnterpriseAdmin() {
        return enterpriseAdmin;
    }

    public void setEnterpriseAdmin(UserAccount enterpriseAdmin) {
        this.enterpriseAdmin = enterpriseAdmin;
    }

    public MasterServiceOrderList getMSOL() {
        return MSOL;
    }

    public void setMSOL(MasterServiceOrderList MSOL) {
        this.MSOL = MSOL;
    }
   
  
    @Override
    public String toString() {
        return String.valueOf(name);
    }    
  
    
}
