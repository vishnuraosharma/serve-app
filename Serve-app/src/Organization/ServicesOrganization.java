/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import Organization.ServiceManagement.ServiceCatalog;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import Volunteer.VolunteerDirectory;
import Volunteer.VolunteerProfile;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author vishnu rao-sharma
 */
public class ServicesOrganization extends Organization {

    UserAccount orgManager;
    ServiceCatalog services;
//    ServiceReport serviceReport;

    VolunteerDirectory volunteerDir;

    
    
    public ServicesOrganization(String name, Enterprise e, String type){
        super(name, e);
        super.type = type;
  
        volunteerDir = new VolunteerDirectory();
        services = new ServiceCatalog();
    }

    public UserAccount getOrgManager() {
        return orgManager;
    }

    public void setOrgManager(UserAccount orgManager) {
        this.orgManager = orgManager;
    }

    public ServiceCatalog getServices() {
        return services;
    }

    public void setServices(ServiceCatalog services) {
        this.services = services;
    }

    public VolunteerDirectory getVolunteerDir() {
        return volunteerDir;
    }

    public void setVolunteerDir(VolunteerDirectory volunteerDir) {
        this.volunteerDir = volunteerDir;
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
