package Requests;


import Organization.ProductManagement.ProductOrder;
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
public class ConvenienceRequest extends Request {
    ProductOrder productOrder;

    public ConvenienceRequest(UserAccount requester, ProductOrder po) {
        super(requester);
        this.productOrder = po;
    }

    @Override
    public void processRequest() {
       super.setStatus("Completed");
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
     
}
