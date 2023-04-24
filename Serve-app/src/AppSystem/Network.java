/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppSystem;


import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Enterprise.EnterpriseDirectory;
import Organization.Organization;
import Organization.ProductManagement.OrderItem;
import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductOrder;
import Organization.ProductOrganization;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceOrder;
import Organization.ServicesOrganization;
import Person.Client.Client;
import Person.Person;
import Person.PersonDirectory;
import Requests.RequestDirectory;
import UI.ClientWorkArea.HospitalMP;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.ClientRole;
import WorkAreas.ConnectionVolunteerRole;
import WorkAreas.EnterpriseManagerRole;
import WorkAreas.HealthcareSpecialistRole;
import WorkAreas.LegalSpecialistRole;
import WorkAreas.ProductOrganizationManagerRole;
import WorkAreas.ServicesOrganizationManagerRole;
import WorkAreas.SystemAdminRole;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        static EnterpriseDirectory enterprises;
        static UserAccountDirectory topLevelUserAccountDirectory;        
        static PersonDirectory personDirectory;
        ApplicationDirectory applicantDirectory;
        static RequestDirectory reqDir;
      
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

        adminfaker(app, convenience,healthcare,legal,connection,o1,o2,o3,o4,o5,o6);
        
        
        productfaker((ProductOrganization)o1, (ProductOrganization) o2);
        servicefaker((ServicesOrganization) o3,(ServicesOrganization) o4,(ServicesOrganization) o5,(ServicesOrganization) o6);
        clientfaker();
        
        
        servVolfaker((ServicesOrganization) o3,(ServicesOrganization) o4,(ServicesOrganization) o5,(ServicesOrganization) o6);
        
        return app;
    }


    public static void adminfaker(Network app, Enterprise convenience, Enterprise healthcare,Enterprise legal,Enterprise connection,Organization o1, Organization o2,Organization o3,Organization o4,Organization o5,Organization o6){

        Person convP = personDirectory.createPerson( "Connie Venience");
        UserAccount convUA = app.getTopLevelUserAccountDirectory().createUserAccount("conv", "conv", new EnterpriseManagerRole());
        convUA.setPerson(convP);
        convenience.setEnterpriseAdmin(convUA);
        convenience.getUseraccountDirectory().getUserAccountList().add(convUA);
        
        Person healthP = personDirectory.createPerson( "Happ Peabody");
        UserAccount healthUA = app.getTopLevelUserAccountDirectory().createUserAccount("health", "health", new EnterpriseManagerRole());
        healthUA.setPerson(healthP);
        healthcare.setEnterpriseAdmin(healthUA);
        healthcare.getUseraccountDirectory().getUserAccountList().add(healthUA);
        
        
        Person lawP = personDirectory.createPerson("Justice N. Fairtrial");
        UserAccount lawUA = app.getTopLevelUserAccountDirectory().createUserAccount("lawe", "lawe", new EnterpriseManagerRole());
        lawUA.setPerson(lawP);
        legal.setEnterpriseAdmin(lawUA);
        legal.getUseraccountDirectory().getUserAccountList().add(lawUA);

        Person connP = personDirectory.createPerson( "Love Tim Eatwood");
        UserAccount connUA = app.getTopLevelUserAccountDirectory().createUserAccount("conn", "conn", new EnterpriseManagerRole());
        connUA.setPerson(connP);
        connection.setEnterpriseAdmin(connUA);
        connection.getUseraccountDirectory().getUserAccountList().add(connUA);
        
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
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c, 15);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Health").getOrganizationDirectory().findOrganizationbyType("Hospital"), c, 2);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Legal").getOrganizationDirectory().findOrganizationbyType("Law Office"), c, 0);
        
        Client c1 = (Client) personDirectory.createClient("Client B");
        UserAccount ua1 = topLevelUserAccountDirectory.createUserAccount("c1", "c1", new ClientRole());
        ua1.setPerson(c1);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c1, 4);
        
        Client c2 = (Client) personDirectory.createClient("Client C");
        UserAccount ua2 = topLevelUserAccountDirectory.createUserAccount("c2", "c2", new ClientRole());
        ua2.setPerson(c2);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("School"), c2, 0);

        
        
        Client c3 = (Client) personDirectory.createClient("Client D");
        UserAccount ua3 = topLevelUserAccountDirectory.createUserAccount("c3", "c3", new ClientRole());
        ua3.setPerson(c3);
        createDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c3, 15); 
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c3, 16);

        
        Client c4 = (Client) personDirectory.createClient("Client E");
        UserAccount ua4 = topLevelUserAccountDirectory.createUserAccount("c4", "c4", new ClientRole());
        ua4.setPerson(c4);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c3, 15);

        
        Client c5 = (Client) personDirectory.createClient("Client F");
        UserAccount ua5 = topLevelUserAccountDirectory.createUserAccount("c5", "c5", new ClientRole());
        ua5.setPerson(c5);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("Community Organization"), c2, 0);

    }

    public static void productfaker(ProductOrganization pharmacy, ProductOrganization grocery){
        Product pharPro1 = pharmacy.getProductCatalog().newPharmacyProduct("Ibuprofen", 20, "Pain Relief", false);
        pharPro1.setProductImageFilewithFilePath("src/Resources/ProductImages/ibuprofen.jpeg");
       
        Product pharPro2 = pharmacy.getProductCatalog().newPharmacyProduct("Amoxicillin", 40, "Antibiotics", true);
        pharPro2.setProductImageFilewithFilePath("src/Resources/ProductImages/amoxicillin.jpg");     
       
        Product pharPro3 = pharmacy.getProductCatalog().newPharmacyProduct("Aspirin", 16, "Pain Relief", false);
        pharPro3.setProductImageFilewithFilePath("src/Resources/ProductImages/Aspirin.jpg");        
        
        Product pharPro4 = pharmacy.getProductCatalog().newPharmacyProduct("Ibuprofen", 30, "Pain Relief", true);
        pharPro4.setProductImageFilewithFilePath("src/Resources/ProductImages/ibuprofen.jpg");       
        
        Product pharPro5 = pharmacy.getProductCatalog().newPharmacyProduct("Loratadine", 24, "Allergy", false);
        pharPro5.setProductImageFilewithFilePath("src/Resources/ProductImages/Loratadine.jpg");       
        
        Product pharPro6 = pharmacy.getProductCatalog().newPharmacyProduct("Naproxen", 36, "Pain Relief", false);
        pharPro6.setProductImageFilewithFilePath("src/Resources/ProductImages/Naproxen.jpg");        
        
        Product pharPro7 = pharmacy.getProductCatalog().newPharmacyProduct("Cetirizine", 18, "Allergy", false);
        pharPro7.setProductImageFilewithFilePath("src/Resources/ProductImages/Cetirizine.jpg");        
        
        Product pharPro8 = pharmacy.getProductCatalog().newPharmacyProduct("Diphenhydramine", 50, "Allergy", false);
        pharPro8.setProductImageFilewithFilePath("src/Resources/ProductImages/Diphenhydramine.jpg");        
        
        Product pharPro9 = pharmacy.getProductCatalog().newPharmacyProduct("Cephalexin", 12, "Antibiotics", true);
        pharPro9.setProductImageFilewithFilePath("src/Resources/ProductImages/Cephalexin.jpg");        
        
        Product pharPro10 = pharmacy.getProductCatalog().newPharmacyProduct("Acetaminophen", 28, "Acid Reducers", false);
        pharPro10.setProductImageFilewithFilePath("src/Resources/ProductImages/Acetaminophen.jpg");        
        
        Product pharPro11 = pharmacy.getProductCatalog().newPharmacyProduct("Omeprazole", 80, "Pain Relief", false);
        pharPro11.setProductImageFilewithFilePath("src/Resources/ProductImages/Omeprazole.jpg");
        
        Product pharPro12 = pharmacy.getProductCatalog().newPharmacyProduct("Hydrocodone", 35, "Blood Pressure", true);
        pharPro12.setProductImageFilewithFilePath("src/Resources/ProductImages/Hydrocodone.jpg");
        
        Product pharPro13 = pharmacy.getProductCatalog().newPharmacyProduct("Lisinopril", 40, "Cholesterol", true);
        pharPro13.setProductImageFilewithFilePath("src/Resources/ProductImages/Lisinopril.jpg");
        
        Product pharPro14 = pharmacy.getProductCatalog().newPharmacyProduct("Simvastatin", 20, "Diabetes", true);
        pharPro14.setProductImageFilewithFilePath("src/Resources/ProductImages/Simvastatin.jpg");
       
        Product pharPro15 = pharmacy.getProductCatalog().newPharmacyProduct("Metformin", 30, "Asthma", true);
        pharPro15.setProductImageFilewithFilePath("src/Resources/ProductImages/Metformin.jpg");
        
        Product pharPro16 = pharmacy.getProductCatalog().newPharmacyProduct("Albuterol", 18, "Inflammation", false);
        pharPro16.setProductImageFilewithFilePath("src/Resources/ProductImages/Albuterol.jpg");
        
        Product pharPro17 = pharmacy.getProductCatalog().newPharmacyProduct("Prednisone", 25, "Diuretics", true);
        pharPro17.setProductImageFilewithFilePath("src/Resources/ProductImages/Prednisone.jpg");
        
        Product pharPro18 = pharmacy.getProductCatalog().newPharmacyProduct("Furosemide", 45, "Asthma", true);
        pharPro18.setProductImageFilewithFilePath("src/Resources/ProductImages/Furosemide.jpg");
        
        Product pharPro19 = pharmacy.getProductCatalog().newPharmacyProduct("Montelukast", 38, "Blood Pressure", true);
        pharPro19.setProductImageFilewithFilePath("src/Resources/ProductImages/Montelukast.jpg");
       
        Product pharPro20 = pharmacy.getProductCatalog().newPharmacyProduct("Losartan", 50, "Inflammation", true);
        pharPro20.setProductImageFilewithFilePath("src/Resources/ProductImages/Losartan.jpg");
       
        
        Product groPro1 =grocery.getProductCatalog().newProduct("Apples", 2.99, "Fruits");
        groPro1.setProductImageFilewithFilePath("src/Resources/ProductImages/apple.jpeg");

        Product groPro2 =grocery.getProductCatalog().newProduct("Bananas", 1.99, "Fruits");
        groPro2.setProductImageFilewithFilePath("src/Resources/ProductImages/Bananas.jpg");

        Product groPro3 =grocery.getProductCatalog().newProduct("Chicken Breast", 5.99, "Meat");
        groPro3.setProductImageFilewithFilePath("src/Resources/ProductImages/Chicken Breast.jpg");

        Product groPro4 =grocery.getProductCatalog().newProduct("Ground Beef", 4.99, "Meat");
        groPro4.setProductImageFilewithFilePath("src/Resources/ProductImages/Ground Beef.jpg");        

        Product groPro5 =grocery.getProductCatalog().newProduct("Milk", 3.49, "Dairy");
        groPro5.setProductImageFilewithFilePath("src/Resources/ProductImages/Milk.jpg");

        Product groPro6 =grocery.getProductCatalog().newProduct("Eggs", 2.49, "Dairy");
        groPro6.setProductImageFilewithFilePath("src/Resources/ProductImages/Eggs.jpg");

        Product groPro7 =grocery.getProductCatalog().newProduct("Bread", 2.99, "Bakery");
        groPro7.setProductImageFilewithFilePath("src/Resources/ProductImages/Bread.jpg");

        Product groPro8 =grocery.getProductCatalog().newProduct("Butter", 2.99, "Dairy");
        groPro8.setProductImageFilewithFilePath("src/Resources/ProductImages/Butter.jpg");

        Product groPro9 =grocery.getProductCatalog().newProduct("Cheese", 4.99, "Dairy");
        groPro9.setProductImageFilewithFilePath("src/Resources/ProductImages/Cheese.jpg");

        Product groPro10 =grocery.getProductCatalog().newProduct("Rice", 2.99, "Grains");
        groPro10.setProductImageFilewithFilePath("src/Resources/ProductImages/Rice.jpg");

        Product groPro11 =grocery.getProductCatalog().newProduct("Pasta", 2.49, "Grains");
        groPro11.setProductImageFilewithFilePath("src/Resources/ProductImages/Pasta.jpg");

        Product groPro12 =grocery.getProductCatalog().newProduct("Tomatoes", 1.99, "Vegetables");
        groPro12.setProductImageFilewithFilePath("src/Resources/ProductImages/Tomatoes.jpg");

        Product groPro13 =grocery.getProductCatalog().newProduct("Carrots", 1.49, "Vegetables");
        groPro13.setProductImageFilewithFilePath("src/Resources/ProductImages/Carrots.jpg");

        Product groPro14 =grocery.getProductCatalog().newProduct("Broccoli", 1.99, "Vegetables");
        groPro14.setProductImageFilewithFilePath("src/Resources/ProductImages/Broccoli.jpg");

        Product groPro15 =grocery.getProductCatalog().newProduct("Lettuce", 1.99, "Vegetables");
        groPro15.setProductImageFilewithFilePath("src/Resources/ProductImages/Lettuce.jpg");        
    }

      public static void servicefaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
      Service hosServ1 = hospital.getServices().newService("Physical Therapy", 30, "Rehabilitation", "A type of treatment that helps individuals recover  maintain or improve physical abilities after an injury, illness, or surgery.");
      hosServ1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Physical Therapy.jpg");
      
      Service hosServ2 = hospital.getServices().newService("Occupational Therapy", 45, "Rehabilitation", "A type of therapy that focuses on helping people achieve independence in their daily activities after an illness injury or disability.");
      hosServ2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Occupational Therapy.jpg");      
      
      Service hosServ3 = hospital.getServices().newService("Speech Therapy", 60, "Rehabilitation", "A type of therapy that helps individuals improve communication and language skills  as well as swallowing disorders");
      hosServ3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Speech Therapy.jpg");      
      
      Service hosServ4 = hospital.getServices().newService("Medication Management", 15, "Medical Management", "A service that ensures seniors are taking their medication as prescribed and can include medication reminders administration and monitoring.");
      hosServ4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Medication Management.jpg");      
      
      Service hosServ5 = hospital.getServices().newService("Tele-health Check-up", 30, "Physician Care", "A type of treatment that helps individuals recover  maintain or improve physical abilities after an injury, illness, or surgery.");
      hosServ5.setProductImageFilewithFilePath("src/Resources/ServiceImages/Tele-health Check-up.jpg");  
      
      Service lawOff1 = lawOff.getServices().newService("Estate Planning", 60, "Legal Services", "Estate planning is the process of arranging for the management and distribution of a person's estate during their life and after their death.");
      lawOff1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Estate Planning.jpg");

      Service lawOff2 = lawOff.getServices().newService("Elder Law", 30, "Legal Services", "Elder law is a specialized area of legal practice that focuses on the unique needs of older adults and their families.");
      lawOff2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Elder Law.jpg");

      Service lawOff3 = lawOff.getServices().newService("Medicaid Planning", 45, "Legal Services", "Medicaid planning is the process of arranging your finances in such a way as to qualify for Medicaid while still preserving as much of your assets as possible.");
      lawOff3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Medicaid Planning.jpg");

      Service lawOff4 = lawOff.getServices().newService("Social Security Benefits", 20, "Legal Services", "Social Security benefits are a federal program designed to provide financial assistance to retired  disabled and low-income individuals.");
      lawOff4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Social Security Benefits.jpg");

      Service scouts1 = scouts.getServices().newService("Lawn Care", 90, "Home Services", "Boy Scouts of America volunteers can provide lawn care services for seniors who may have difficulty maintaining their yards. Services can include mowing, trimming, and weeding.");
      scouts1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Lawn Care.jpg");  

      Service scouts2 = scouts.getServices().newService("Technology Assistance", 30, "Home Services", "Many seniors struggle with technology and the Boy Scouts of America can help by providing technology assistance such as setting up and troubleshooting devices and teaching seniors how to use software and apps.");
      scouts2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Technology Assistance.jpg");  
     
      Service scouts3 = scouts.getServices().newService("Outdoor Activities", 120, "Physical Activity", "Boy Scouts of America volunteers can take seniors on outdoor activities such as nature walks  bird watching and camping trips. These activities can provide seniors with fresh air exercise and social interaction.");
      scouts3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Outdoor Activities.jpg");  
     
      Service school1 = school.getServices().newService("Reading Buddies", 30, "Companionship & Connection", "High school students can volunteer as reading buddies for seniors who enjoy reading or being read to. This can provide social interaction and mental stimulation for seniors.");
      school1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Reading Buddies.jpg");
     
      Service school2 = school.getServices().newService("Puzzle Partners", 60, "Companionship & Connection", "High school students can volunteer as reading buddies for seniors who enjoy reading or being read to. This can provide social interaction and mental stimulation for seniors.");
      school2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Puzzle Partners.jpg");

      Service school3 = school.getServices().newService("Virtual Visits", 60, "Companionship & Connection", "High school students can volunteer to visit seniors virtually through video calls or phone calls. This can provide social interaction and a way for seniors to connect with others.");
      school3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Virtual Visits.jpg");

      Service school4 = school.getServices().newService("Pet Therapy", 30, "Companionship & Connection", "High school students can bring well-behaved pets such as dogs or cats to visit seniors. This can provide companionship and emotional support for seniors who love animals.");
      school4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Pet Therapy.jpg");     
      }
       
      public static void servVolfaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
          //Doctor
          Person d1 = personDirectory.createPerson("Dr. Rob");
          hospital.getVolunteerDir().createNewVolunteer(d1, new HealthcareSpecialistRole());
          UserAccount ua1 = hospital.getOrganizationAccountDirectory().createUserAccount("d1", "d1", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua1);
          ua1.setPerson(d1);
          
          Person d2 = personDirectory.createPerson("Dr. Lisa");
          hospital.getVolunteerDir().createNewVolunteer(d2, new HealthcareSpecialistRole());
          UserAccount ua2 = hospital.getOrganizationAccountDirectory().createUserAccount("d2", "d2", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua2);
          ua2.setPerson(d2);
          
          Person d3 = personDirectory.createPerson("Dr. Lisa");
          hospital.getVolunteerDir().createNewVolunteer(d3, new HealthcareSpecialistRole());
          UserAccount ua3 = hospital.getOrganizationAccountDirectory().createUserAccount("d3", "d3", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua3);
          ua3.setPerson(d3);
          
          //Legal
          Person l1 = personDirectory.createPerson("Charlie Esq.");
          lawOff.getVolunteerDir().createNewVolunteer(l1, new LegalSpecialistRole());
          UserAccount ua4 = lawOff.getOrganizationAccountDirectory().createUserAccount("l1", "l1", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua4);
          ua4.setPerson(l1);
          
          Person l2 = personDirectory.createPerson("Rob Esq.");
          lawOff.getVolunteerDir().createNewVolunteer(l2, new LegalSpecialistRole());
          UserAccount ua5 = lawOff.getOrganizationAccountDirectory().createUserAccount("l2", "l2", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua5);
          ua5.setPerson(l2);
          
          Person l3 = personDirectory.createPerson("Glenn Esq.");
          lawOff.getVolunteerDir().createNewVolunteer(l3, new LegalSpecialistRole());
          UserAccount ua6 = lawOff.getOrganizationAccountDirectory().createUserAccount("l3", "l3", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua6);
          ua6.setPerson(l3);
          
          //Scout
          Person sc1 = personDirectory.createPerson("Eagle Badge");
          scouts.getVolunteerDir().createNewVolunteer(sc1, new LegalSpecialistRole());
          UserAccount ua7 = scouts.getOrganizationAccountDirectory().createUserAccount("sc1", "sc1", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua7);
          ua7.setPerson(sc1);
          
          Person sc2 = personDirectory.createPerson("Life Badge");
          scouts.getVolunteerDir().createNewVolunteer(sc2, new LegalSpecialistRole());
          UserAccount ua8 = scouts.getOrganizationAccountDirectory().createUserAccount("sc2", "sc2", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua8);
          ua8.setPerson(sc2);
          
          Person sc3 = personDirectory.createPerson("Ten DerFoot");
          scouts.getVolunteerDir().createNewVolunteer(sc3, new LegalSpecialistRole());
          UserAccount ua9 = scouts.getOrganizationAccountDirectory().createUserAccount("sc3", "sc3", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua9);
          ua9.setPerson(sc3);
          
          //School
          Person st1 = personDirectory.createPerson("Sally Student");
          school.getVolunteerDir().createNewVolunteer(sc1, new LegalSpecialistRole());
          UserAccount ua10 = school.getOrganizationAccountDirectory().createUserAccount("st1", "st1", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua7);
          ua10.setPerson(st1);
          
          Person st2 = personDirectory.createPerson("Ronny Class");
          school.getVolunteerDir().createNewVolunteer(sc2, new LegalSpecialistRole());
          UserAccount ua11 = school.getOrganizationAccountDirectory().createUserAccount("st2", "st2", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua8);
          ua11.setPerson(st2);
          
          Person st3 = personDirectory.createPerson("Skip Lunch");
          school.getVolunteerDir().createNewVolunteer(sc3, new LegalSpecialistRole());
          UserAccount ua12 = school.getOrganizationAccountDirectory().createUserAccount("st3", "st3", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua9);
          ua12.setPerson(st3);
      }
      
    public static void createServeOrgReqs(ServicesOrganization servOrg, Client c, int i){
        ArrayList<Service> hosServs = servOrg.getServices().getAllServices();
        ServiceOrder so = new ServiceOrder(c,hosServs.get(i), servOrg, "");
        reqDir.createServiceRequest(c.getUseraccount(), so);
        
    }
      
    public static void createConvenienceReqs(ProductOrganization phar, Client c, int idx){
        ArrayList<Product> pharProds = phar.getProductCatalog().getAllProducts();
        int i = idx;
        for(i = 0; i<pharProds.size()-2;i++){
            ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(pharProds.get(i), 1); currOrd.add(oi);
            i++;
            OrderItem oi2 = new OrderItem(pharProds.get(i), 1);currOrd.add(oi2);
            ProductOrder po = new ProductOrder(c, phar);
            po.setProductsPurchased(currOrd);
        }
        for(ProductOrder po : phar.getMasterOrderList().getProductOrderList()){
            reqDir.createConvenienceRequest(c.getUseraccount(), po);
        }
    }
     public static void createDeliveryReqs(ProductOrganization phar, Client c, int idx){
        ArrayList<Product> pharProds = phar.getProductCatalog().getAllProducts();
        int i = idx;
        for(i =idx; i<pharProds.size()-2;i++){
            ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(pharProds.get(i), 1); currOrd.add(oi);
            i++;
            OrderItem oi2 = new OrderItem(pharProds.get(i), 1);currOrd.add(oi2);
            ProductOrder po = new ProductOrder(c, phar);
            po.setProductsPurchased(currOrd);
        }
        for(ProductOrder po : phar.getMasterOrderList().getProductOrderList()){
            reqDir.createDeliveryRequest(c.getUseraccount(), po);
        }
    }
     
    public static void createGroDeliveryReqs(ProductOrganization gro, Client c, int i){
        ArrayList<Product> groProds = gro.getProductCatalog().getAllProducts();
        int idx = i;
        for(idx = idx; idx<groProds.size()-2;idx++){
            ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(groProds.get(idx), 1); currOrd.add(oi);
            idx++;
            OrderItem oi2 = new OrderItem(groProds.get(idx), 1);currOrd.add(oi2);
            ProductOrder po = new ProductOrder(c, gro);
            po.setProductsPurchased(currOrd);
        }
        for(ProductOrder po : gro.getMasterOrderList().getProductOrderList()){
            reqDir.createDeliveryRequest(c.getUseraccount(), po);
        }
    } 
      
    public void addIcon(int i, javax.swing.JLabel lbl){
        
        String filepath = "src/Resources/servelogo2.jpeg";
        if (i == 1){
             filepath = "src/Resources/servelogo1.jpeg";
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
