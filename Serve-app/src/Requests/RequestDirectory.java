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
    private HashMap<String, ConvenienceRequest> convenienceRequests;
    private HashMap<String, DeliveryRequest> deliveryRequests;
    private HashMap<String, HealthRequest> healthRequests;
    private HashMap<String, LegalRequest> legalRequests;
    private HashMap<String, ConnectionRequest> connectionRequests;
        
    public RequestDirectory(){
        this.allRequests = new HashMap<>();
        this.conVolApplicationRequests = new HashMap<>();
        this.volApplicationRequests = new HashMap<>();
        this.clientApplicationRequests = new HashMap<>();
        this.convenienceRequests = new HashMap<>();
        this.deliveryRequests = new HashMap<>();
        this.healthRequests = new HashMap<>();
        this.legalRequests = new HashMap<>();
        this.connectionRequests = new HashMap<>();
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
    public ConvenienceRequest createConvenienceRequest(UserAccount requester, ProductOrder po) {
        ConvenienceRequest convenienceReq = new ConvenienceRequest(requester,po);
        List<Request> requests = allRequests.getOrDefault("Convenience purchases", new ArrayList<>());
        requests.add(convenienceReq);
        allRequests.put("Convenience purchases", requests);
        convenienceRequests.put(convenienceReq.getRequestID(), convenienceReq);
        return convenienceReq;
    }
    public DeliveryRequest createDeliveryRequest(UserAccount requester, ConvenienceRequest conReq) {
        DeliveryRequest deliveryReq = new DeliveryRequest(requester,conReq);
        List<Request> requests = allRequests.getOrDefault("Convenience delivery", new ArrayList<>());
        requests.add(deliveryReq);
        allRequests.put("Convenience delivery", requests);
        deliveryRequests.put(deliveryReq.getRequestID(), deliveryReq);
        return deliveryReq;
    }
    public HealthRequest createHealthRequest(UserAccount requester, ServiceOrder so) {
        HealthRequest healthReq = new HealthRequest(requester,so);
        List<Request> requests = allRequests.getOrDefault("Health requests", new ArrayList<>());
        requests.add(healthReq);
        allRequests.put("Health requests", requests);
        healthRequests.put(healthReq.getRequestID(), healthReq);
        return healthReq;
    }
    public LegalRequest createLegalRequest(UserAccount requester, ServiceOrder so) {
        LegalRequest legalReq = new LegalRequest(requester,so);
        List<Request> requests = allRequests.getOrDefault("Legal requests", new ArrayList<>());
        requests.add(legalReq);
        allRequests.put("Legal requests", requests);
        legalRequests.put(legalReq.getRequestID(), legalReq);
        return legalReq;
    }
    public ConnectionRequest createConnectionRequest(UserAccount requester, ServiceOrder so) {
        ConnectionRequest connectionReq = new ConnectionRequest(requester,so);
        List<Request> requests = allRequests.getOrDefault("Health requests", new ArrayList<>());
        requests.add(connectionReq);
        allRequests.put("Health requests", requests);
        connectionRequests.put(connectionReq.getRequestID(), connectionReq);
        return connectionReq;
    }
     
 

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
