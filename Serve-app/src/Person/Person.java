/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person;

import UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author siqiyang
 */
public class Person {
    String name;
    String id;
    String ssn;
    String address;
    Date dob;
    UserAccount useraccount;

    public Person(){
        
    }
    

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        this.ssn = ssn;
        this.address = address;
        this.dob = dob;
        this.useraccount = useraccount;
    }

    public Person(String name, String id, String ssn, String address, Date dob, UserAccount useraccount) {
        this.name = name;
        this.id = id;
        this.ssn = ssn;
        this.address = address;
        this.dob = dob;
        this.useraccount = useraccount;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public UserAccount getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(UserAccount useraccount) {
        this.useraccount = useraccount;
    }


    

    
    
}
