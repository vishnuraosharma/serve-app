/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppSystem;


import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Enterprise.EnterpriseDirectory;
import Organization.Organization;
import Person.Person;
import Person.PersonDirectory;
import Requests.RequestDirectory;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.EnterpriseManagerRole;
import WorkAreas.ProductOrganizationManagerRole;
import WorkAreas.ServicesOrganizationManagerRole;
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
        static PersonDirectory personDirectory;
        ApplicationDirectory applicantDirectory;
        RequestDirectory reqDir;
      
    public Network( ) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
        this.reqDir = new RequestDirectory();
    }
    
    public Network(String name) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
        this.reqDir = new RequestDirectory();
    }
    
    
//    public static Network getInstance() {
//        return new Network();
//    }
    
    public static Network createSystemInstance() {
        Network app = new Network("Serve Boston");
        
        Enterprise convenience = app.getEnterprises().createConvenienceEnterprise("Convenience");
        
        //MAKE THIS PRODUCT ORGANIZATION???!?!!?!?
        
        Organization o1 = convenience.getOrganizationDirectory().createProductOrganization("Pharmacy", convenience, "Pharmacy");
        Organization o2 = convenience.getOrganizationDirectory().createProductOrganization("Grocery Store", convenience, "Grocery Store");
        
        //MAKE THESE SERVICE ORGANIZATIONS???!?!!?!?
        Enterprise healthcare  = app.getEnterprises().createEnterprise("Health");
        Organization o3 = healthcare.getOrganizationDirectory().createServicesOrganization("Hospital",healthcare, "Hospital");
        
        Enterprise legal  = app.getEnterprises().createEnterprise("Legal");
        Organization o4 = legal.getOrganizationDirectory().createServicesOrganization("Law Office",legal, "Law Office");
        
        Enterprise connection  = app.getEnterprises().createEnterprise("Connection");
        Organization o5 = connection.getOrganizationDirectory().createServicesOrganization("Community Organization",connection, "Community Organization");
        Organization o6 = connection.getOrganizationDirectory().createServicesOrganization("School",connection, "School");  
        
        
        Organization o7 = convenience.getOrganizationDirectory().createOrganization("ConvenienceVolOrganization", convenience);
        
        //comment out to remove fake data

//        faker(o1,o2,o3,o4,o5,o6);
        
        return app;
    }


//    public static void faker(Organization o1, Organization o2,Organization o3,Organization o4,Organization o5,Organization o6){
//        UserAccount convUA = o2.getOrganizationAccountDirectory().createUserAccount("conv", "conv", new EnterpriseManagerRole());
//        Person convP = personDirectory.createPerson( convUA.getAccountId(), "Connie Venience");
//        convUA.setPerson(convP);
//        o1.getE().setEnterpriseAdmin(convUA);
//        o1.getE().getUseraccountDirectory().getUserAccountList().add(convUA);
//        
//        UserAccount healthUA = o3.getOrganizationAccountDirectory().createUserAccount("health", "health", new EnterpriseManagerRole());
//        Person healthP = personDirectory.createPerson( healthUA.getAccountId(), "Happ Peabody");
//        healthUA.setPerson(healthP);
//        o3.getE().setEnterpriseAdmin(healthUA);
//        o3.getE().getUseraccountDirectory().getUserAccountList().add(healthUA);
//        
//        UserAccount lawUA = o4.getOrganizationAccountDirectory().createUserAccount("law", "law", new EnterpriseManagerRole());
//        Person lawP = personDirectory.createPerson( lawUA.getAccountId(), "Justice N. Fairtrial");
//        lawUA.setPerson(lawP);
//        o4.getE().setEnterpriseAdmin(lawUA);
//        o4.getE().getUseraccountDirectory().getUserAccountList().add(lawUA);
//
//    
//        UserAccount connUA = o5.getOrganizationAccountDirectory().createUserAccount("conn", "conn", new EnterpriseManagerRole());
//        Person connP = personDirectory.createPerson( connUA.getAccountId(), "Love Tim Eatwood");
//        connUA.setPerson(connP);
//        o5.getE().setEnterpriseAdmin(connUA);
//        o5.getE().getUseraccountDirectory().getUserAccountList().add(connUA);
//        
//        UserAccount ua1 = o1.getOrganizationAccountDirectory().createUserAccount("phar", "phar", new ProductOrganizationManagerRole());
//        o1.setOrganizationManager(ua1);
//        Person p1 = personDirectory.createPerson( ua1.getAccountId(), "Moe Trin");
//        ua1.setPerson(p1);
//        o1.getE().getUseraccountDirectory().getUserAccountList().add(ua1);
//        
//        UserAccount ua2 = o2.getOrganizationAccountDirectory().createUserAccount("gro", "gro", new ProductOrganizationManagerRole());
//        o2.setOrganizationManager(ua2);
//        Person p2 = personDirectory.createPerson( ua2.getAccountId(), "Cal Ories");
//        ua2.setPerson(p2);
//        o2.getE().getUseraccountDirectory().getUserAccountList().add(ua2);
//        
//        UserAccount ua3 = o3.getOrganizationAccountDirectory().createUserAccount("hos", "hos", new ProductOrganizationManagerRole());
//        o3.setOrganizationManager(ua3);
//        Person p3 = personDirectory.createPerson( ua3.getAccountId(), "John Dorian");
//        ua3.setPerson(p3);
//        o3.getE().getUseraccountDirectory().getUserAccountList().add(ua3);
//        
//        UserAccount ua4 = o4.getOrganizationAccountDirectory().createUserAccount("law", "law", new ProductOrganizationManagerRole());
//        o4.setOrganizationManager(ua4);
//        Person p4 = personDirectory.createPerson( ua4.getAccountId(), "Bob Loblaw");
//        ua4.setPerson(p4);
//        o4.getE().getUseraccountDirectory().getUserAccountList().add(ua4);
//        
//        UserAccount ua5 = o5.getOrganizationAccountDirectory().createUserAccount("boy", "boy", new ProductOrganizationManagerRole());
//        o5.setOrganizationManager(ua5);
//        Person p5 = personDirectory.createPerson( ua5.getAccountId(), "Baden Powell");
//        ua5.setPerson(p5);
//        o5.getE().getUseraccountDirectory().getUserAccountList().add(ua5);
//        
//        UserAccount ua6 = o6.getOrganizationAccountDirectory().createUserAccount("scho", "scho", new ProductOrganizationManagerRole());
//        o6.setOrganizationManager(ua6);
//        Person p6 = personDirectory.createPerson( ua6.getAccountId(), "Reese S.");
//        ua6.setPerson(p6);
//        o6.getE().getUseraccountDirectory().getUserAccountList().add(ua6);
//        
//    }


    
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

    public ApplicationDirectory getApplicantDirectory() {
        return applicantDirectory;
    }

    public RequestDirectory getReqDir() {
        return reqDir;
    }
    
    
}
