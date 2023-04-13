/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UI.EnterpriseManagerWorkArea.EnterpriseManagerJFrame;
import UI.OrganizationManagerWorkArea.Product.ProductOrganizationManagerJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class ProductOrganizationManagerRole extends AbstractRole {
    public ProductOrganizationManagerRole(){
        super.roleType = "Organization Manager";
    }      

    
    @Override
    public JFrame createWorkArea(Network applicationSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        return new ProductOrganizationManagerJFrame(applicationSystem, enterprise, organization,useraccount);
    }
    
    @Override
    public String toString() {
        return "Product Organization Manager";
    }  
}
