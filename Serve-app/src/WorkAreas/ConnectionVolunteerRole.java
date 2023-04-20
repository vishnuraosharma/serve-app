/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;

import UI.EnterpriseManagerWorkArea.EnterpriseManagerJFrame;
import UI.ServiceVolunteerWorkArea.ConnectionVolunteerJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class ConnectionVolunteerRole extends AbstractRole{
    public ConnectionVolunteerRole(){
        super.roleType = "Connection Volunteer";
    }      

    
    @Override
    public JFrame createWorkArea(Network applicationSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        return new ConnectionVolunteerJFrame(applicationSystem, enterprise, organization,useraccount);
    }
    
    @Override
    public String toString() {
        return "Connection Volunteer";
    }      
}
