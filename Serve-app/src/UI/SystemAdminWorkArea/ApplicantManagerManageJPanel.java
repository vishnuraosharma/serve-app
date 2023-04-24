/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Person.Person;
import Person.PersonDirectory;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.ApplicationManagerRole;
import WorkAreas.ProductOrganizationManagerRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siqiyang
 */
public class ApplicantManagerManageJPanel extends javax.swing.JPanel {
    private UserAccount useraccount;
    private Network appSystem;
    Enterprise enterprise;
    Organization organization;
    DefaultTableModel viewtableModel;
    /**
     * Creates new form EmployeeManagementJPanel
     */
    public ApplicantManagerManageJPanel(Network appSystem,Enterprise enterprise, Organization organization, UserAccount useraccount) {
        initComponents();
        
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;        
        this.viewtableModel = (DefaultTableModel) jTable1.getModel();
        
        tablePopulate();
    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteApplicationManageBtn = new javax.swing.JButton();
        addApplicationManagerBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        updateApplicationManagerBtn = new javax.swing.JButton();
        updateNameField = new javax.swing.JTextField();
        updatePasswordTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1300, 800));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User ID", "Manager Name", "Username", "Password"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(236, 100, 44));
        jScrollPane2.setViewportView(jTable1);

        DeleteApplicationManageBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        DeleteApplicationManageBtn.setForeground(new java.awt.Color(236, 100, 44));
        DeleteApplicationManageBtn.setText("Delete Application Manager");
        DeleteApplicationManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteApplicationManageBtnActionPerformed(evt);
            }
        });

        addApplicationManagerBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        addApplicationManagerBtn.setForeground(new java.awt.Color(236, 100, 44));
        addApplicationManagerBtn.setText("Add Application Manager");
        addApplicationManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addApplicationManagerBtnActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(236, 100, 44));
        jLabel2.setText("Manager Name:");

        jLabel3.setForeground(new java.awt.Color(236, 100, 44));
        jLabel3.setText("User Name:");

        jLabel4.setForeground(new java.awt.Color(236, 100, 44));
        jLabel4.setText("Password:");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        updateApplicationManagerBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        updateApplicationManagerBtn.setForeground(new java.awt.Color(236, 100, 44));
        updateApplicationManagerBtn.setText("Update Application Manager");
        updateApplicationManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateApplicationManagerBtnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(236, 100, 44));
        jLabel5.setText("Update Manager Name:");

        jLabel6.setForeground(new java.awt.Color(236, 100, 44));
        jLabel6.setText("Update Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField)
                            .addComponent(usernameField)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addApplicationManagerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updatePasswordTextField)
                            .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteApplicationManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateApplicationManagerBtn))
                        .addGap(139, 139, 139)))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(addApplicationManagerBtn)
                        .addGap(390, 390, 390))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addComponent(updateApplicationManagerBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteApplicationManageBtn)
                        .addGap(244, 244, 244))))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validate_additonfields(){
        if(nameField.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter a name.");
            return false;
        }if(usernameField.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter a username.");
            return false;
        }if(passwordField.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter a password.");
            return false;
        }
        
        return true;
    }
    
    
    private void addApplicationManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addApplicationManagerBtnActionPerformed
        // TODO add your handling code here:
        if (validate_additonfields()){
            Boolean foundDuplicate = false;

            for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()){
                UserAccountDirectory ua = enterprise.getUseraccountDirectory();

                if(ua.accountExists(usernameField.getText(), passwordField.getText())) {
                    foundDuplicate = true;
                    JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
                    break;
                }

            }
            UserAccountDirectory ua = this.appSystem.getTopLevelUserAccountDirectory();
            if(ua.accountExists(usernameField.getText(), passwordField.getText())) {
                foundDuplicate = true;
                JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
            }
            if(foundDuplicate == false){
                    Person p = appSystem.getPersonDirectory().createPerson( nameField.getText());
                    UserAccount applicationManager =appSystem.getTopLevelUserAccountDirectory().createUserAccount(usernameField.getText(), passwordField.getText(), new ApplicationManagerRole());
                    applicationManager.setPerson(p);
                    JOptionPane.showMessageDialog(null, "Application Manager created");
                }else{
                    JOptionPane.showMessageDialog(null, "Application Manager exists");
                }

                tablePopulate();
        }
        
    }//GEN-LAST:event_addApplicationManagerBtnActionPerformed

    private void DeleteApplicationManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteApplicationManageBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select an Application Manager to delete.");
        }else{
        UserAccount u = (UserAccount) jTable1.getValueAt(selectedRow, 0);
        this.appSystem.getTopLevelUserAccountDirectory().deleteApplicationManager(u);
        if (this.appSystem.getTopLevelUserAccountDirectory().getUserAccountList().size()>0){
            tablePopulate();
        }else{
            viewtableModel.setRowCount(0);
        }
        }
    }//GEN-LAST:event_DeleteApplicationManageBtnActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void updateApplicationManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateApplicationManagerBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
        UserAccount u = (UserAccount) jTable1.getValueAt(selectedRow, 0);
        u.getPerson().setName(updateNameField.getText());
        u.setPassword(updatePasswordTextField.getText());

        tablePopulate();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Application Manager to update.");
        }
    }//GEN-LAST:event_updateApplicationManagerBtnActionPerformed
    public void  tablePopulate() {
        ArrayList<UserAccount> userAccount = this.appSystem.getTopLevelUserAccountDirectory().getUserAccountList();
        
        if(userAccount.size()>0){
            viewtableModel.setRowCount(0);
                for(UserAccount u: appSystem.getTopLevelUserAccountDirectory().getUserAccountList()){
                    if(u.getRole().getRoleType().equals("Application Manager")){
                        Object row[] = new Object[4];
                        row[0] =u;
                        row[1] = u.getPerson().getName();
                        row[2] = u.getUserName();
                        row[3] = u.getPassword();


                        viewtableModel.addRow(row);
                    }
                }       
        } else {
            System.out.print("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteApplicationManageBtn;
    private javax.swing.JButton addApplicationManagerBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton updateApplicationManagerBtn;
    private javax.swing.JTextField updateNameField;
    private javax.swing.JTextField updatePasswordTextField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}