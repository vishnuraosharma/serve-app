/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;

import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class MasterServiceOrderList {
    ArrayList<ServiceOrder> serviceOrderList;
    
    public MasterServiceOrderList (){
        this.serviceOrderList = new ArrayList<>();
    }
    
    public ServiceOrder newServiceOrder(UserAccount client, Service s){
        ServiceOrder so = new ServiceOrder(client, s);
        this.serviceOrderList.add(so);
        
        return so;
    }
    
    
    
}
