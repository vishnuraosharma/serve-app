/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ClientWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductManagement.OrderItem;
import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductCart;
import Organization.ProductManagement.ProductCatalog;
import Organization.ProductOrganization;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceCatalog;
import Organization.ServiceManagement.ServicesCart;
import Organization.ServicesOrganization;
import Person.Client.Client;
import UserAccount.UserAccount;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vraosharma
 */
public class MyRequestsPanel extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    ServicesCart schoolCart ;
    DefaultTableModel prodReqModel;
    DefaultTableModel servReqModel;
    Client client;
    
    /**
     * Creates new form ConvenienceMP
     */
    public MyRequestsPanel(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
        servReqModel = (DefaultTableModel) servReqTable.getModel();
        prodReqModel = (DefaultTableModel) servReqTable.getModel();
    }
        
    public void populateCurrScoutCart(){
        servReqModel.setRowCount(0);
        ArrayList<Service> currServiceCart = this.schoolCart.getStagedServicesinCart();
        if(currServiceCart != null){
            int count = 0;
            int cartTotal = 0;
            for (Service s : currServiceCart){
                Object[] row = new Object[3];
                
                row[0] = count++;
                row[1] = s.getName();
                row[2] = s.getAllottedTime();
                cartTotal += s.getAllottedTime();
                
                servReqModel.addRow(row);
            }
            cartTotalLabel1.setText(displayHoursMinutes(cartTotal));
        }
        
    }
        public void populatePharmProducts(){
        prodReqModel.setRowCount(0);
        ProductCatalog catalog = this.pharmacyOrg.getProductCatalog();
        if(catalog != null & catalog.getAllProducts() != null){
            for (Product p : catalog.getAllProducts()){
                if(!p.isPrescriptionRequired() || this.client.getPerscribedMeds().contains(p)){
                    Object[] row = new Object[4];
                    row[0] = p;
                    row[1] = String.format("$%.2f",p.getPrice());
                    row[2] = p.getCategory();
                    row[3] = p.isPrescriptionRequired();
                    prodReqModel.addRow(row);
                }
            }
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        servReqTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        prodReqTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(236, 100, 44));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Krub", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1150, 800));
        jPanel2.setLayout(null);

        servReqTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        servReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Service Order", "Responsible Party", "Status", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        servReqTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servReqTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(servReqTable);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(220, 80, 669, 658);

        jLabel9.setBackground(new java.awt.Color(236, 100, 44));
        jLabel9.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 100, 44));
        jLabel9.setText("Service Requests");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(340, 10, 525, 64);

        jTabbedPane1.addTab("My Service Requests", jPanel2);

        jLabel10.setBackground(new java.awt.Color(236, 100, 44));
        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 100, 44));
        jLabel10.setText("Product Requests");
        jLayeredPane2.add(jLabel10);
        jLabel10.setBounds(360, 20, 475, 64);

        prodReqTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        prodReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Order Summary", "Order Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prodReqTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodReqTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(prodReqTable);

        jLayeredPane2.add(jScrollPane3);
        jScrollPane3.setBounds(180, 100, 770, 580);

        jTabbedPane1.addTab("My Product Requests", jLayeredPane2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void servReqTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servReqTableMouseClicked
        // TODO add your handling code here:
        int selRow = servReqTable.getSelectedRow();
        this.currServ1 = (Service) schoolProdModel.getValueAt(selRow, 0);

        try {
            BufferedImage bufferedImage = ImageIO.read(currServ1.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            productImage1.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_servReqTableMouseClicked

    private void prodReqTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodReqTableMouseClicked
        // TODO add your handling code here:
        int selRow = prodReqTable.getSelectedRow();
        this.currProduct = (Product) prodReqModel.getValueAt(selRow, 0);

        try {
            BufferedImage bufferedImage = ImageIO.read(currProduct.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            productImage.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prodReqTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable prodReqTable;
    private javax.swing.JTable servReqTable;
    // End of variables declaration//GEN-END:variables
}