/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;

import java.util.ArrayList;

/**
 *
 * @author vishnu rao-sharma
 */
public class ServiceCatalog {
    ArrayList<Service> allServices;
    ArrayList<ServiceSummary> servicesReport;
    
    public ServiceCatalog(){
        allServices = new ArrayList<>();
        servicesReport = new ArrayList<>();
        
    }
    
    public Service newService(String n, int t, String category,String desc){
        Service serv = new Service(n, t, category, category,desc);
        this.allServices.add(serv); 
        return serv;
    }
    
    public Service removeService(Service s){
        this.allServices.remove(s);
        return s;
    }
    
    public ArrayList<ServiceSummary> generateServiceReport(){
        for (Service s : allServices){
            ServiceSummary ss = new ServiceSummary(s);
            servicesReport.add(ss);
        }
        return this.servicesReport;
    }

    public ArrayList<Service> getAllServices() {
        return allServices;
    }

    public void setAllServices(ArrayList<Service> allServices) {
        this.allServices = allServices;
    }

    public ArrayList<ServiceSummary> getServicesReport() {
        return servicesReport;
    }

    public void setProductReport(ArrayList<ServiceSummary> servicesReport) {
        this.servicesReport = servicesReport;
    }
    
    
}
