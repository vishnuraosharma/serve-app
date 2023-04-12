/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UI.EnterpriseManagerWorkArea.EnterpriseManagerJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class EnterpriseManagerRole extends AbstractRole {
   
    public EnterpriseManagerRole(){
        super.roleType = "Enterprise Manager";
    }      

    
    @Override
    public JFrame createWorkArea(Network applicationSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        return new EnterpriseManagerJFrame(applicationSystem, enterprise, organization,useraccount);
    }
    
    @Override
    public String toString() {
        return "Enterprise Manager";
    }      
}
