/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Volunteer.VolunteerProfile;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class ServicesOrganization extends Organization {
    final String type = "service";
    ArrayList<VolunteerProfile> volunteerList;
    
    
    public ServicesOrganization(String name){
        super(name);
        volunteerList = new ArrayList<VolunteerProfile>();
    }
}
