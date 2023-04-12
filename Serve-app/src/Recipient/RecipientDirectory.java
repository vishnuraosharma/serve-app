/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recipient;

import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class RecipientDirectory {
    ArrayList<Recipient> recipientList;

    public RecipientDirectory(ArrayList<Recipient> recipientList) {
        this.recipientList = recipientList;
    }

    public ArrayList<Recipient> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(ArrayList<Recipient> recipientList) {
        this.recipientList = recipientList;
    }
    
    
}
