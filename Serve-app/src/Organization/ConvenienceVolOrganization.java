/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import Volunteer.VolunteerDirectory;

/**
 *
 * @author khatna
 */
public class ConvenienceVolOrganization extends Organization {
    String name;
    VolunteerDirectory volunteerDir;
    
    public ConvenienceVolOrganization(String name, Enterprise e, String t){
        super(name,e);
        super.type=t;
        volunteerDir = new VolunteerDirectory();
    }
}
