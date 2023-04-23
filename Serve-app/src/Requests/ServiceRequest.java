/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests;

import Organization.ServiceManagement.ServiceOrder;
import UserAccount.UserAccount;

/**
 *
 * @author khatna
 */
public class ServiceRequest extends Request {
    ServiceOrder serviceOrder;

    public ServiceRequest(UserAccount requester, ServiceOrder so) {
        super(requester);
        this.serviceOrder = so;
    }
    

    @Override
    public void processRequest() {
         super.setStatus("Completed");
        
         }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }
    
    
}
