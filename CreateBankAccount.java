package gui;

import client.BankingDAO;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Form for adding a new bank account to the database
 * 
 * @author Grant Sweeney
 */

/*
 * Project: CryptographyBankingApplication
 * Course: CMSC 495
 * Date: 02/20/2016
 * 02/20/2016 - Banner added by Brandon Lawson
 * 02/25/2016 - Added code to submit user information in a string format - WBaynard
 * 02/28/2016 - Add code for BankingDAO - WBaynard
 */

public class CreateBankAccount extends javax.swing.JFrame {

    private static final BankingDAO bankingDAO = new BankingDAO();

     /**
     * Creates new form CreateBankAccount
     */
    public CreateBankAccount() {
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

        addAccountTitle = new javax.swing.JLabel();
        addAccountInstructions = new javax.swing.JLabel();
        createUserFormPanel = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        startingBalanceLabel = new javax.swing.JLabel();
        startingBalanceTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        accountTypeComboBox = new javax.swing.JComboBox();
        accountTypeLabel = new javax.swing.JLabel();
        bannerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addAccountTitle.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        addAccountTitle.setForeground(new java.awt.Color(0, 0, 204));
        addAccountTitle.setText("Add New Bank Account");

        addAccountInstructions.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addAccountInstructions.setText("Please fill out the following form and press submit to add a new account to the selected customer.  All fields are required.");

        createUserFormPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dateLabel.setText("Date:");

        dateTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        startingBalanceLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        startingBalanceLabel.setText("Starting Balance:");

        startingBalanceTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        accountTypeComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Checking", "Savings", "Mortgage" }));

        accountTypeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        accountTypeLabel.setText("Account Type:");

        javax.swing.GroupLayout createUserFormPanelLayout = new javax.swing.GroupLayout(createUserFormPanel);
        createUserFormPanel.setLayout(createUserFormPanelLayout);
        createUserFormPanelLayout.setHorizontalGroup(
            createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserFormPanelLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addGap(191, 191, 191)
                        .addComponent(cancelButton))
                    .addGroup(createUserFormPanelLayout.createSequentialGroup()
                        .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(accountTypeLabel)
                            .addComponent(startingBalanceLabel)
                            .addComponent(dateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startingBalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(105, 105, 105))
        );
        createUserFormPanelLayout.setVerticalGroup(
            createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserFormPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startingBalanceLabel)
                    .addComponent(startingBalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountTypeLabel)
                    .addComponent(accountTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel))
                .addGap(45, 45, 45)
                .addGroup(createUserFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addGap(32, 32, 32))
        );

        bannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UMUC.logo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addAccountInstructions)
                            .addComponent(addAccountTitle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(createUserFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAccountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addAccountInstructions)
                .addGap(18, 18, 18)
                .addComponent(createUserFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String startBalance = startingBalanceTextField.toString();
        String acctType = accountTypeComboBox.toString();
        String dateSubmitted = dateTextField.toString();
        
        //Submit User Info to BankingDOA
        String acctInfo = bankingDAO.createNewAccount(acctType, startBalance, dateSubmitted);
        
        if (!acctInfo.equals("error"))
        {
            JOptionPane.showMessageDialog((Component) null, 
                        "Your account has been created.",
                   "Account Added", JOptionPane.OK_OPTION);
        }
        else
        {
            JOptionPane.showMessageDialog((Component) null, 
                        "Attempt failed.  There was a problem creating the account.",
                   "Account Not Added", JOptionPane.OK_OPTION);
        }
        
        this.dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountTypeComboBox;
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JLabel addAccountInstructions;
    private javax.swing.JLabel addAccountTitle;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel createUserFormPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel startingBalanceLabel;
    private javax.swing.JTextField startingBalanceTextField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
