/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import Volunteer.VolunteerDirectory;
import Volunteer.VolunteerProfile;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class ServicesOrganization extends Organization {
    final String type = "service";
    UserAccount orgManager;
    ServiceCatalog services;
//    ServiceReport serviceReport;

    VolunteerDirectory volunteerDir;
    
    
    public ServicesOrganization(String name, Enterprise e){
        super(name, e);
        volunteerDir = new VolunteerDirectory();
        services = new ServiceCatalog();
    }
    
    
}
