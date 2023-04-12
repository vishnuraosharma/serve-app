/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

import Organization.OrganizationDirectory;
import UserAccount.UserAccountDirectory;
import Volunteer.VolunteerDirectory;

/**
 *
 * @author siqiyang
 */
public class Convenience extends Enterprise {
    VolunteerDirectory volunteerList;
    
    public Convenience(String name){
        super(name);
        this.volunteerList = new VolunteerDirectory();
    }

    public Convenience(VolunteerDirectory volunteerList, String name, String type) {
        super(name);
        this.volunteerList = volunteerList;
    }

    public Convenience(VolunteerDirectory volunteerList) {
        this.volunteerList = volunteerList;
    }

    public VolunteerDirectory getVolunteerList() {
        return volunteerList;
    }

    public void setVolunteerList(VolunteerDirectory volunteerList) {
        this.volunteerList = volunteerList;
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
    
    
}
