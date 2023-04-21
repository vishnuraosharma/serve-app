/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import AppSystem.Network;
import Applicant.Application;
import Organization.Organization;
import Organization.ProductManagement.ProductOrder;
import Organization.ServiceManagement.ServiceOrder;
import Organization.ServicesOrganization;
import UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author khatna
 */
public class RequestDirectory {
    private HashMap<String, List<Request>> allRequests;
    private HashMap<String, ApplicationRequest> conVolApplicationRequests;
    private HashMap<String, ApplicationRequest> volApplicationRequests;
    private HashMap<String, ApplicationRequest> clientApplicationRequests;
    
    public RequestDirectory(){
        this.allRequests = new HashMap<>();
        this.conVolApplicationRequests = new HashMap<>();
        this.volApplicationRequests = new HashMap<>();
        this.clientApplicationRequests = new HashMap<>();
    }
    
   public ApplicationRequest createConVolunteerApplicationRequest(Application app,Organization so) {
        ApplicationRequest appReq = new ApplicationRequest(app,so);
        List<Request> requests = allRequests.getOrDefault("Convenience Volunteers Applications", new ArrayList<>());
        requests.add(appReq);
        allRequests.put("Convenience Volunteers Applications", requests);
        conVolApplicationRequests.put(appReq.getRequestID(), appReq);
        return appReq;
    }
    public ApplicationRequest createVolunteerApplicationRequest(UserAccount ua, Application app, Organization so) {
            ApplicationRequest appReq = new ApplicationRequest(ua,app,so);
            List<Request> requests = allRequests.getOrDefault("Service Volunteers Applications", new ArrayList<>());
            requests.add(appReq);
            allRequests.put("Service Volunteers Applications", requests);
            volApplicationRequests.put(appReq.getRequestID(), appReq);
            return appReq;
    }
     
    
    public ApplicationRequest createClientApplicationRequest(Application app, Network appSystem) {
        ApplicationRequest appReq = new ApplicationRequest(app,appSystem);
        List<Request> requests = allRequests.getOrDefault("Client Applications", new ArrayList<>());
        requests.add(appReq);
        allRequests.put("Client Applications", requests);
        clientApplicationRequests.put(appReq.getRequestID(), appReq);
        return appReq;
    }
     
    public ConvenienceRequest createConvenienceRequest(UserAccount ua, ProductOrder po) {
    ConvenienceRequest conReq = new ConvenienceRequest(ua,po);
    List<Request> requests = allRequests.getOrDefault("Convenience", new ArrayList<>());
    requests.add(conReq);
    allRequests.put("Convenience", requests);
    return conReq;
}
     
//     public ConvenienceRequest createConvenienceRequest(UserAccount ua, ProductOrder po) {
//         ConvenienceRequest conReq = new ConvenienceRequest(ua,po);
//        allRequests.put("Convenience",conReq);
//        return conReq;
//    }
//     public HealthRequest createHealthRequest(UserAccount ua, ServiceOrder so) {
//         HealthRequest healthReq = new HealthRequest(ua,so);
//        allRequests.put("Health",healthReq);
//        return healthReq;
//    }
//     public ConnectionRequest createConnectionRequest(UserAccount ua, ServiceOrder so) {
//         ConnectionRequest connectionReq = new ConnectionRequest(ua,so);
//        allRequests.put("Connection",connectionReq);
//        return connectionReq;
//    }
//     public LegalRequest createLegalRequest(UserAccount ua, ServiceOrder so) {
//         LegalRequest legalReq = new LegalRequest(ua,so);
//        allRequests.put("Legal",legalReq);
//        return legalReq;
//    }

    public HashMap<String, List<Request>> getAllRequests() {
        return allRequests;
    }

    public HashMap<String, ApplicationRequest> getConVolApplicationRequests() {
        return conVolApplicationRequests;
    }

    public HashMap<String, ApplicationRequest> getVolApplicationRequests() {
        return volApplicationRequests;
    }

    public HashMap<String, ApplicationRequest> getClientApplicationRequests() {
        return clientApplicationRequests;
    }

    
     
    public Request findRequestById(String id) {
    for (List<Request> requests : allRequests.values()) {
        for (Request request : requests) {
            if (request.getRequestID().equals(id)) {
                return request;
            }
        }
    }
    return null;
    }

     
    
}
