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
public class ConnectionMP extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    
    ServicesOrganization schoolOrg;
    ServicesCart schoolCart ;
    DefaultTableModel schoolProdModel;
    DefaultTableModel schoolCartModel;
    
    ServicesOrganization scoutsOrg;
    ServicesCart scoutServCart;
    DefaultTableModel scoutsProdModel;
    DefaultTableModel scoutsCartModel;
    
    Client client;
    
    
    Service currServ1;
    ArrayList<String>  reqDetailsSchool;
    
    Service currServ2;
    ArrayList<String>  reqDetailsScouts;
    /**
     * Creates new form ConvenienceMP
     */
    public ConnectionMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
        
        System.out.println(useraccount.getPerson());
        
        //find pharmacy org, create product/cart table models, init new cart every time user shops convenience
        this.schoolOrg =(ServicesOrganization) appSystem.getEnterprises().findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("School");
        this.schoolProdModel = (DefaultTableModel) this.scouTable.getModel();
        this.schoolCartModel = (DefaultTableModel) this.scoutCartTable.getModel();
        this.schoolCart = new ServicesCart();
        
        this.scoutsOrg =(ServicesOrganization) appSystem.getEnterprises().findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("Community Organization");
        this.scoutsProdModel = (DefaultTableModel) this.stuTable.getModel();
        this.scoutsCartModel = (DefaultTableModel) this.stuCartTable.getModel();
        this.scoutServCart = new ServicesCart();
        
        reqDetailsSchool = new ArrayList<String>();
        reqDetailsScouts = new ArrayList<String>();
        
        pharmPopup.setVisible(false);
        schoolPopup.setVisible(false);
        
        
        
        populateCurrSchoolCart();
        populateSchoolServices();
        
        populateScoutServices();
        populateCurrScoutCart();
        addIcons();
        
    }
    
    public void addIcons(){
        String filepath = "src/Resources/cart.jpeg";
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filepath));
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            cartImage1.setIcon(icon);
            cartImage2.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void populateCurrSchoolCart(){
        schoolCartModel.setRowCount(0);
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
                
                schoolCartModel.addRow(row);
            }
            cartTotalLabel1.setText(displayHoursMinutes(cartTotal));
        }
        
    }
    
    public void populateSchoolServices(){
        schoolProdModel.setRowCount(0);
        ServiceCatalog catalog = this.schoolOrg.getServices();
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
                schoolProdModel.addRow(row);
            }
        }
    }
    
    public boolean validateSchoolService(Service s){
        if (currServ1 == null){
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
    
    public void populateCurrScoutCart(){
        schoolCartModel.setRowCount(0);
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
                
                schoolCartModel.addRow(row);
            }
            cartTotalLabel1.setText(displayHoursMinutes(cartTotal));
        }
        
    }
    
    public void populateScoutServices(){
        scoutsProdModel.setRowCount(0);
        ServiceCatalog catalog = this.scoutsOrg.getServices();
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
                scoutsProdModel.addRow(row);
            }
        }
    }
    
    public boolean validateScoutService(Service s){
        if (currServ1 == null){
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cartImage2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stuTable = new javax.swing.JTable();
        schoolPopup = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        stuCartTable = new javax.swing.JTable();
        cartTotalLabel1 = new javax.swing.JLabel();
        placeSchoolOrder = new javax.swing.JButton();
        clearSchoolCart = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        productDets1 = new javax.swing.JPanel();
        productImage1 = new javax.swing.JLabel();
        addSchoolServiceBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        reqDetailsTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        cartImage1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scouTable = new javax.swing.JTable();
        pharmPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        scoutCartTable = new javax.swing.JTable();
        cartTotalLabel = new javax.swing.JLabel();
        purchasePharProds = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        productDets = new javax.swing.JPanel();
        productImage = new javax.swing.JLabel();
        addPharmtoCart = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        reqDetailsTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(236, 100, 44));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Krub", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1150, 800));
        jPanel2.setLayout(null);

        cartImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartImage2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartImage2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartImage2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartImage2MouseReleased(evt);
            }
        });
        jPanel2.add(cartImage2);
        cartImage2.setBounds(1050, 10, 76, 61);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(236, 100, 44));
        jLabel9.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 100, 44));
        jLabel9.setText("Connect with Students");

        stuTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        stuTable.setModel(new javax.swing.table.DefaultTableModel(
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
        stuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stuTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stuTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(96, 96, 96))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 730, 820);

        schoolPopup.setBackground(new java.awt.Color(255, 255, 255));
        schoolPopup.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        schoolPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stuCartTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(stuCartTable);

        schoolPopup.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        cartTotalLabel1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        schoolPopup.add(cartTotalLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 60, 20));

        placeSchoolOrder.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        placeSchoolOrder.setText("Place Order");
        placeSchoolOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeSchoolOrderActionPerformed(evt);
            }
        });
        schoolPopup.add(placeSchoolOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        clearSchoolCart.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        clearSchoolCart.setText("Clear Cart");
        clearSchoolCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSchoolCartActionPerformed(evt);
            }
        });
        schoolPopup.add(clearSchoolCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel6.setText("Your Total");
        schoolPopup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jPanel2.add(schoolPopup);
        schoolPopup.setBounds(750, 60, 376, 362);

        productDets1.setBackground(new java.awt.Color(236, 100, 44));
        productDets1.setForeground(new java.awt.Color(236, 100, 44));
        productDets1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        productDets1.add(productImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 190));

        addSchoolServiceBTN.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        addSchoolServiceBTN.setText("Add Service");
        addSchoolServiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSchoolServiceBTNActionPerformed(evt);
            }
        });
        productDets1.add(addSchoolServiceBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        reqDetailsTextArea.setColumns(20);
        reqDetailsTextArea.setRows(5);
        jScrollPane4.setViewportView(reqDetailsTextArea);

        productDets1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 230, 60));

        jLabel7.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel7.setText("Service Request Details");
        productDets1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jPanel2.add(productDets1);
        productDets1.setBounds(780, 300, 328, 365);

        jTabbedPane1.addTab("Students", jPanel2);

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
        jLayeredPane2.add(cartImage1);
        cartImage1.setBounds(1070, 0, 76, 61);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(236, 100, 44));
        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 100, 44));
        jLabel10.setText("Connect with Scouts");

        scouTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        scouTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Allotted Time", "Service Category ", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scouTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scouTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(scouTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLayeredPane2.add(jPanel5);
        jPanel5.setBounds(0, 0, 740, 820);

        pharmPopup.setBackground(new java.awt.Color(255, 255, 255));
        pharmPopup.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pharmPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scoutCartTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(scoutCartTable);
        if (scoutCartTable.getColumnModel().getColumnCount() > 0) {
            scoutCartTable.getColumnModel().getColumn(1).setResizable(false);
        }

        pharmPopup.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        cartTotalLabel.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        pharmPopup.add(cartTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        purchasePharProds.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        purchasePharProds.setText("Place Order");
        purchasePharProds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasePharProdsActionPerformed(evt);
            }
        });
        pharmPopup.add(purchasePharProds, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        jButton7.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton7.setText("Clear Cart");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pharmPopup.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel4.setText("Your Total");
        pharmPopup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLayeredPane2.add(pharmPopup);
        pharmPopup.setBounds(770, 60, 376, 362);

        productDets.setBackground(new java.awt.Color(236, 100, 44));
        productDets.setForeground(new java.awt.Color(236, 100, 44));
        productDets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        productDets.add(productImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 170));

        addPharmtoCart.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        addPharmtoCart.setText("Add Service");
        addPharmtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPharmtoCartActionPerformed(evt);
            }
        });
        productDets.add(addPharmtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        reqDetailsTextArea1.setColumns(20);
        reqDetailsTextArea1.setRows(5);
        jScrollPane7.setViewportView(reqDetailsTextArea1);

        productDets.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel5.setText("Service Request Details");
        productDets.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLayeredPane2.add(productDets);
        productDets.setBounds(780, 230, 328, 365);

        jTabbedPane1.addTab("Scouts", jLayeredPane2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cartImage1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseReleased

    private void cartImage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MousePressed
        // TODO add your handling code here:
        if (!this.pharmPopup.isVisible()){
            this.pharmPopup.setVisible(true);
        } else {
            this.pharmPopup.setVisible(false);
        }
    }//GEN-LAST:event_cartImage1MousePressed

    private void cartImage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseExited

    private void cartImage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseEntered

    private void scouTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scouTableMouseClicked
        // TODO add your handling code here:
        int selRow = scouTable.getSelectedRow();
        this.currServ2 = (Service) scoutsProdModel.getValueAt(selRow, 0);
        
        try {
            BufferedImage bufferedImage = ImageIO.read(currServ2.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            productImage.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scouTableMouseClicked

    private void stuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuTableMouseClicked
        // TODO add your handling code here:
        int selRow = stuTable.getSelectedRow();
        this.currServ1 = (Service) schoolProdModel.getValueAt(selRow, 0);
        
        try {
            BufferedImage bufferedImage = ImageIO.read(currServ1.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            productImage1.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_stuTableMouseClicked

    private void addPharmtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPharmtoCartActionPerformed
        // TODO add your handling code here:
        if (validateScoutService(currServ2)){
            this.scoutServCart.addToCart(currServ2);
            reqDetailsScouts.add(reqDetailsTextArea1.getText());
            JOptionPane.showMessageDialog(null,"Service added to cart.");
        }
        populateCurrSchoolCart();
    }//GEN-LAST:event_addPharmtoCartActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here: clear phar cart
        ArrayList<Service> currOrderItems = this.scoutServCart.getStagedServicesinCart();
        if(currOrderItems != null){
            this.scoutServCart.emptyCart();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrScoutCart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void purchasePharProdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasePharProdsActionPerformed
        // TODO add your handling code here: place phar order
        ArrayList<Service> currOrderItems = this.scoutServCart.getStagedServicesinCart();
        if(currOrderItems != null){
            scoutServCart.processCart((Client) this.useraccount.getPerson(), this.scoutsOrg, reqDetailsScouts);
            for (Service s : currOrderItems){
                if(!this.client.getUnfulfilledServices().contains(s)){
                    this.client.getUnfulfilledServices().add(s);
                }
            }
            reqDetailsScouts = new ArrayList<String>();
            JOptionPane.showMessageDialog(null,"Your order has been placed.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add at least one service to cart to place an order.");
        }
        populateCurrScoutCart();
    }//GEN-LAST:event_purchasePharProdsActionPerformed

    private void cartImage2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cartImage2MouseEntered

    private void cartImage2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage2MouseExited

    private void cartImage2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MousePressed
        // TODO add your handling code here:
        if (!this.schoolPopup.isVisible()){
            this.schoolPopup.setVisible(true);
        } else {
            this.schoolPopup.setVisible(false);
        }
    }//GEN-LAST:event_cartImage2MousePressed

    private void cartImage2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage2MouseReleased

    private void placeSchoolOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeSchoolOrderActionPerformed
        // TODO add your handling code here: place order
        ArrayList<Service> currOrderItems = this.schoolCart.getStagedServicesinCart();
        if(currOrderItems != null){
            schoolCart.processCart((Client) this.useraccount.getPerson(), this.schoolOrg, reqDetailsSchool);
            for (Service s : currOrderItems){
                if(!this.client.getUnfulfilledServices().contains(s)){
                    this.client.getUnfulfilledServices().add(s);
                }
            }
            reqDetailsSchool = new ArrayList<String>();
            JOptionPane.showMessageDialog(null,"Your order has been placed.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add at least one service to cart to place an order.");
        }
        populateCurrSchoolCart();
    }//GEN-LAST:event_placeSchoolOrderActionPerformed

    private void clearSchoolCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSchoolCartActionPerformed
        // TODO add your handling code here: clear cart
        ArrayList<Service> currOrderItems = this.schoolCart.getStagedServicesinCart();
        if(currOrderItems != null){
            this.schoolCart.emptyCart();
            reqDetailsSchool = new ArrayList<String>();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrSchoolCart();
    }//GEN-LAST:event_clearSchoolCartActionPerformed

    private void addSchoolServiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSchoolServiceBTNActionPerformed
        // TODO add your handling code here:
        if (validateSchoolService(currServ1)){
            this.schoolCart.addToCart(currServ1);
            reqDetailsSchool.add(reqDetailsTextArea.getText());
            JOptionPane.showMessageDialog(null,"Service added to cart.");
        }
        populateCurrSchoolCart();
    }//GEN-LAST:event_addSchoolServiceBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPharmtoCart;
    private javax.swing.JButton addSchoolServiceBTN;
    private javax.swing.JLabel cartImage1;
    private javax.swing.JLabel cartImage2;
    private javax.swing.JLabel cartTotalLabel;
    private javax.swing.JLabel cartTotalLabel1;
    private javax.swing.JButton clearSchoolCart;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pharmPopup;
    private javax.swing.JButton placeSchoolOrder;
    private javax.swing.JPanel productDets;
    private javax.swing.JPanel productDets1;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productImage1;
    private javax.swing.JButton purchasePharProds;
    private javax.swing.JTextArea reqDetailsTextArea;
    private javax.swing.JTextArea reqDetailsTextArea1;
    private javax.swing.JPanel schoolPopup;
    private javax.swing.JTable scouTable;
    private javax.swing.JTable scoutCartTable;
    private javax.swing.JTable stuCartTable;
    private javax.swing.JTable stuTable;
    // End of variables declaration//GEN-END:variables
}
