package gui;

/**
 * Screen with information on selected account
 * 
 * @author Brandon Lawson
 * 
 */

/*
 * Project: CryptographyBankingApplication
 * Course: CMSC 495
 * Date: 02/18/2016
 * 02/21/2016 - Updated by Grant Sweeney
 * 02/28/2016 - Added functionality to buttons - Brandon Lawson
 */

public class AccountInfo extends javax.swing.JFrame {

    /**
     * Creates new form AccountInfo
     */
    public AccountInfo() {
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

        bannerLabel = new javax.swing.JLabel();
        accountDetailsPanel = new javax.swing.JPanel();
        accountBalanceLabel1 = new javax.swing.JLabel();
        accountBalanceTextField1 = new javax.swing.JTextField();
        accountTypeLabel1 = new javax.swing.JLabel();
        accountTypeTextField = new javax.swing.JTextField();
        accountNumberLabel1 = new javax.swing.JLabel();
        accountNumberTextField1 = new javax.swing.JTextField();
        transactionButton = new javax.swing.JButton();
        depositWithdrawalPanel = new javax.swing.JPanel();
        amountTextField1 = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        withdrawalButton = new javax.swing.JButton();
        amountLabel2 = new javax.swing.JLabel();
        transferPanel = new javax.swing.JPanel();
        payMortgageButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        amountTextField2 = new javax.swing.JTextField();
        accountTextField = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        accountNumberLabel = new javax.swing.JLabel();
        backToCustomerButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UMUC Bank - Account Info");

        bannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UMUC.logo.jpg"))); // NOI18N

        accountDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        accountBalanceLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountBalanceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountBalanceLabel1.setText("Account Balance");

        accountTypeLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountTypeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountTypeLabel1.setText("Account Type");

        accountNumberLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountNumberLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumberLabel1.setText("Account Number");

        transactionButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        transactionButton.setText("Transaction History");
        transactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountDetailsPanelLayout = new javax.swing.GroupLayout(accountDetailsPanel);
        accountDetailsPanel.setLayout(accountDetailsPanelLayout);
        accountDetailsPanelLayout.setHorizontalGroup(
            accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountBalanceLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountBalanceTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountTypeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountNumberLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountNumberTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(transactionButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accountDetailsPanelLayout.setVerticalGroup(
            accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountBalanceLabel1)
                    .addComponent(accountTypeLabel1)
                    .addComponent(accountNumberLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountBalanceTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountNumberTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transactionButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        depositWithdrawalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deposit / Withdrawal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        depositButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        depositButton.setText("Deposit");

        withdrawalButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        withdrawalButton.setText("Withdrawal");

        amountLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        amountLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel2.setText("Amount");

        javax.swing.GroupLayout depositWithdrawalPanelLayout = new javax.swing.GroupLayout(depositWithdrawalPanel);
        depositWithdrawalPanel.setLayout(depositWithdrawalPanelLayout);
        depositWithdrawalPanelLayout.setHorizontalGroup(
            depositWithdrawalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depositWithdrawalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(depositWithdrawalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(amountTextField1)
                    .addComponent(amountLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(depositWithdrawalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(depositButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(withdrawalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        depositWithdrawalPanelLayout.setVerticalGroup(
            depositWithdrawalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depositWithdrawalPanelLayout.createSequentialGroup()
                .addGroup(depositWithdrawalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(depositWithdrawalPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(depositButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(withdrawalButton))
                    .addGroup(depositWithdrawalPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(amountLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        transferPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer / Pay Mortgage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        payMortgageButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        payMortgageButton.setText("Pay Mortgage");

        transferButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        transferButton.setText("Transfer");

        amountTextField2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        accountTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        amountLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("Amount");

        accountNumberLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumberLabel.setText("Account Number");

        javax.swing.GroupLayout transferPanelLayout = new javax.swing.GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);
        transferPanelLayout.setHorizontalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountTextField)
                    .addComponent(accountNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transferButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payMortgageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        transferPanelLayout.setVerticalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(transferButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payMortgageButton)
                .addGap(7, 7, 7))
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel)
                    .addComponent(accountNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backToCustomerButton.setText("Back to Customer");
        backToCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToCustomerButtonActionPerformed(evt);
            }
        });

        deleteAccountButton.setText("Delete Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(deleteAccountButton)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(depositWithdrawalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(backToCustomerButton)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(depositWithdrawalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteAccountButton)
                            .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(backToCustomerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionButtonActionPerformed
        new Transactions().setVisible(true);
    }//GEN-LAST:event_transactionButtonActionPerformed

    private void backToCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToCustomerButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backToCustomerButtonActionPerformed
    
    private void depositButtonMouseClicked(java.awt.event.MouseEvent evt) {                                           
        String accountNumber = accountNumberTextField1.getText();
        double depositAmount = Double.parseDouble(amountTextField1.getText());
        
        //Process deposit
        
        JOptionPane jPane = new JOptionPane();
        jPane.setMessage("Complete");
        JDialog jDialog = jPane.createDialog(null, "Transaction processed");
        jDialog.setVisible(true);

        //Set new blanace
        
        this.dispose();
    }                                          

    private void withdrawalButtonMouseClicked(java.awt.event.MouseEvent evt) {                                              
        String accountNumber = accountNumberTextField1.getText();
        double accountBalance = Double.parseDouble(accountBalanceTextField1.getText());
        double withdrawalAmount = Double.parseDouble(amountTextField1.getText());
        
        if (withdrawalAmount > accountBalance) {
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Not enough available funds");
            JDialog jDialog = jPane.createDialog(null, "Transaction not processed");
            jDialog.setVisible(true);
            
        } else {
            //Process withdrawal
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Complete");
            JDialog jDialog = jPane.createDialog(null, "Transaction processed");
            jDialog.setVisible(true);
            
            //Set new blanace
        }
        
        this.dispose();
        
    }                                             

    private void transferButtonMouseClicked(java.awt.event.MouseEvent evt) {                                            
        String accountNumber = accountNumberTextField1.getText();
        String toAccountNumber = accountTextField.getText();
        double accountBalance = Double.parseDouble(accountBalanceTextField1.getText());
        double transferAmount = Double.parseDouble(amountTextField2.getText());
        
        
        if (transferAmount > accountBalance) {
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Not enough available funds");
            JDialog jDialog = jPane.createDialog(null, "Transaction not processed");
            jDialog.setVisible(true);
            
        } else {
            //Process transfer
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Complete");
            JDialog jDialog = jPane.createDialog(null, "Transaction processed");
            jDialog.setVisible(true);
            
            //Set new blanace
        }
        
        this.dispose();
    }                                           

    private void payMortgageButtonMouseClicked(java.awt.event.MouseEvent evt) {                                               
        String accountNumber = accountNumberTextField1.getText();
        String toAccountNumber = accountTextField.getText();
        double accountBalance = Double.parseDouble(accountBalanceTextField1.getText());
        double transferAmount = Double.parseDouble(amountTextField2.getText());
        
        if (transferAmount > accountBalance) {
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Not enough available funds");
            JDialog jDialog = jPane.createDialog(null, "Transaction not processed");
            jDialog.setVisible(true);
            
        } else {
            //Process transfer
            
            JOptionPane jPane = new JOptionPane();
            jPane.setMessage("Complete");
            JDialog jDialog = jPane.createDialog(null, "Transaction processed");
            jDialog.setVisible(true);
            
            //Set new blanace
        }
        
        this.dispose();
    }                 

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountBalanceLabel1;
    private javax.swing.JTextField accountBalanceTextField1;
    private javax.swing.JPanel accountDetailsPanel;
    private javax.swing.JLabel accountNumberLabel;
    private javax.swing.JLabel accountNumberLabel1;
    private javax.swing.JTextField accountNumberTextField1;
    private javax.swing.JTextField accountTextField;
    private javax.swing.JLabel accountTypeLabel1;
    private javax.swing.JTextField accountTypeTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel amountLabel2;
    private javax.swing.JTextField amountTextField1;
    private javax.swing.JTextField amountTextField2;
    private javax.swing.JButton backToCustomerButton;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JPanel depositWithdrawalPanel;
    private javax.swing.JButton payMortgageButton;
    private javax.swing.JButton transactionButton;
    private javax.swing.JButton transferButton;
    private javax.swing.JPanel transferPanel;
    private javax.swing.JButton withdrawalButton;
    // End of variables declaration//GEN-END:variables
}

