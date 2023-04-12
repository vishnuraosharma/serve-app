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
public abstract class  AbstractRole {
    String roleType;
    static String[] roles = {"System Admin", "Enterprise Manager", "Organization Manager", "Application Manager", "Recipient", "Convenience Volunteer", "Connection Volunteer","Healthcare Specialist", "Legal Specialist" };
    
            
    public AbstractRole(){
        
    }

    public  static String[] getRoles() {
        return roles;
    }

    public String getRoleType() {
        return roleType;
    }
    
    public abstract JFrame createWorkArea(Network applicationSystem,Enterprise enterprise, Organization organization, UserAccount useraccount);       
    

        
}

