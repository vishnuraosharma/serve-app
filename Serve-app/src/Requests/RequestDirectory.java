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
import Person.Client.Client;
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
    private HashMap<String, ServiceRequest> serviceRequests;
        
    public RequestDirectory(){
        this.allRequests = new HashMap<>();
        this.conVolApplicationRequests = new HashMap<>();
        this.volApplicationRequests = new HashMap<>();
        this.clientApplicationRequests = new HashMap<>();
        this.convenienceRequests = new HashMap<>();
        this.deliveryRequests = new HashMap<>();
        this.serviceRequests = new HashMap<>();
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
    public DeliveryRequest createDeliveryRequest(UserAccount requester, ProductOrder po) {
        DeliveryRequest deliveryReq = new DeliveryRequest(requester,po);
        List<Request> requests = allRequests.getOrDefault("Convenience delivery", new ArrayList<>());
        requests.add(deliveryReq);
        allRequests.put("Convenience delivery", requests);
        deliveryRequests.put(deliveryReq.getRequestID(), deliveryReq);
        return deliveryReq;
    }
    
    public Request createServiceRequest(UserAccount requester, ServiceOrder so) {
        ServiceRequest serviceReq = new ServiceRequest(requester,so);
        List<Request> requests = allRequests.getOrDefault("Service requests", new ArrayList<>());
        requests.add(serviceReq);
        allRequests.put("Service requests", requests);
        serviceRequests.put(serviceReq.getRequestID(), serviceReq);
        return serviceReq;
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

    public HashMap<String, ConvenienceRequest> getConvenienceRequests() {
        return convenienceRequests;
    }

    public HashMap<String, DeliveryRequest> getDeliveryRequests() {
        return deliveryRequests;
    }

    public HashMap<String, ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }


    public HashMap<String, ConvenienceRequest> getConvenienceRequestsbyClient(Client c) {
        HashMap<String, ConvenienceRequest> clientConvenienceRequests = new HashMap<String, ConvenienceRequest>();
        //loop through all convenience requests and find the ones that have product orders with the client as the requester
        for (ConvenienceRequest cr : convenienceRequests.values()) {
            if (cr.getProductOrder().getClient().equals(c)) {
                System.out.println("Requests.RequestDirectory.getConvenienceRequestsbyClient()" + c);
                clientConvenienceRequests.put(cr.getRequestID(), cr);
            }
        }
        return clientConvenienceRequests;
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

    public HashMap<String, ServiceRequest> getServiceRequestsbyClient(Client client) {
        HashMap<String, ServiceRequest> clientServiceRequests = new HashMap<String, ServiceRequest>();
        //loop through all convenience requests and find the ones that have product orders with the client as the requester
        for (ServiceRequest sr : serviceRequests.values()) {
            if (sr.getServiceOrder().getClient().equals(client)) {
                clientServiceRequests.put(sr.getRequestID(), sr);
            }
        }
        return clientServiceRequests;
    }

    public HashMap<String, DeliveryRequest> getDeliveryRequestsbyClient(Client client) {
    HashMap<String, DeliveryRequest> clientDelReqs = new HashMap<String, DeliveryRequest>();
        //loop through all Delivery requests and find the ones that have product orders with the client as the requester
        for (DeliveryRequest dr : this.deliveryRequests.values()) {
            if (dr.getOrderToBedelivered().getClient().equals(client)) {
                clientDelReqs.put(dr.getRequestID(), dr);
            }
        }
        return clientDelReqs;

    }

     
    
}
