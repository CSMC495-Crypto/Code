package gui;

import java.awt.Component;
import javax.swing.JOptionPane;
import client.BankingDAO;

/**
 * Form for adding a new user to the database
 * 
 * @author Grant Sweeney
 */

/*
 * Project: CryptographyBankingApplication
 * Course: CMSC 495
 * Date: 02/20/2016
 * 02/20/2016 - Banner added by Brandon Lawson
 * 02/25/2016 - Added code to submit user information in a string format - WBaynard
 * 02/28/2016 - Added code for BankingDAO - WBaynard
 */

public class CreateUserProfile extends javax.swing.JFrame {

    private static final BankingDAO bankingDAO = new BankingDAO();
    JOptionPane window = new JOptionPane();

    /**
     * Creates new form CreateUserProfile
     */
    public CreateUserProfile() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createUserTitle = new javax.swing.JLabel();
        createUserInstructions = new javax.swing.JLabel();
        createUserFormPanel = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        employeeCheckBox = new javax.swing.JCheckBox();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPasswordTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        stateTextField = new javax.swing.JTextField();
        zipCodeLabel = new javax.swing.JLabel();
        zipCodeTextField = new javax.swing.JTextField();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        bannerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createUserTitle.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        createUserTitle.setForeground(new java.awt.Color(0, 0, 204));
        createUserTitle.setText("Create New User Profile");

        createUserInstructions.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        createUserInstructions.setText("Please fill out the following form and press submit to create a new user profile.  All fields are required.");

        userNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userNameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        passwordLabel.setText("Password:");

        passwordTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        employeeCheckBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        employeeCheckBox.setText("Check if the new user is a bank employee");

        confirmPasswordLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password:");

        confirmPasswordTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        firstNameLabel.setText("First Name: ");

        lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lastNameLabel.setText("Last Name: ");

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        addressLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addressLabel.setText("Address: ");

        cityLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cityLabel.setText("City: ");

        stateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        stateLabel.setText("State: ");

        zipCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        zipCodeLabel.setText("Zip Code: ");

        phoneNumberLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        phoneNumberLabel.setText("Phone Number: ");

        phoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createUserFormPanelLayout = new javax.swing.GroupLayout(createUserFormPanel);
        createUserFormPanel.setLayout(createUserFormPanelLayout);
        createUserFormPanelLayout.setHorizontalGroup(
            createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserFormPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(249, 249, 249))
            .addGroup(createUserFormPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstNameLabel)
                    .addComponent(addressLabel)
                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(phoneNumberTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(zipCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lastNameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(addressTextField))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserFormPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addComponent(employeeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmPasswordLabel))
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(confirmPasswordTextField)
                    .addComponent(passwordTextField))
                .addContainerGap())
        );
        createUserFormPanelLayout.setVerticalGroup(
            createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmPasswordLabel)
                        .addComponent(employeeCheckBox)))
                .addGap(51, 51, 51)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel))
                .addGap(16, 16, 16)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel)
                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipCodeLabel)
                    .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLabel))
                .addGap(17, 17, 17)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel))
                .addGap(32, 32, 32)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        bannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UMUC.logo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createUserInstructions)
                    .addComponent(createUserTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(createUserFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(createUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserInstructions)
                .addGap(18, 18, 18)
                .addComponent(createUserFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // code for submitting form goes here
        String userType = "customer";
        String userName = userNameTextField.getText();
        String userPassword = confirmPasswordTextField.getText();
        String userFirstName = firstNameTextField.getText();
        String userLastName = lastNameTextField.getText();
        String userAddress = addressTextField.getText();
        String userCity = cityTextField.getText();
        String userState = stateTextField.getText();
        String userZip = zipCodeTextField.getText();
        String userPhoneNumber = phoneNumberTextField.getText();
        
        if (employeeCheckBox.isSelected())
        {
            userType = "employee";
        }
        
        String checkProfile = bankingDAO.createUserProfile(userFirstName, userLastName, 
                                    userPhoneNumber, userAddress, userCity, userState, 
                                    userZip, userName, userPassword, userType);
        System.out.println(checkProfile);
        if (checkProfile.contains("Confirmed"))
        {
            JOptionPane.showMessageDialog((Component) null, 
                    "Your profile was created.",
    	       "Information", JOptionPane.OK_OPTION);
        }
        else
        {
            JOptionPane.showMessageDialog((Component) null, 
                    "Attempt failed.  There was a problem creating the profile.",
    	       "alert", JOptionPane.OK_OPTION);
        }
        
        this.dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JTextField confirmPasswordTextField;
    private javax.swing.JPanel createUserFormPanel;
    private javax.swing.JLabel createUserInstructions;
    private javax.swing.JLabel createUserTitle;
    private javax.swing.JCheckBox employeeCheckBox;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}
