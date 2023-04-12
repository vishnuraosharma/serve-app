/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class EnterpriseDirectory {
        ArrayList<Enterprise> enterpiseList;

    public EnterpriseDirectory() {
        this.enterpiseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpiseList() {
        return enterpiseList;
    }

    public void setEnterpiseList(ArrayList<Enterprise> enterpiseList) {
        this.enterpiseList = enterpiseList;
    }

    public Enterprise createEnterprise(String name) {
        Enterprise enterprise = new Enterprise(name);
        this.enterpiseList.add(enterprise);
        return enterprise;
    }   
    public Enterprise createConvenienceEnterprise(String name) {
        Convenience conEnterprise = new Convenience(name);
        this.enterpiseList.add(conEnterprise);
        return conEnterprise;
    }   
   
    public Enterprise findEnterprise(String name){
        for (Enterprise e: this.getEnterpiseList()){
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;  
    } 
    
    public void deleteEnterprise(Enterprise e){
        enterpiseList.remove(e);
    }
         
        
    
}
