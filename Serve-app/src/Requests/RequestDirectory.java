/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import Applicant.Application;
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
    
     public ApplicationRequest createApplicationRequest(UserAccount ua, Application app) {
        ApplicationRequest appReq = new ApplicationRequest(ua,app);
        allRequests.put("Application",appReq);
        return appReq;
    }
     
     //other adaptations for other requests 
}
