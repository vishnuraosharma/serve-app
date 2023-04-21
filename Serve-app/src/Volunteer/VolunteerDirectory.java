/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Volunteer;

import Person.Person;
import WorkAreas.AbstractRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author siqiyang
 */
public class VolunteerDirectory {
//    ArrayList<VolunteerProfile> volunteerList;
    
    HashMap<String, VolunteerProfile> volunteerRoles;
    
    public VolunteerDirectory(){
//        this.volunteerList = new ArrayList();
        this.volunteerRoles = new HashMap();
    }
    
    public VolunteerProfile createNewVolunteer(Person p, AbstractRole role){
        VolunteerProfile volunteer = new VolunteerProfile(p,role);
        String name = (volunteer.getRole().getRoleType().equals("Healthcare Specialist") ? "Healthcare" 
                : (volunteer.getRole().getRoleType().equals("Legal Specialist") ? "Legal"
                : (volunteer.getRole().getRoleType().equals("Connection Volunteer") ? "Connection"
                : "Convenience")));
        this.volunteerRoles.put(name, volunteer);
        return volunteer;
    }
    
}
