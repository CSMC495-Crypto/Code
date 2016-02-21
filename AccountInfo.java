/*
Account Info screen used by the employee
Author: Brandon Lawson
Date: February 18, 2016
Filename: ClientV2.java

02/20/2016 - Modified layout
*/

package gui;

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

        javax.swing.GroupLayout accountDetailsPanelLayout = new javax.swing.GroupLayout(accountDetailsPanel);
        accountDetailsPanel.setLayout(accountDetailsPanelLayout);
        accountDetailsPanelLayout.setHorizontalGroup(
            accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountDetailsPanelLayout.createSequentialGroup()
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(depositWithdrawalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(depositWithdrawalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInfo().setVisible(true);
            }
        });
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
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JButton depositButton;
    private javax.swing.JPanel depositWithdrawalPanel;
    private javax.swing.JButton payMortgageButton;
    private javax.swing.JButton transferButton;
    private javax.swing.JPanel transferPanel;
    private javax.swing.JButton withdrawalButton;
    // End of variables declaration//GEN-END:variables
}

