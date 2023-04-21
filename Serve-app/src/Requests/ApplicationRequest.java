/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import AppSystem.Network;
import Applicant.Application;
import Enterprise.Convenience;
import Enterprise.Enterprise;
import Organization.ConvenienceVolOrganization;
import Organization.Organization;
import Organization.ServicesOrganization;
import Person.Client.Client;
import Person.PersonDirectory;
import UserAccount.UserAccount;
import Volunteer.VolunteerProfile;
import WorkAreas.AbstractRole;
import WorkAreas.ClientRole;
import WorkAreas.ConnectionVolunteerRole;
import WorkAreas.ConvenienceVolunteerRole;
import WorkAreas.HealthcareSpecialistRole;
import WorkAreas.LegalSpecialistRole;

/**
 *
 * @author khatna
 */
public class ApplicationRequest extends Request {
     Application app;
     Organization forOrganization;
     Network network;
    
    public ApplicationRequest(Application app, Network appSystem) {
        super(null);
        this.app = app;
        this.network = appSystem;
    }
    public ApplicationRequest(Application app, Organization so) {
        super(null);
        this.app = app;
        this.forOrganization = so;
    }
    public ApplicationRequest(UserAccount requester, Application app, Organization so) {
        super(requester);
        this.app = app;
        this.forOrganization = so;
    }

    @Override
    public void processRequest() {
        super.setStatus("Completed");
        this.app.setStatus("Approved");
        
             AbstractRole role = (this.forOrganization.getName().equals("Hospital") ? new HealthcareSpecialistRole() 
                : (this.forOrganization.getName().equals("Law Office") ? new LegalSpecialistRole() 
                : (this.forOrganization.getName().equals("Community Organization") || this.forOrganization.getName().equals("School") ? new ConnectionVolunteerRole() 
                     : new ConvenienceVolunteerRole())));     
             Enterprise e = this.forOrganization.getParentEnterprise();
             if(e instanceof Convenience){
                 ConvenienceVolOrganization org = (ConvenienceVolOrganization) e.getOrganizationDirectory().findOrganizationbyType(this.forOrganization.getOrganizationType());
                 UserAccount ua = this.forOrganization.getOrganizationAccountDirectory().createUserAccount(app.getUsername(),app.getPassword(), role);
                this.app.getPerson().setUseraccount(ua);
                VolunteerProfile volunteer = org.getVolunteerDir().createNewVolunteer(this.app.getPerson(), role);
             }else{
                 ServicesOrganization org = (ServicesOrganization) e.getOrganizationDirectory().findOrganizationbyType(this.forOrganization.getOrganizationType());
        
                UserAccount ua = this.forOrganization.getOrganizationAccountDirectory().createUserAccount(app.getUsername(),app.getPassword(), role);
                this.app.getPerson().setUseraccount(ua);
                VolunteerProfile volunteer = org.getVolunteerDir().createNewVolunteer(this.app.getPerson(), role);
             }
             
  
        //sending email
    }
    
    public void processClients(){
        super.setStatus("Completed");
        this.app.setStatus("Approved");
        
        AbstractRole role = new ClientRole();
        PersonDirectory perDir = this.network.getPersonDirectory();
        Client c = perDir.createClient(this.app.getPerson());
        UserAccount ua = this.network.getTopLevelUserAccountDirectory().createUserAccount(this.app.getUsername(), this.app.getPassword(), role);
        c.setUseraccount(ua);
        
    }
    
    public void rejectApplication(){
        super.setStatus("Completed");
        this.app.setStatus("Denied");
        
    }
    public void holdApplication(){
        super.setStatus("Pending");
        this.app.setStatus("On Hold");
        
    }
    

    public Application getApp() {
        return app;
    }
    
    
}
