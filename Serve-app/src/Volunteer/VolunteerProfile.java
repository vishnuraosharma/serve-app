/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Volunteer;

import Person.Person;
import WorkAreas.AbstractRole;

/**
 *
 * @author siqiyang
 */
public class VolunteerProfile{
    Person p;
    AbstractRole role;

    public VolunteerProfile(Person p, AbstractRole role) {
        this.p = p;
        this.role = role;
    }

    public Person getP() {
        return p;
    }

    public AbstractRole getRole() {
        return role;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public void setRole(AbstractRole role) {
        this.role = role;
    }
    
    
    
}
