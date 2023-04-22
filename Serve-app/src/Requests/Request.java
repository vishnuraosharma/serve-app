/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import UserAccount.UserAccount;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author khatna
 */
public abstract class Request {
    String requestID;
    static int counter = 1;
    UserAccount requester; //ignore the datatype for now, we should discuss
    UserAccount requestResponder; //ignore the datatype for now, we should discuss
    Date requestDate;
    String status;
    String requestDetails;
    String responderComments;
    
    public Request(UserAccount requester){
        this.requestID = "req" + counter++;
        this.requester = requester;
        this.requestDate = new Date();
        this.status = "Created";
    }
    
    public abstract void processRequest(); //abstract method

    public String getRequestID() {
        return requestID;
    }

    public UserAccount getRequester() {
        return requester;
    }

    public UserAccount getRequestResponder() {
        return requestResponder;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setRequester(UserAccount requester) {
        this.requester = requester;
    }

    public void setRequestResponder(UserAccount requestResponder) {
        this.requestResponder = requestResponder;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public String getResponderComments() {
        return responderComments;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }

    public void setResponderComments(String responderComments) {
        this.responderComments = responderComments;
    }
 
    
    
}
