/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;
import AppSystem.Network;
import Enterprise.Enterprise;
import Requests.ApplicationRequest;
import Requests.Request;
import Requests.ServiceRequest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
/**
 *
 * @author vraosharma
 */
public class ViewSystemStatsJPanel extends javax.swing.JPanel {
    Network appSystem;
    /**
     * Creates new form ViewStatsJPanel
     */
    public ViewSystemStatsJPanel(Network appSystem) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        jLabel1.setIcon(CreateEntepriseRequestsChart());
        jLabel2.setIcon(CreateApplicationChart());
    }
    
    public int getOpenReqs(List<Request> entRequests){
        int open_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                if(!r.getStatus().equals("Completed")){
                    open_count++;
                }
            }
        }
        return open_count;
    }
    
    public int getOpenReqs(List<Request> entRequests, Enterprise e){
        int open_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                ServiceRequest sr = (ServiceRequest) r;
                if(!r.getStatus().equals("Completed") && sr.getServiceOrder().getOrg().getE().equals(e)){
                    open_count++;
                }
            }
        }
        return open_count;
    }
    
    public int getOpenApplicationReqs(List<Request> entRequests, Enterprise e){
        int open_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                ApplicationRequest ar = (ApplicationRequest) r;
                if(!r.getStatus().equals("Completed") && ar.getForOrganization().getE().equals(e)){
                    open_count++;
                }
            }
        }
        return open_count;
    }
    
    
    public int getClosedReqs(List<Request> entRequests){
        int closed_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                if(r.getStatus().equals("Completed")){
                    closed_count++;
                }
            }
        }
        return closed_count;
    }
    
    public int getClosedReqs(List<Request> entRequests, Enterprise e){
        int closed_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                ServiceRequest sr = (ServiceRequest) r;
                if(r.getStatus().equals("Completed") && sr.getServiceOrder().getOrg().getE().equals(e)){
                    closed_count++;
                }
            }
        }
        return closed_count;
    }
    
    public int getClosedAppReqs(List<Request> entRequests, Enterprise e){
        int closed_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                 ApplicationRequest ar = (ApplicationRequest) r;
                if(r.getStatus().equals("Completed") && ar.getForOrganization().getE().equals(e)){
                    closed_count++;
                }
            }
        }
        return closed_count;
    }
    
    
    private CategoryDataset createEntepriseRequestsDataset( ) {
      final String ConvenienceEnt = "Convenience";
      Enterprise health = appSystem.getEnterprises().findEnterprise("Health");
      Enterprise conn = appSystem.getEnterprises().findEnterprise("Connection");
      Enterprise legal = appSystem.getEnterprises().findEnterprise("Legal");

      final String healthCol = "Health";
      final String legalCol = "Legal";
      final String connCol = "Connection";
      
      
      HashMap<String, List<Request>> allreqs = this.appSystem.getReqDir().getAllRequests();
//      System.out.println("UI.SystemAdminWorkArea.ViewSystemStatsJPanel.createDataset()" +allreqs.get("Service requests").size());

      
    // 1 = completed, 2 = open, 3 = all
      int h1 = getClosedReqs(allreqs.get("Service requests"), health);
      int h2 = getOpenReqs(allreqs.get("Service requests"), health);
      int h3 = h1 + h2;
      
      int cv1 = getClosedReqs(allreqs.get("Convenience delivery"));
      int cv2 = getOpenReqs(allreqs.get("Convenience delivery"));
      int cv3 = cv1 + cv2;
      
      int l1 = getClosedReqs(allreqs.get("Service requests"), legal);
      int l2 = getOpenReqs(allreqs.get("Service requests"),legal);
      int l3 = l1 + l2;
      
      int cn1 = getClosedReqs(allreqs.get("Service requests"), conn);
      int cn2 = getOpenReqs(allreqs.get("Service requests"), conn);
      int cn3 = cn1 + cn2;
      
      
      final String OpenReq = "Open";        
      final String CompletedReq = "Completed";        
      final String AllReq = "All";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( h1 , healthCol , CompletedReq ); 
      dataset.addValue( h2 , healthCol , OpenReq );        
      dataset.addValue( h3 , healthCol , AllReq );        

      dataset.addValue( cv1 , ConvenienceEnt , CompletedReq );        
      dataset.addValue( cv2 , ConvenienceEnt , OpenReq );       
      dataset.addValue( cv3 , ConvenienceEnt ,  AllReq);        

      dataset.addValue( l1 , legalCol , CompletedReq );        
      dataset.addValue( l2, legalCol ,  OpenReq);        
      dataset.addValue( l3 , legalCol ,  AllReq);        
      
      dataset.addValue( cn1 , connCol , CompletedReq );        
      dataset.addValue( cn2 , connCol , OpenReq );        
      dataset.addValue( cn3 , connCol , AllReq ); 
      
      return dataset; 
   }
    
    private CategoryDataset createApplicationRequestsDataset( ) {
      final String ConvenienceEnt = "Convenience";
      Enterprise health = appSystem.getEnterprises().findEnterprise("Health");
      Enterprise conn = appSystem.getEnterprises().findEnterprise("Connection");
      Enterprise legal = appSystem.getEnterprises().findEnterprise("Legal");

      final String client = "Client";
      final String deliveryVols = "Delivery Volunteers";
      final String doctor = "Health Specialist";
      final String lawyer = "Legal Specialist";
      final String connVol = "Connection Volunteer";
      

      
      
      HashMap<String, List<Request>> allreqs = this.appSystem.getReqDir().getAllRequests();

      
    // 1 = completed, 2 = open, 3 = all
      int cl1 = getClosedReqs(allreqs.get("Client Applications"));
      int cl2 = getOpenReqs(allreqs.get("Client Applications"));
      int cl3 = cl1 + cl2;
    
      int conDel1 = getClosedReqs(allreqs.get("Convenience Volunteers Applications"));
      int conDel2 = getOpenReqs(allreqs.get("Convenience Volunteers Applications"));
      int conDel3 = conDel1 + conDel2;
      
      int h1 = getClosedAppReqs(allreqs.get("Service Volunteers Applications"), health);
      int h2 = getOpenApplicationReqs(allreqs.get("Service Volunteers Applications"), health);
      int h3 = h1 + h2;
      
      int l1 = getClosedAppReqs(allreqs.get("Service Volunteers Applications"), legal);
      int l2 = getOpenApplicationReqs(allreqs.get("Service Volunteers Applications"),legal);
      int l3 = l1 + l2;
      
      int cn1 = getClosedAppReqs(allreqs.get("Service Volunteers Applications"), conn);
      int cn2 = getOpenApplicationReqs(allreqs.get("Service Volunteers Applications"), conn);
      int cn3 = cn1 + cn2;
      
      
      final String OpenReq = "Open";        
      final String CompletedReq = "Approved";        
      final String AllReq = "All";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( cl1 , client , CompletedReq ); 
      dataset.addValue( cl2 , client , OpenReq );        
      dataset.addValue( cl3 , client , AllReq ); 
      
      dataset.addValue( conDel1 , deliveryVols , CompletedReq ); 
      dataset.addValue( conDel2 , deliveryVols , OpenReq );        
      dataset.addValue( conDel3 , deliveryVols , AllReq );        

      dataset.addValue( h1 , doctor , CompletedReq );        
      dataset.addValue( h2 , doctor , OpenReq );       
      dataset.addValue( h3 , doctor ,  AllReq);        

      dataset.addValue( l1 , lawyer , CompletedReq );        
      dataset.addValue( l2, lawyer ,  OpenReq);        
      dataset.addValue( l3 , lawyer ,  AllReq);        
      
      dataset.addValue( cn1 , connVol , CompletedReq );        
      dataset.addValue( cn2 , connVol , OpenReq );        
      dataset.addValue( cn3 , connVol , AllReq ); 
      
      return dataset; 
   }
    
    
   public ImageIcon CreateEntepriseRequestsChart(){
       JFreeChart barChart = ChartFactory.createBarChart(
         "Network Requests by Enterprise",           
         "Request Status",            
         "Number of Requests",            
         createEntepriseRequestsDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
       barChart.setBackgroundPaint(Color.white);
       CategoryPlot plot = barChart.getCategoryPlot();
       plot.getRangeAxis().setLowerBound(0);
       plot.getRangeAxis().setAutoRangeMinimumSize(WIDTH);
       BufferedImage chartimg = barChart.createBufferedImage(600, 500);
       return new ImageIcon(chartimg);
   }
   
   public ImageIcon CreateApplicationChart(){
       JFreeChart barChart = ChartFactory.createBarChart(
         "Application Volume",           
         "Request Status",            
         "Number of Requests",            
         createApplicationRequestsDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
       barChart.setBackgroundPaint(Color.white);
       CategoryPlot plot = barChart.getCategoryPlot();
       plot.getRangeAxis().setLowerBound(0);
       plot.getRangeAxis().setAutoRangeMinimumSize(WIDTH);
       BufferedImage chartimg = barChart.createBufferedImage(600, 500);
       return new ImageIcon(chartimg);
   }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
