/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;
import AppSystem.Network;
import Enterprise.Enterprise;
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
public class ViewStatsJPanel extends javax.swing.JPanel {
    Network appSystem;
    /**
     * Creates new form ViewStatsJPanel
     */
    public ViewStatsJPanel(Network appSystem) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        jLabel1.setIcon(CreateChart());
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
    
    
    private CategoryDataset createDataset( ) {
      final String ConvenienceEnt = "Convenience";
      Enterprise health = appSystem.getEnterprises().findEnterprise("Health");
      Enterprise conn = appSystem.getEnterprises().findEnterprise("Connection");
      Enterprise legal = appSystem.getEnterprises().findEnterprise("Legal");

      final String healthCol = "Health";
      final String legalCol = "Legal";
      final String connCol = "Connection";
      
      
      HashMap<String, List<Request>> allreqs = this.appSystem.getReqDir().getAllRequests();
      System.out.println("UI.SystemAdminWorkArea.ViewStatsJPanel.createDataset()" +allreqs.get("Service requests").size());

      
    // 1 = completed, 2 = open, 3 = all
      int h1 = getClosedReqs(allreqs.get("Service requests"), health);
      int h2 = getOpenReqs(allreqs.get("Service requests"), health);
      int h3 = h1 + h2;
      
      int cv1 = getClosedReqs(allreqs.get("Convenience purchases"));
      int cv2 = getOpenReqs(allreqs.get("Convenience purchases"));
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
    
   public ImageIcon CreateChart(){
       JFreeChart barChart = ChartFactory.createBarChart(
         "Network Requests by Enterprise",           
         "Request Status",            
         "Number of Requests",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
       barChart.setBackgroundPaint(Color.white);
       CategoryPlot plot = barChart.getCategoryPlot();
       plot.getRangeAxis().setLowerBound(0);
       plot.getRangeAxis().setAutoRangeMinimumSize(WIDTH);
       BufferedImage chartimg = barChart.createBufferedImage(800, 550);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
