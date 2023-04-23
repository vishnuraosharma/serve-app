/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.OrganizationManagerWorkArea.Services;

import AppSystem.Network;
import Applicant.Application;
import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ServicesOrganization;
import Person.Person;
import Person.PersonDirectory;
import Requests.ApplicationRequest;
import Requests.RequestDirectory;
import UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author khatna
 */
public class ManageApplicationsJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form ManageApplications
     */
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
     public ManageApplicationsJPanel( Network appSystem,UserAccount useraccount, Enterprise enterprise, Organization organization) {
        initComponents();
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
    }

    public ManageApplicationsJPanel(Network appSystem, Enterprise enterprise, ServicesOrganization organization, UserAccount useraccount) {
        initComponents();
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
    }
    public boolean validate_fields(){
        String name = nameField.getText();
        String ssn = ssnField.getText();
        String address = addressField.getText();
        Date dob = dobChooser.getDate();
        String email = emailField.getText();
        String ecname = ecNameField.getText();
        String ecnum  = ecNumberField.getText();
        String occ = occField.getText();
        String conNum = contactNumField.getText();
        String username = userNameField.getText();
        String password = passwordField.getText();

        if(name.equals("")||ssn.equals("")||address.equals("")||dob==null|| 
                email.equals("")||ecname.equals("")||ecnum.equals("")||
                occ.equals("")||conNum.equals("")||username.equals("")||
                password.equals("")){
            
            JOptionPane.showMessageDialog(null, "Please fill all fields");  
            return false;
        }
        if(email.isBlank() || !(email.contains("@")) || !(email.contains(".")) || 
                (email.indexOf("@") > email.indexOf(".")) || 
                !(email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com+$"))){
                JOptionPane.showMessageDialog(null, "Please enter a valid Email Address\nHint: Use the emailname@domain.com format", "Warning",JOptionPane.WARNING_MESSAGE);
                return false;
        }
        
        else if(ecnum.isBlank() || (ecnum.length() != 10) || !ecnum.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit Emergency Contact phone number", "Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if ((ssn.length() != 9) || !ssn.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid 9 digit social security number", "Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(conNum.isBlank() || (conNum.length() != 10) || !conNum.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit Contact phone number", "Warning",JOptionPane.WARNING_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ssnField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ecNameField = new javax.swing.JTextField();
        ecNumberField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        occField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        sendAppBtn = new javax.swing.JButton();
        dobChooser = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        contactNumField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 831));
        setSize(new java.awt.Dimension(1150, 831));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 100, 44));
        jLabel1.setText("Full Name");

        nameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 100, 44));
        jLabel2.setText("Social Security Number");

        ssnField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 100, 44));
        jLabel3.setText("Address");

        addressField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 100, 44));
        jLabel4.setText("Email");

        emailField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 100, 44));
        jLabel5.setText("Date of Birth");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 100, 44));
        jLabel6.setText("Emergency Contact Name");

        ecNameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        ecNumberField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 100, 44));
        jLabel7.setText("Emergency Contact Number");

        occField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 100, 44));
        jLabel8.setText("Occupation");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 100, 44));
        jLabel9.setText("Personal Details");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 100, 44));
        jLabel10.setText("Emergency Contact Details");

        sendAppBtn.setBackground(new java.awt.Color(236, 100, 44));
        sendAppBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        sendAppBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendAppBtn.setText("Send application");
        sendAppBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendAppBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 100, 44));
        jLabel11.setText("Contact Number:");

        contactNumField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel13.setForeground(new java.awt.Color(236, 100, 44));
        jLabel13.setText("UserName");

        userNameField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 100, 44));
        jLabel12.setText("Password");

        passwordField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(contactNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel11))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ssnField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(77, 77, 77))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8))
                                        .addGap(38, 38, 38)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(occField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(142, 142, 142))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(sendAppBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(220, 220, 220)
                                    .addComponent(ecNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(146, 146, 146)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel12))
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(51, 51, 51)
                                    .addComponent(ecNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(497, 497, 497))
                                .addComponent(jLabel7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ssnField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(contactNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(occField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel3)
                                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ecNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ecNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(62, 62, 62)))
                .addGap(44, 44, 44)
                .addComponent(sendAppBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void sendAppBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendAppBtnActionPerformed
        // TODO add your handling code here:
        
        PersonDirectory personDir = appSystem.getPersonDirectory();
        Person p = personDir.createPerson(nameField.getText());
        
        
        String name = nameField.getText();
        String ssn = ssnField.getText();
        String address = addressField.getText();
        Date dob = dobChooser.getDate();
        String email = emailField.getText();
        String ecname = ecNameField.getText();
        String ecnum  = ecNumberField.getText();
        String occ = occField.getText();
        String conNum = contactNumField.getText();
        String username = userNameField.getText();
        String password = passwordField.getText();
        
          if(validate_fields()){
              boolean i=this.appSystem.getTopLevelUserAccountDirectory().checkApplicationUsernameUnique(username);
            
            if(i){ 
                ApplicationDirectory appDir = appSystem.getApplicantDirectory();
                Application app = appDir.createApplication(name, ssn, address, dob, email,ecnum,ecname,occ,conNum,username,password );
    //            System.out.println(app.getApplicationId());
                RequestDirectory reqDir = appSystem.getReqDir();
                ApplicationRequest appRequest = reqDir.createVolunteerApplicationRequest(useraccount, app,this.organization);
                System.out.println(reqDir.getAllRequests().size());

                JOptionPane.showMessageDialog(null, "Application sent!");
            }
            else {
                                JOptionPane.showMessageDialog(null, "Username unavailable.");

            }
         }
    }//GEN-LAST:event_sendAppBtnActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField contactNumField;
    private com.toedter.calendar.JDateChooser dobChooser;
    private javax.swing.JTextField ecNameField;
    private javax.swing.JTextField ecNumberField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField occField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton sendAppBtn;
    private javax.swing.JTextField ssnField;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
