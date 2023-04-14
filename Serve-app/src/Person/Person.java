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
    String email;
    String emergencyContactName;
    String emergencyContactNumber;
    String occupation;
    String contactNum;

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

    public Person(String name, String id, String ssn, String address, UserAccount ua,
            Date dob, String email,String ecn, String ecname, String occ, String contactNum) {
        
        this.name = name;
        this.id = id;
        this.ssn = ssn;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.emergencyContactNumber = ecn;
        this.emergencyContactName = ecname;
        this.occupation = occ;
        this.contactNum = contactNum;
        this.useraccount = ua;
        
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

    public String getEmail() {
        return email;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
    
}
