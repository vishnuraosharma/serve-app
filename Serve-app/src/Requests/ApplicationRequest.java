/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import Applicant.Application;
import Enterprise.Convenience;
import Enterprise.Enterprise;
import Organization.ConvenienceVolOrganization;
import Organization.Organization;
import Organization.ServicesOrganization;
import UserAccount.UserAccount;
import Volunteer.VolunteerProfile;
import WorkAreas.AbstractRole;
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
    
    public ApplicationRequest(Application app) {
        super(null);
        this.app = app;
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
