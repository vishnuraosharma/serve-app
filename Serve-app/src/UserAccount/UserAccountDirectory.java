/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserAccount;

import WorkAreas.AbstractRole;
import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class UserAccountDirectory {
    ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccountDirectory() {
        this.userAccountList = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccount createUserAccount(String name, String password, AbstractRole role) {
        UserAccount user = new UserAccount(name, password, role);
        this.userAccountList.add(user);
        return user;
    }    
    
    public UserAccount authenticateUser(String name, String password) {
        for(UserAccount ua: this.userAccountList) {
            if(ua.getUserName().equals(name) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }    
    public UserAccount findById(String id) {
        for(UserAccount u: this.userAccountList) {
            if(u.getAccountId().equals(id)) {
                return u;
            }
        }
        
        return null;
    }
    public UserAccount getUserAccount(String username, String password, AbstractRole role) {
        for(UserAccount u: this.userAccountList) {
            if(u.getUserName().equals(username) && u.getPassword().equals(password) && u.getRole().equals(role)) {
                return u;
            }
        }
        
        return null;
    }
    
    public Boolean accountExists(String username, String password) {
        for(UserAccount u: this.getUserAccountList()) {
            if(u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    } 
    
    public void deleteEnterpriseManager(UserAccount u){
        this.userAccountList.remove(u);
    }
}
