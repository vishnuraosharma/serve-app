/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import Applicant.Application;
import Organization.ProductManagement.ProductOrder;
import Organization.ServiceManagement.ServiceOrder;
import UserAccount.UserAccount;
import java.util.HashMap;

/**
 *
 * @author khatna
 */
public class RequestDirectory {
    HashMap<String, Request> allRequests;
    
    public RequestDirectory(){
        this.allRequests = new HashMap();
    }
    
     public ApplicationRequest createVolunteerApplicationRequest(UserAccount ua, Application app) {
        ApplicationRequest appReq = new ApplicationRequest(ua,app);
        allRequests.put("Volunteer Application",appReq);
        return appReq;
    }
    
    public ApplicationRequest createClientApplicationRequest(UserAccount ua, Application app) {
        ApplicationRequest appReq = new ApplicationRequest(ua,app);
        allRequests.put("Client Application",appReq);
        return appReq;
    }
     
     
     public ConvenienceRequest createConvenienceRequest(UserAccount ua, ProductOrder po) {
         ConvenienceRequest conReq = new ConvenienceRequest(ua,po);
        allRequests.put("Convenience",conReq);
        return conReq;
    }
     public HealthRequest createHealthRequest(UserAccount ua, ServiceOrder so) {
         HealthRequest healthReq = new HealthRequest(ua,so);
        allRequests.put("Health",healthReq);
        return healthReq;
    }
     public ConnectionRequest createConnectionRequest(UserAccount ua, ServiceOrder so) {
         ConnectionRequest connectionReq = new ConnectionRequest(ua,so);
        allRequests.put("Connection",connectionReq);
        return connectionReq;
    }
     public LegalRequest createLegalRequest(UserAccount ua, ServiceOrder so) {
         LegalRequest legalReq = new LegalRequest(ua,so);
        allRequests.put("Legal",legalReq);
        return legalReq;
    }
    
}
