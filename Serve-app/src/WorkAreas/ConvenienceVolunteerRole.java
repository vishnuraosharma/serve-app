/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UI.ConvenienceVolunteerWorkArea.ConvenienceVolunteerJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class ConvenienceVolunteerRole extends AbstractRole {
    public ConvenienceVolunteerRole(){
        super.roleType = "Convenience Volunteer";
    }      

    @Override
    public JFrame createWorkArea(Network applicationSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        return new ConvenienceVolunteerJFrame(applicationSystem, enterprise,  organization,useraccount);
    } 
    
}
