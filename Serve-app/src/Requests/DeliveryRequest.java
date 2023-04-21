package Requests;


import Organization.ProductManagement.ProductOrder;
import Requests.ConvenienceRequest;
import Requests.Request;
import UserAccount.UserAccount;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khatna
 */
public class DeliveryRequest extends Request{
//    ProductOrder orderToBedelivered;
    ConvenienceRequest convenienceReq;
    String deliveryAddress;
    boolean isUrgent;

    public DeliveryRequest(UserAccount requester,ConvenienceRequest convenienceReq) {
        super(requester);
        this.convenienceReq = convenienceReq;
        deliveryAddress = this.convenienceReq.getProductOrder().getClient().getAddress();
    }
    
    

    @Override
    public void processRequest() {
        super.setStatus("Completed");
        this.convenienceReq.setStatus("Delivered!");
    }
    
    public void updateConvenienceReq(){
        this.convenienceReq.setStatus("Assigned for delivery");
    }

    public ConvenienceRequest getConvenienceReq() {
        return convenienceReq;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }
    
    
   
}
