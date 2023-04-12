/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class RecipientRole extends AbstractRole{
    public RecipientRole(){
        super.roleType = "Recipient";
    }      

    
    @Override
    public JFrame createWorkArea(Network applicationSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        return new RecipientJFrame(applicationSystem, enterprise, organization,useraccount);
    }
    
    @Override
    public String toString() {
        return "Recipient";
    }     
}
