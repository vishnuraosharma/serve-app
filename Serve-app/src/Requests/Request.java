/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import UserAccount.UserAccount;
import java.time.LocalDateTime;

/**
 *
 * @author khatna
 */
public abstract class Request {
    String requestID;
    static int counter = 1;
    UserAccount requester; //ignore the datatype for now, we should discuss
    UserAccount requestResponder; //ignore the datatype for now, we should discuss
    LocalDateTime requestDate;
    String status;
    
    public Request(UserAccount requester){
        this.requestID = "req" + counter++;
        this.requester = requester;
        this.requestDate = LocalDateTime.now();
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

    public LocalDateTime getRequestDate() {
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

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
