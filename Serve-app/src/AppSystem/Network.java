/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppSystem;


import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Enterprise.EnterpriseDirectory;
import Organization.Organization;
import Person.Client.Client;
import Person.Person;
import Person.PersonDirectory;
import Requests.RequestDirectory;
import UI.ClientWorkArea.HospitalMP;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.ClientRole;
import WorkAreas.EnterpriseManagerRole;
import WorkAreas.ProductOrganizationManagerRole;
import WorkAreas.ServicesOrganizationManagerRole;
import WorkAreas.SystemAdminRole;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author siqiyang
 */
public class Network {
        String name;
        EnterpriseDirectory enterprises;
        static UserAccountDirectory topLevelUserAccountDirectory;        
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
        
        
        Organization o7 = convenience.getOrganizationDirectory().createVolunteerOrganization("ConvenienceVolOrganization", convenience,"Volunteer");
        
        //comment out to remove fake data

        adminfaker(o1,o2,o3,o4,o5,o6);
        clientfaker();
        
        return app;
    }


    public static void adminfaker(Organization o1, Organization o2,Organization o3,Organization o4,Organization o5,Organization o6){
        Person convP = personDirectory.createPerson( "Connie Venience");
        UserAccount convUA = o2.getOrganizationAccountDirectory().createUserAccount("conv", "conv", new EnterpriseManagerRole());
        convUA.setPerson(convP);
        o1.getE().setEnterpriseAdmin(convUA);
        o1.getE().getUseraccountDirectory().getUserAccountList().add(convUA);
        
        Person healthP = personDirectory.createPerson( "Happ Peabody");
        UserAccount healthUA = o3.getOrganizationAccountDirectory().createUserAccount("health", "health", new EnterpriseManagerRole());
        healthUA.setPerson(healthP);
        o3.getE().setEnterpriseAdmin(healthUA);
        o3.getE().getUseraccountDirectory().getUserAccountList().add(healthUA);
        
        Person lawP = personDirectory.createPerson("Justice N. Fairtrial");
        UserAccount lawUA = o4.getOrganizationAccountDirectory().createUserAccount("law", "law", new EnterpriseManagerRole());
        lawUA.setPerson(lawP);
        o4.getE().setEnterpriseAdmin(lawUA);
        o4.getE().getUseraccountDirectory().getUserAccountList().add(lawUA);

        Person connP = personDirectory.createPerson( "Love Tim Eatwood");
        UserAccount connUA = o5.getOrganizationAccountDirectory().createUserAccount("conn", "conn", new EnterpriseManagerRole());
        connUA.setPerson(connP);
        o5.getE().setEnterpriseAdmin(connUA);
        o5.getE().getUseraccountDirectory().getUserAccountList().add(connUA);
        
        Person p1 = personDirectory.createPerson( "Moe Trin");
        UserAccount ua1 = o1.getOrganizationAccountDirectory().createUserAccount("phar", "phar", new ProductOrganizationManagerRole());
        o1.setOrganizationManager(ua1);
        ua1.setPerson(p1);
        o1.getE().getUseraccountDirectory().getUserAccountList().add(ua1);
        
        Person p2 = personDirectory.createPerson( "Cal Ories");
        UserAccount ua2 = o2.getOrganizationAccountDirectory().createUserAccount("gro", "gro", new ProductOrganizationManagerRole());
        o2.setOrganizationManager(ua2);
        ua2.setPerson(p2);
        o2.getE().getUseraccountDirectory().getUserAccountList().add(ua2);
        
        Person p3 = personDirectory.createPerson(  "John Dorian");
        UserAccount ua3 = o3.getOrganizationAccountDirectory().createUserAccount("hos", "hos", new ServicesOrganizationManagerRole());
        o3.setOrganizationManager(ua3);
        ua3.setPerson(p3);
        o3.getE().getUseraccountDirectory().getUserAccountList().add(ua3);
        
        UserAccount ua4 = o4.getOrganizationAccountDirectory().createUserAccount("law", "law", new ServicesOrganizationManagerRole());
        o4.setOrganizationManager(ua4);
        Person p4 = personDirectory.createPerson( "Bob Loblaw");
        ua4.setPerson(p4);
        o4.getE().getUseraccountDirectory().getUserAccountList().add(ua4);
        
        UserAccount ua5 = o5.getOrganizationAccountDirectory().createUserAccount("boy", "boy", new ServicesOrganizationManagerRole());
        o5.setOrganizationManager(ua5);
        Person p5 = personDirectory.createPerson( "Baden Powell");
        ua5.setPerson(p5);
        o5.getE().getUseraccountDirectory().getUserAccountList().add(ua5);
        
        UserAccount ua6 = o6.getOrganizationAccountDirectory().createUserAccount("scho", "scho", new ServicesOrganizationManagerRole());
        o6.setOrganizationManager(ua6);
        Person p6 = personDirectory.createPerson(  "Reese S.");
        ua6.setPerson(p6);
        o6.getE().getUseraccountDirectory().getUserAccountList().add(ua6);
        
    }
    
    public static void clientfaker(){
        
        Client c = (Client) personDirectory.createClient("Client A");
        UserAccount ua = topLevelUserAccountDirectory.createUserAccount("client", "client", new ClientRole());
        ua.setPerson(c);
    }

    public void addIcon(int i, javax.swing.JLabel lbl){
        String filepath;
        if (i == 1){
             filepath = "/Users/vraosharma/Desktop/Java/AED/serve-app/Resources/servelogo1.jpeg";
        } else{
             filepath = "/Users/vraosharma/Desktop/Java/AED/serve-app/Resources/servelogo2.jpeg";
        }
        
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filepath));
            Image image = bufferedImage.getScaledInstance(lbl.getWidth(),lbl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            lbl.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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

    public ApplicationDirectory getApplicantDirectory() {
        return applicantDirectory;
    }

    public RequestDirectory getReqDir() {
        return reqDir;
    }
    
    
}
