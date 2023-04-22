/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Volunteer;

import Person.Person;
import Requests.Request;
import WorkAreas.AbstractRole;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class VolunteerProfile extends Person{
//    Person p;
    AbstractRole role;
    ArrayList<Request> volunteerRequests;
    
    

    public VolunteerProfile(Person p) {
        super(p.getName(), p.getSsn(), p.getAddress(), p.getDob(), p.getEmail(), p.getEmergencyContactNumber(), p.getEmergencyContactName(), p.getOccupation(), p.getContactNum());
//        this.role = role;
        volunteerRequests = new ArrayList();
    }
    public VolunteerProfile(Person p, AbstractRole role) {
        super(p.getName(), p.getSsn(), p.getAddress(), p.getDob(), p.getEmail(), p.getEmergencyContactNumber(), p.getEmergencyContactName(), p.getOccupation(), p.getContactNum());
        this.role = role;
        volunteerRequests = new ArrayList();
    }



    public AbstractRole getRole() {
        return role;
    }


    public void setRole(AbstractRole role) {
        this.role = role;
    }

    public ArrayList<Request> getVolunteerRequests() {
        return volunteerRequests;
    }
    
    public void addToVolunteerRequests(Request r){
        this.volunteerRequests.add(r);
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
    
}
