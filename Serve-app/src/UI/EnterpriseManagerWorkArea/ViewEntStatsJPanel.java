/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.EnterpriseManagerWorkArea;
import UI.SystemAdminWorkArea.*;
import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Requests.ApplicationRequest;
import Requests.ConvenienceRequest;
import Requests.DeliveryRequest;
import Requests.Request;
import Requests.ServiceRequest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
public class ViewEntStatsJPanel extends javax.swing.JPanel {
    Network appSystem;     
    Enterprise ent;
    ArrayList<Organization> currOrgs;
    String entName;
    CategoryDataset cData;
    /**
     * Creates new form ViewStatsJPanel
     */
    public ViewEntStatsJPanel(Network appSystem, Enterprise ent) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.ent = ent;
        currOrgs = this.ent.getOrganizationDirectory().getOrganizationList();
        entName = this.ent.getName();
        jLabel1.setIcon(CreateEntepriseRequestsChart());
    }
    
    
    public int getOpenReqs(List<Request> entRequests, Organization o){
        int open_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                ServiceRequest sr = (ServiceRequest) r;
                if(!r.getStatus().equals("Completed") && sr.getServiceOrder().getOrg().equals(o)){
                    open_count++;
                }
            }
        }
        return open_count;
    }
    
    public int getConvOpenReqs(List<Request> entRequests, Organization o){
        int open_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                DeliveryRequest sr = (DeliveryRequest) r;
                if(!r.getStatus().equals("Completed") && sr.getOrderToBedelivered().getStore().equals(o)){
                    open_count++;
                }
            }
        }
        return open_count;
    }

    
    public int getClosedReqs(List<Request> entRequests, Organization o){
        int closed_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                ServiceRequest sr = (ServiceRequest) r;
                if(r.getStatus().equals("Completed") && sr.getServiceOrder().getOrg().equals(o)){
                    closed_count++;
                }
            }
        }
        return closed_count;
    }
    
    public int getConvClosedReqs(List<Request> entRequests, Organization o){
        int closed_count = 0;
        if(entRequests != null){
            for (Request r : entRequests){
                 DeliveryRequest sr = (DeliveryRequest) r;
                if(r.getStatus().equals("Completed") && sr.getOrderToBedelivered().getStore().equals(o)){
                    closed_count++;
                }
            }
        }
        return closed_count;
    }

    
    private CategoryDataset createEntepriseRequestsDataset( ){
        HashMap<String, List<Request>> allreqs = this.appSystem.getReqDir().getAllRequests();
        final String OpenReq = "Open";        
        final String CompletedReq = "Completed";        
        final String AllReq = "All";
        //Convenience
        if (this.ent.getName().equals("Convenience")){
            int phar1 = getConvClosedReqs(allreqs.get("Convenience delivery"), this.currOrgs.get(0));
            int phar2 = getConvOpenReqs(allreqs.get("Convenience delivery"), this.currOrgs.get(0));
            int phar3 = phar1 + phar2;
            
            int gro1 = getConvClosedReqs(allreqs.get("Convenience delivery"), this.currOrgs.get(1));
            int gro2 = getConvOpenReqs(allreqs.get("Convenience delivery"), this.currOrgs.get(1));
            int gro3 = gro1 + gro2;
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

            dataset.addValue( phar1 , this.currOrgs.get(0).getName() , CompletedReq ); 
            dataset.addValue( phar2 , this.currOrgs.get(0).getName() , OpenReq );        
            dataset.addValue( phar3 , this.currOrgs.get(0).getName() , AllReq );        

            dataset.addValue( gro1 , this.currOrgs.get(1).getName() , CompletedReq );        
            dataset.addValue( gro2 , this.currOrgs.get(1).getName() , OpenReq );       
            dataset.addValue( gro3 , this.currOrgs.get(1).getName() ,  AllReq);        

            return dataset; 
            
        //Health    
        } else if(ent.getName().equals("Health")){
            int hos = getClosedReqs(allreqs.get("Service requests"), this.currOrgs.get(0));
            int hoss = getOpenReqs(allreqs.get("Service requests"), this.currOrgs.get(0));
            int hosss = hos + hoss;
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

            dataset.addValue( hos , this.currOrgs.get(0).getName() , CompletedReq ); 
            dataset.addValue( hoss , this.currOrgs.get(0).getName() , OpenReq );        
            dataset.addValue( hosss , this.currOrgs.get(0).getName() , AllReq );        

            return dataset; 
        
        //Legal
        }else if (ent.getName().equals("Legal")){
            int hos = getClosedReqs(allreqs.get("Service requests"), this.currOrgs.get(0));
            int hoss = getOpenReqs(allreqs.get("Service requests"), this.currOrgs.get(0));
            int hosss = hos + hoss;
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

            dataset.addValue( hos , this.currOrgs.get(0).getName() , CompletedReq ); 
            dataset.addValue( hoss , this.currOrgs.get(0).getName() , OpenReq );        
            dataset.addValue( hosss , this.currOrgs.get(0).getName() , AllReq );        

            return dataset; 
        //Connection
        }else{
            int phar1 = getClosedReqs(allreqs.get("Convenience purchases"), this.currOrgs.get(0));
            int phar2 = getOpenReqs(allreqs.get("Convenience purchases"), this.currOrgs.get(0));
            int phar3 = phar1 + phar2;
            
            int gro1 = getClosedReqs(allreqs.get("Convenience purchases"), this.currOrgs.get(1));
            int gro2 = getOpenReqs(allreqs.get("Convenience purchases"), this.currOrgs.get(1));
            int gro3 = gro1 + gro2;
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

            dataset.addValue( phar1 , this.currOrgs.get(0).getName() , CompletedReq ); 
            dataset.addValue( phar2 , this.currOrgs.get(0).getName() , OpenReq );        
            dataset.addValue( phar3 , this.currOrgs.get(0).getName() , AllReq );        

            dataset.addValue( gro1 , this.currOrgs.get(1).getName() , CompletedReq );        
            dataset.addValue( gro2 , this.currOrgs.get(1).getName() , OpenReq );       
            dataset.addValue( gro3 , this.currOrgs.get(1).getName() ,  AllReq);        

            return dataset; 
        }
    }
    
    
   public ImageIcon CreateEntepriseRequestsChart(){
       JFreeChart barChart = ChartFactory.createBarChart(
         "Enterprise Requests by Organization",           
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
       
       if (this.ent.getName().equals("Convenience")){
           barChart = ChartFactory.createBarChart(
         "Delivery Requests by Organization",           
         "Request Status",            
         "Number of Requests",            
         createEntepriseRequestsDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
       barChart.setBackgroundPaint(Color.white);
       plot.getRangeAxis().setLowerBound(0);
       plot.getRangeAxis().setAutoRangeMinimumSize(WIDTH);
       chartimg = barChart.createBufferedImage(600, 500);
       }
       
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
