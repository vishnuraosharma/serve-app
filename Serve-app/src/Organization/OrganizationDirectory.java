/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Enterprise.Enterprise;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class OrganizationDirectory {
    ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public OrganizationDirectory(){
        this.organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
      
    public Organization createProductOrganization(String name,  Enterprise e) {
        Organization organization = new ProductOrganization(name, e);
        this.organizationList.add(organization);
        return organization ;
    }
    
    public Organization createServicesOrganization(String name, Enterprise e) {
        Organization organization = new ServicesOrganization(name, e);
        this.organizationList.add(organization);
        return organization ;
    } 
    
    public Organization createOrganization(String name, Enterprise e){
        ConvenienceVolOrganization conVolOrg = new ConvenienceVolOrganization(name,e);
        this.organizationList.add(conVolOrg);
        return conVolOrg;
    }

    public Organization findOrganization(String name){
        for (Organization o: this.getOrganizationList()){
            if (o.getName().equals(name)){
                return o;
            }
        }
        return null;  
    }
    
    public void deleteOrganization(Organization o){
        organizationList.remove(o);
    }
    

  

}
