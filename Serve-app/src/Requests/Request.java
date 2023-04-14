/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import java.time.LocalDateTime;

/**
 *
 * @author khatna
 */
public abstract class Request {
    String requestID;
    static int counter = 1;
    Role requester; //ignore the datatype for now, we should discuss
    Role requestResponder; //ignore the datatype for now, we should discuss
    LocalDateTime requestDate;
    String status;
    
    public Request(String requester){
        this.requestID = "req" + counter++;
        this.requester = requester;
        this.requestDate = LocalDateTime.now();
        this.status = "Created";
    }
    
    public abstract void processRequest(); //abstract method

    public String getRequestID() {
        return requestID;
    }

    public String getRequester() {
        return requester;
    }

    public String getRequestResponder() {
        return requestResponder;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setRequester(Role requester) {
        this.requester = requester;
    }

    public void setRequestResponder(Role requestResponder) {
        this.requestResponder = requestResponder;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
