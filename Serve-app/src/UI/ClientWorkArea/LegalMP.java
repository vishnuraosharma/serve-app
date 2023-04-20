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
public class LegalMP extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    ServicesOrganization lawOrg;
    ServicesCart lawCart;
    DefaultTableModel lawServModel;
    DefaultTableModel lawCartModel;
    
    Client client;
    ArrayList<Service> unfulfilledServices;
    
    Service currService;
    
    ArrayList<String> reqDetails;
    
    
    /**
     * Creates new form ConvenienceMP
     */
    public LegalMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
       
        //find pharmacy org, create product/cart table models, init new cart every time user shops convenience
        this.lawOrg =(ServicesOrganization) appSystem.getEnterprises().findEnterprise("Legal").getOrganizationDirectory().findOrganizationbyType("Law Office");
        this.lawServModel = (DefaultTableModel) this.lawServicesTable.getModel();
        this.lawCartModel = (DefaultTableModel) this.lawCartTable.getModel();
        this.lawCart = new ServicesCart();
        
        hospCartPopup.setVisible(false);
        reqDetails = new ArrayList<String>();
        
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
            Logger.getLogger(LegalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    public void populateCurrHospCart(){
        lawCartModel.setRowCount(0);
        ArrayList<Service> currServiceCart = this.lawCart.getStagedServicesinCart();
        if(currServiceCart != null){
            int count = 0;
            int cartTotal = 0;
            for (Service s : currServiceCart){
                Object[] row = new Object[3];
                
                row[0] = count++;
                row[1] = s.getName();
                row[2] = s.getAllottedTime();
                cartTotal += s.getAllottedTime();
                
                lawCartModel.addRow(row);
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
        lawServModel.setRowCount(0);
        ServiceCatalog catalog = this.lawOrg.getServices();
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
                lawServModel.addRow(row);
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
        if(reqDetailsTextArea.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Please enter any helpful details so a volunteer can be of better assistance.");

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
        hospCartPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lawCartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cartTotalLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cartImage1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lawServicesTable = new javax.swing.JTable();
        productDets = new javax.swing.JPanel();
        serviceName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reqDetailsTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLayeredPane2.setBackground(new java.awt.Color(255, 118, 0));
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(1150, 800));

        hospCartPopup.setBackground(new java.awt.Color(255, 255, 255));
        hospCartPopup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        hospCartPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lawCartTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(lawCartTable);
        if (lawCartTable.getColumnModel().getColumnCount() > 0) {
            lawCartTable.getColumnModel().getColumn(2).setResizable(false);
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

        jLayeredPane2.add(hospCartPopup);
        hospCartPopup.setBounds(760, 70, 376, 362);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 118, 0));

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

        jLabel10.setBackground(new java.awt.Color(255, 118, 0));
        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 118, 0));
        jLabel10.setText("Meet a Legal Specialist");

        lawServicesTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        lawServicesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        lawServicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lawServicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lawServicesTable);

        productDets.setBackground(new java.awt.Color(255, 255, 255));
        productDets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        productDets.add(serviceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 100));

        jButton2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton2.setText("Add Service");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        productDets.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        reqDetailsTextArea.setColumns(20);
        reqDetailsTextArea.setRows(5);
        jScrollPane2.setViewportView(reqDetailsTextArea);

        productDets.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel4.setText("Service Request Details");
        productDets.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(782, Short.MAX_VALUE)
                .addComponent(productDets, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(207, 207, 207)
                .addComponent(productDets, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );

        jLayeredPane2.add(jPanel5);
        jPanel5.setBounds(0, 0, 1190, 820);

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
            this.lawCart.addToCart(currService);
            reqDetails.add(reqDetailsTextArea.getText());
            JOptionPane.showMessageDialog(null,"Service added to cart.");
        } 
        populateCurrHospCart();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ArrayList<Service> currOrderItems = this.lawCart.getStagedServicesinCart();
        if(currOrderItems != null){
            this.lawCart.emptyCart();
            reqDetails = new ArrayList<String>();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrHospCart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ArrayList<Service> currOrderItems = this.lawCart.getStagedServicesinCart();
        if(currOrderItems != null){
            lawCart.processCart((Client) this.useraccount.getPerson(), this.lawOrg, reqDetails);
            for (Service s : currOrderItems){
                if(!this.client.getUnfulfilledServices().contains(s)){
                    this.client.getUnfulfilledServices().add(s);
                }
            }
            reqDetails = new ArrayList<String>();
            JOptionPane.showMessageDialog(null,"Your order has been placed.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add at least one service to cart to place an order.");
        }
        populateCurrHospCart();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lawServicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lawServicesTableMouseClicked
        // TODO add your handling code here:
        int selRow = lawServicesTable.getSelectedRow();
        this.currService = (Service) lawServModel.getValueAt(selRow, 0);
        try {
            BufferedImage bufferedImage = ImageIO.read(currService.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            serviceName.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(LegalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_lawServicesTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartImage1;
    private javax.swing.JLabel cartTotalLabel;
    private javax.swing.JPanel hospCartPopup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable lawCartTable;
    private javax.swing.JTable lawServicesTable;
    private javax.swing.JPanel productDets;
    private javax.swing.JTextArea reqDetailsTextArea;
    private javax.swing.JLabel serviceName;
    // End of variables declaration//GEN-END:variables
}
