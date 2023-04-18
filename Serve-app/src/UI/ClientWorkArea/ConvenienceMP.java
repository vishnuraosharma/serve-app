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
public class ConvenienceMP extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    
    ProductOrganization pharmacyOrg;
    ProductCart pharmCart;
    DefaultTableModel pharProdModel;
    DefaultTableModel pharCartModel;
    
    ProductOrganization grocery;
    ProductCart groCart;
    
    
    Client client;
    
    
    DefaultTableModel groProductModel;
    Product currProduct;
    /**
     * Creates new form ConvenienceMP
     */
    public ConvenienceMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
        
        System.out.println(useraccount.getPerson());
        
        //find pharmacy org, create product/cart table models, init new cart every time user shops convenience
        this.pharmacyOrg =(ProductOrganization) appSystem.getEnterprises().findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy");
        this.pharProdModel = (DefaultTableModel) this.pharTable.getModel();
        this.pharCartModel = (DefaultTableModel) this.pharmCartTable.getModel();
        this.pharmCart = new ProductCart();
        
        this.grocery =(ProductOrganization) appSystem.getEnterprises().findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store");
        
        pharmPopup.setVisible(false);
        
        
        
        
        this.groProductModel = (DefaultTableModel) this.jTable2.getModel();
        populatePharmProducts();
        populateCurrPharmCart();
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
    
    public void populateCurrPharmCart(){
        pharCartModel.setRowCount(0);
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            int count = 0;
            double cartTotal = 0;
            for (OrderItem oi : currOrderItems){
                Object[] row = new Object[5];
                
                row[0] = count++;
                row[1] = oi.getSelectedProduct();
                row[2] = oi.getQuantity();
                row[3] = String.format("$%.2f",oi.getOrderItemRevenue());
                cartTotal += oi.getOrderItemRevenue();
                
                pharCartModel.addRow(row);
            }
            jLabel3.setText(String.format("$%.2f",cartTotal));
        }
        
    }
    
    public void populatePharmProducts(){
        pharProdModel.setRowCount(0);
        ProductCatalog catalog = this.pharmacyOrg.getProductCatalog();
        if(catalog != null & catalog.getAllProducts() != null){
            for (Product p : catalog.getAllProducts()){
                Object[] row = new Object[4];
                row[0] = p;
                row[1] = String.format("$%.2f",p.getPrice());
                row[2] = p.getCategory();
                row[3] = p.isPrescriptionRequired();
                pharProdModel.addRow(row);
            }
        }
    }
    
    public boolean validateOrderItem(){
        try{
            int qty = Integer.parseInt(String.valueOf(pharQtySpinner.getValue()));
        
            if(qty <1){
                JOptionPane.showMessageDialog(null,"Please set qty. to be greater than 0.");
                return false;
            }
            }catch (NumberFormatException e){
                return false;
        }
        if (currProduct == null){
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
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        cartImage1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pharTable = new javax.swing.JTable();
        pharmPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pharmCartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        productDets = new javax.swing.JPanel();
        pharQtySpinner = new javax.swing.JSpinner();
        productImage2 = new javax.swing.JLabel();
        productImage = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Krub", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        jLabel9.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grocery Products");

        jTable2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Price", "Product Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(169, 169, 169))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1461, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(667, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grocery", jPanel2);

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
        jLayeredPane2.add(cartImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 76, 61));

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pharmacy Products");

        pharTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        pharTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Price", "Product Category", "Prescription Required?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pharTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pharTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel10)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        jLayeredPane2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 750, 850));

        pharmPopup.setBackground(new java.awt.Color(255, 255, 255));
        pharmPopup.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pharmPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line Item", "Product Name", "Quantity", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(pharmCartTable);

        pharmPopup.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        jLabel3.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jLabel3.setText("cartTotal");
        pharmPopup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jButton6.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton6.setText("Place Order");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pharmPopup.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

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

        jLayeredPane2.add(pharmPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 376, 362));

        productDets.setBackground(new java.awt.Color(255, 255, 255));
        productDets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharQtySpinner.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        pharQtySpinner.setToolTipText("");
        productDets.add(pharQtySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        productImage2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productImage2.setText("Quantity");
        productDets.add(productImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        productImage.setText("Product Image");
        productDets.add(productImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jButton2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jButton2.setText("Add to Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        productDets.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLayeredPane2.add(productDets, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 328, 365));

        jTabbedPane1.addTab("Pharmacy", jLayeredPane2);

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

    private void pharTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharTableMouseClicked
        // TODO add your handling code here:
        int selRow = pharTable.getSelectedRow();
        this.currProduct = (Product) pharProdModel.getValueAt(selRow, 0);
        
        try {
            BufferedImage bufferedImage = ImageIO.read(currProduct.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            productImage.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pharTableMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (validateOrderItem()){
            this.pharmCart.addToCart(currProduct, (int) pharQtySpinner.getValue());
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            this.pharmCart.emptyCart();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            pharmCart.processCart((Client) this.useraccount.getPerson(), this.pharmacyOrg);
            JOptionPane.showMessageDialog(null,"Your order has been placed.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add products to cart to place order.");
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartImage1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JSpinner pharQtySpinner;
    private javax.swing.JTable pharTable;
    private javax.swing.JTable pharmCartTable;
    private javax.swing.JPanel pharmPopup;
    private javax.swing.JPanel productDets;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productImage2;
    // End of variables declaration//GEN-END:variables
}
