/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Applicant;

import java.util.ArrayList;

/**
 *
 * @author siqiyang
 */
public class ApplicationDirectory {
    ArrayList<Application> applicationList;

    
    
    public Application createApplication(){
        Application a = new Application();
        
        
        
        return a;
    }
    
    public ApplicationDirectory() {
        this.applicationList = new ArrayList<Application>();
    }

    public ApplicationDirectory(ArrayList<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public ArrayList<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<Application> applicationList) {
        this.applicationList = applicationList;
    }


    
}
