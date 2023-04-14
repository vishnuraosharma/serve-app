/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import Applicant.Application;

/**
 *
 * @author khatna
 */
public class ApplicationRequest extends Request {
     Application app;
    
    
    public ApplicationRequest(String requester, Application app) {
        super(requester);
        this.app = app;
    }

    @Override
    public void processRequest() {
        super.setStatus("Completed");
        this.app.setStatus("Approved");
        //need logic for creating useraccount for the volunteer
        //adding them to volunteerdir in respective org dir
        //sending email
    }
}
