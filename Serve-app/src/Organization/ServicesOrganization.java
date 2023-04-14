/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import UserAccount.UserAccountDirectory;
import Volunteer.VolunteerProfile;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author vishnu rao-sharma
 */
public class ServicesOrganization extends Organization {
    
    ArrayList<VolunteerProfile> volunteerList;
    
    
    public ServicesOrganization(String name, Enterprise e, String type){
        super(name, e);
        super.type = type;
        volunteerList = new ArrayList<VolunteerProfile>();
    }
}
