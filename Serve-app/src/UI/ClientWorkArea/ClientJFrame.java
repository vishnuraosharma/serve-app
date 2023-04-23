/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.ClientWorkArea;

import UI.OrganizationManagerWorkArea.Product.*;
import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductOrganization;
import UI.MainJFrame;
import UserAccount.UserAccount;

/**
 *
 * @author vraosharma
 */
public class ClientJFrame extends javax.swing.JFrame {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
    /**
     * Creates new form OrganizationManagerJFrame
     */
    public ClientJFrame() {
        this.setLocationRelativeTo(null);
        initComponents();
        this.setVisible(true);
    }
    
    public ClientJFrame(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
        appSystem.addIcon(0, jLabel5);
        
        displayLoginInfo();
    }
    public void displayLoginInfo(){
        jLabel1.setText(String.valueOf(this.useraccount.getPerson().getName()));
        jLabel4.setText(String.valueOf(this.useraccount.getPerson().getId()));

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        productCatalogBtn = new javax.swing.JButton();
        productReportBtn = new javax.swing.JButton();
        productReportBtn1 = new javax.swing.JButton();
        productReportBtn2 = new javax.swing.JButton();
        productReportBtn3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 800));
        jPanel1.setSize(new java.awt.Dimension(150, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(236, 100, 44));
        jLabel4.setText("jLabel1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 90, -1));

        jLabel1.setForeground(new java.awt.Color(236, 100, 44));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 90, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 100, 44));
        jLabel2.setText("Welcome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 90, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 100, 44));
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, -1));

        backBtn.setBackground(new java.awt.Color(236, 100, 44));
        backBtn.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("LOGOUT");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 40));

        productCatalogBtn.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productCatalogBtn.setForeground(new java.awt.Color(236, 100, 44));
        productCatalogBtn.setText("Convenience");
        productCatalogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCatalogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(productCatalogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        productReportBtn.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productReportBtn.setForeground(new java.awt.Color(236, 100, 44));
        productReportBtn.setText("Legal");
        productReportBtn.setPreferredSize(new java.awt.Dimension(120, 23));
        productReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtnActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, -1));

        productReportBtn1.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productReportBtn1.setForeground(new java.awt.Color(236, 100, 44));
        productReportBtn1.setText("Health");
        productReportBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        productReportBtn2.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productReportBtn2.setForeground(new java.awt.Color(236, 100, 44));
        productReportBtn2.setText("Connection");
        productReportBtn2.setPreferredSize(new java.awt.Dimension(120, 23));
        productReportBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        productReportBtn3.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productReportBtn3.setForeground(new java.awt.Color(236, 100, 44));
        productReportBtn3.setText("My Requests");
        productReportBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 130, -1));

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1150, 800));
        jPanel2.setSize(new java.awt.Dimension(1150, 800));
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.setLayout(null);

        jLabel5.setSize(new java.awt.Dimension(558, 376));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(290, 230, 558, 376);

        jLabel8.setBackground(new java.awt.Color(236, 100, 44));
        jLabel8.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 100, 44));
        jLabel8.setText("Building stronger communities for seniors.");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(90, 120, 1170, 70);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainJFrame(appSystem, enterprise,organization,useraccount);
    }//GEN-LAST:event_backBtnActionPerformed

    private void productCatalogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCatalogBtnActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new ConvenienceMP(appSystem, enterprise,organization,useraccount));
            
    }//GEN-LAST:event_productCatalogBtnActionPerformed

    private void productReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtnActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new LegalMP(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_productReportBtnActionPerformed

    private void productReportBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn1ActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new HospitalMP(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_productReportBtn1ActionPerformed

    private void productReportBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn2ActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new ConnectionMP(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_productReportBtn2ActionPerformed

    private void productReportBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn3ActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new MyRequestsPanel(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_productReportBtn3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ProductOrganizationManagerJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton productCatalogBtn;
    private javax.swing.JButton productReportBtn;
    private javax.swing.JButton productReportBtn1;
    private javax.swing.JButton productReportBtn2;
    private javax.swing.JButton productReportBtn3;
    // End of variables declaration//GEN-END:variables
}
