/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserAccount;

import Organization.ServiceManagement.Order;
import Person.Person;
import WorkAreas.AbstractRole;

/**
 *
 * @author siqiyang
 */
public class UserAccount {
    private static int counter = 0;
    private String accountId;
    private String userName;
    private String password;
    private Person person;
    private AbstractRole role;

    public UserAccount(String accountId, String username, String password, Person person, AbstractRole role) {
        this.accountId = accountId;
        this.userName = username;
        this.password = password;
        this.person = person;
        this.role = role;
    }
    
    public UserAccount(String userName, String password, AbstractRole role) {
        this.accountId = "user" + this.counter++;
        this.userName = userName;
        this.password = password;
        this.person = null;
        this.role = role;
    }    

    


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AbstractRole getRole() {
        return role;
    }

    public void setRole(AbstractRole role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        UserAccount.counter = counter;
    }
    
    @Override
    public String toString() {
        return String.valueOf(accountId);
    } 

    public void addCustomerOrder(Order aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
