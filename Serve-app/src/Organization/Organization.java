/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import UserAccount.UserAccount;

/**
 *
 * @author siqiyang
 */
public class Organization {
    String name;
    UserAccount organizationManager;


    public Organization(String name) {
        this.name = name;

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
    
      
    @Override
    public String toString() {
        return String.valueOf(name);
    }    
    
}
