/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppSystem;


import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Enterprise.EnterpriseDirectory;
import Organization.Organization;
import Person.PersonDirectory;
import UserAccount.UserAccountDirectory;
import WorkAreas.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class Network {
        String name;
        EnterpriseDirectory enterprises;
        UserAccountDirectory topLevelUserAccountDirectory;        
        PersonDirectory personDirectory;
        ApplicationDirectory applicantDirectory;

      
    public Network( ) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
    }
    
    public Network(String name) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
    }
    
    
//    public static Network getInstance() {
//        return new Network();
//    }
    
    public static Network createSystemInstance() {
        Network app = new Network("Serve Boston");
        
        Enterprise convenience = app.getEnterprises().createConvenienceEnterprise("Convenience");
        
        //MAKE THIS PRODUCT ORGANIZATION???!?!!?!?
        convenience.getOrganizationDirectory().createProductOrganization("CVS");
        convenience.getOrganizationDirectory().createProductOrganization("Trader Joe");
        
        
        //MAKE THESE SERVICE ORGANIZATIONS???!?!!?!?
        Enterprise healthcare  = app.getEnterprises().createEnterprise("Healthcare");
        healthcare.getOrganizationDirectory().createServicesOrganization("Beth Israel");
        
        Enterprise legal  = app.getEnterprises().createEnterprise("Legal");
        legal.getOrganizationDirectory().createServicesOrganization("Burns and Levinson LLP");
        
        Enterprise connection  = app.getEnterprises().createEnterprise("Connection");
        connection.getOrganizationDirectory().createServicesOrganization("Boy Scouts");
        connection.getOrganizationDirectory().createServicesOrganization("Brookline High School");  
        
        return app;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EnterpriseDirectory getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(EnterpriseDirectory enterprises) {
        this.enterprises = enterprises;
    }

    public UserAccountDirectory getTopLevelUserAccountDirectory() {
        return topLevelUserAccountDirectory;
    }

    public void setTopLevelUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.topLevelUserAccountDirectory = userAccountDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    


}
