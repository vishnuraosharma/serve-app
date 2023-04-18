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
public class HealthRequest extends Request {
    ServiceOrder serviceOrder;

    public HealthRequest(UserAccount requester, ServiceOrder so) {
        super(requester);
        this.serviceOrder = so;
        
    }

    @Override
    public void processRequest() {
     super.setStatus("Pending for volunteer");
    }
    
}
