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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vraosharma
 */
public class HospitalMP extends javax.swing.JPanel {
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
    public HospitalMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
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
            ImageIcon icon = new ImageIcon(filepath);
            Image formattedImage = icon.getImage().getScaledInstance(25,7, Image.SCALE_SMOOTH);            
            cartImage1.setIcon(icon); 
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
                row[0] = p.getName();
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

        jLayeredPane2 = new javax.swing.JLayeredPane();
        cartImage1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pharmPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pharmCartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        productDets = new javax.swing.JPanel();
        pharQtySpinner = new javax.swing.JSpinner();
        productImage2 = new javax.swing.JLabel();
        productImage = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cartImage1.setText("cart");
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
        jLayeredPane2.add(cartImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 180, 60));

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hospital Services");

        jTable1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        jLayeredPane2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 750, 850));

        pharmPopup.setBackground(new java.awt.Color(102, 102, 102));
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

        add(jLayeredPane2, java.awt.BorderLayout.PAGE_START);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        this.currService = (Service) tModel.getValueAt(selRow, 0);
        serviceName.setText(currService.getName());
        aTime.setText(String.valueOf(currService.getAllottedTime()));
        catName.setText(currService.getCategory());
        desc.setText(currService.getDescription());

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartImage1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner pharQtySpinner;
    private javax.swing.JTable pharmCartTable;
    private javax.swing.JPanel pharmPopup;
    private javax.swing.JPanel productDets;
    private javax.swing.JLabel productImage;
    private javax.swing.JLabel productImage2;
    // End of variables declaration//GEN-END:variables
}
