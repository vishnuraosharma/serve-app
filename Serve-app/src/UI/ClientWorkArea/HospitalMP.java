/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ClientWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceCatalog;
import Organization.ServiceManagement.ServicesCart;
import Organization.ServicesOrganization;
import Person.Client.Client;
import UserAccount.UserAccount;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ImageView;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.text.Element;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vraosharma
 */
public class HospitalMP extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    ServicesOrganization hospOrg;
    ServicesCart hospCart;
    DefaultTableModel hosServModel;
    DefaultTableModel hosCartModel;
    
    Client client;
    ArrayList<Service> unfulfilledServices;
    
    DefaultTableModel groProductModel;
    Service currService;
    /**
     * Creates new form ConvenienceMP
     */
    public HospitalMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
       
        //find pharmacy org, create product/cart table models, init new cart every time user shops convenience
        this.hospOrg =(ServicesOrganization) appSystem.getEnterprises().findEnterprise("Health").getOrganizationDirectory().findOrganizationbyType("Hospital");
        this.hosServModel = (DefaultTableModel) this.hosServicesTable.getModel();
        this.hosCartModel = (DefaultTableModel) this.hosCartTable.getModel();
        this.hospCart = new ServicesCart();
        
        hospCartPopup.setVisible(false);
        
        populateHospServices();
        populateCurrHospCart();
        addIcons();
        
    }
    
    public void addIcons(){
        String filepath = "/Users/vraosharma/Desktop/Java/AED/serve-app/Resources/cart.jpeg";
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filepath));
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            cartImage1.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    public void populateCurrHospCart(){
        hosCartModel.setRowCount(0);
        ArrayList<Service> currServiceCart = this.hospCart.getStagedServicesinCart();
        if(currServiceCart != null){
            int count = 0;
            int cartTotal = 0;
            for (Service s : currServiceCart){
                Object[] row = new Object[3];
                
                row[0] = count++;
                row[1] = s.getName();
                row[2] = s.getAllottedTime();
                cartTotal += s.getAllottedTime();
                
                hosCartModel.addRow(row);
            }
            cartTotalLabel.setText(displayHoursMinutes(cartTotal));
        }
        
    }
    
    public String displayHoursMinutes(int minutes) {
            int hours = minutes / 60;
            minutes = minutes % 60;
            if (hours == 1) {
                return String.format("%d hour %d minutes", hours, minutes);
            } else {
                return String.format("%d hours %d minutes", hours, minutes);
            }
        }
    
    public void populateHospServices(){
        hosServModel.setRowCount(0);
        ServiceCatalog catalog = this.hospOrg.getServices();
        if(catalog != null & catalog.getAllServices()!= null){
            for (Service s : catalog.getAllServices()){
                Object[] row = new Object[4];
                row[0] = s;
                if (s.getAllottedTime() == 1) {
                row[1] =  String.format("%d minute", s.getAllottedTime());
                 } else {
                row[1] =  String.format("%d minutes", s.getAllottedTime());
                 }
                row[2] = s.getCategory();
                row[3] = s.getDescription();
                hosServModel.addRow(row);
            }
        }
    }
    
    public boolean validateService(Service s){
        if (currService == null){
            JOptionPane.showMessageDialog(null,"Please select a service.");
            return false;
        }
        if (this.client.getUnfulfilledServices().contains(s)){
            JOptionPane.showMessageDialog(null,"You have already requested this service. Please wait until your existing request is fulfilled before requesting another.");
            return false;
        }
        
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        cartImage1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hosServicesTable = new javax.swing.JTable();
        hospCartPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        hosCartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cartTotalLabel = new javax.swing.JLabel();
        productDets = new javax.swing.JPanel();
        serviceName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cartImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartImage1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartImage1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartImage1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartImage1MouseReleased(evt);
            }
        });
        jLayeredPane2.add(cartImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 76, 61));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hospital Services");

        hosServicesTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        hosServicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Allotted Time", "Service Category", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hosServicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hosServicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hosServicesTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(172, 172, 172))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(805, 805, 805))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        jLayeredPane2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 850));

        hospCartPopup.setBackground(new java.awt.Color(255, 255, 255));
        hospCartPopup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        hospCartPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hosCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line Item", "Service Name", "Minutes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(hosCartTable);
        if (hosCartTable.getColumnModel().getColumnCount() > 0) {
            hosCartTable.getColumnModel().getColumn(2).setResizable(false);
        }

        hospCartPopup.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        jLabel3.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel3.setText("Your Total");
        hospCartPopup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jButton6.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton6.setText("Place Order");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        hospCartPopup.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 110, -1));

        jButton7.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton7.setText("Clear Cart");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        hospCartPopup.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        cartTotalLabel.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        cartTotalLabel.setText("cartTotal");
        hospCartPopup.add(cartTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLayeredPane2.add(hospCartPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, 376, 362));

        productDets.setBackground(new java.awt.Color(255, 255, 255));
        productDets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serviceName.setText("Product Image");
        productDets.add(serviceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jButton2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton2.setText("Add Service");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        productDets.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLayeredPane2.add(productDets, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 328, 365));

        add(jLayeredPane2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void cartImage1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseReleased

    private void cartImage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MousePressed
        // TODO add your handling code here:
        if (!this.hospCartPopup.isVisible()){
            this.hospCartPopup.setVisible(true);
        } else {
            this.hospCartPopup.setVisible(false);
        }
    }//GEN-LAST:event_cartImage1MousePressed

    private void cartImage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseExited

    private void cartImage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (validateService(currService)){
            this.hospCart.addToCart(currService);
            JOptionPane.showMessageDialog(null,"Service added to cart.");
        } 
        populateCurrHospCart();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ArrayList<Service> currOrderItems = this.hospCart.getStagedServicesinCart();
        if(currOrderItems != null){
            this.hospCart.emptyCart();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrHospCart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ArrayList<Service> currOrderItems = this.hospCart.getStagedServicesinCart();
        if(currOrderItems != null){
            hospCart.processCart((Client) this.useraccount.getPerson(), this.hospOrg);
            for (Service s : currOrderItems){
                this.client.getUnfulfilledServices().add(s);
            }
            JOptionPane.showMessageDialog(null,"Your order has been placed.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add at least one service to cart to place an order.");
        }
        populateCurrHospCart();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void hosServicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hosServicesTableMouseClicked
        // TODO add your handling code here:
        int selRow = hosServicesTable.getSelectedRow();
        this.currService = (Service) hosServModel.getValueAt(selRow, 0);
        try {
            BufferedImage bufferedImage = ImageIO.read(currService.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            serviceName.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_hosServicesTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartImage1;
    private javax.swing.JLabel cartTotalLabel;
    private javax.swing.JTable hosCartTable;
    private javax.swing.JTable hosServicesTable;
    private javax.swing.JPanel hospCartPopup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel productDets;
    private javax.swing.JLabel serviceName;
    // End of variables declaration//GEN-END:variables
}
