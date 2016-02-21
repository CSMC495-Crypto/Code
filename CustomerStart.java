/*
Customer Main Screen
Author: Brandon Lawson
Date: February 18, 2016
Filename: ClientV2.java

02/20/2016 - Modified layout
*/

package gui;

public class CustomerStart extends javax.swing.JFrame {

    /**
     * Creates new form CustomerStart
     */
    public CustomerStart() {
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

        exitButton = new javax.swing.JButton();
        bannerLabel = new javax.swing.JLabel();
        customerInformationPanel = new javax.swing.JPanel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        accountDetailsPanel1 = new javax.swing.JPanel();
        accountBalanceLabel2 = new javax.swing.JLabel();
        accountBalanceTextField2 = new javax.swing.JTextField();
        accountTypeLabel2 = new javax.swing.JLabel();
        accountTypeTextField1 = new javax.swing.JTextField();
        accountNumberLabel2 = new javax.swing.JLabel();
        accountNumberTextField2 = new javax.swing.JTextField();
        transactionsLabel = new javax.swing.JLabel();
        accountComboBox = new javax.swing.JComboBox<>();
        navTransactionsButton = new javax.swing.JButton();
        transferPanel = new javax.swing.JPanel();
        payMortgageButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        amountTextField = new javax.swing.JTextField();
        accountTextField = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        accountNumberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UMUC Bank - Customer Screen");
        setMaximumSize(new java.awt.Dimension(32768, 32768));
        setPreferredSize(new java.awt.Dimension(1000, 640));

        exitButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        exitButton.setText("Exit Program");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        bannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UMUC.logo.jpg"))); // NOI18N
        bannerLabel.setMaximumSize(new java.awt.Dimension(637, 590));
        bannerLabel.setMinimumSize(new java.awt.Dimension(637, 590));
        bannerLabel.setName(""); // NOI18N
        bannerLabel.setPreferredSize(new java.awt.Dimension(637, 590));

        customerInformationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        firstNameTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        lastNameTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        firstNameLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        firstNameLabel.setText("First Name:");

        lastNameLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastNameLabel.setText("Last Name:");

        javax.swing.GroupLayout customerInformationPanelLayout = new javax.swing.GroupLayout(customerInformationPanel);
        customerInformationPanel.setLayout(customerInformationPanelLayout);
        customerInformationPanelLayout.setHorizontalGroup(
            customerInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInformationPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        customerInformationPanelLayout.setVerticalGroup(
            customerInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel)
                    .addComponent(lastNameLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        accountDetailsPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        accountDetailsPanel1.setPreferredSize(new java.awt.Dimension(448, 94));

        accountBalanceLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountBalanceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountBalanceLabel2.setText("Account Balance");

        accountBalanceTextField2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        accountTypeLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountTypeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountTypeLabel2.setText("Account Type");

        accountTypeTextField1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        accountNumberLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountNumberLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumberLabel2.setText("Account Number");

        accountNumberTextField2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        transactionsLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        transactionsLabel.setText("Transactions");

        accountComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        navTransactionsButton.setText("Go To Transactions");
        navTransactionsButton.setToolTipText("");
        navTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navTransactionsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountDetailsPanel1Layout = new javax.swing.GroupLayout(accountDetailsPanel1);
        accountDetailsPanel1.setLayout(accountDetailsPanel1Layout);
        accountDetailsPanel1Layout.setHorizontalGroup(
            accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountDetailsPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(accountDetailsPanel1Layout.createSequentialGroup()
                        .addComponent(transactionsLabel)
                        .addGap(34, 34, 34))
                    .addGroup(accountDetailsPanel1Layout.createSequentialGroup()
                        .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(accountDetailsPanel1Layout.createSequentialGroup()
                                .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(navTransactionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(accountDetailsPanel1Layout.createSequentialGroup()
                                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accountBalanceTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(accountBalanceLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accountTypeTextField1)
                                    .addComponent(accountTypeLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accountNumberLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(accountNumberTextField2))))
                        .addContainerGap())))
        );
        accountDetailsPanel1Layout.setVerticalGroup(
            accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountDetailsPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountBalanceLabel2)
                    .addComponent(accountTypeLabel2)
                    .addComponent(accountNumberLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountBalanceTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountTypeTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountNumberTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(transactionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navTransactionsButton)))
        );

        transferPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer / Pay Mortgage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        payMortgageButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        payMortgageButton.setText("Pay Mortgage");

        transferButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        transferButton.setText("Transfer");

        amountTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

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
                    .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountTextField)
                    .addComponent(accountNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
                    .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(customerInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(accountDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(125, 125, 125)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(customerInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(accountDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton)
                    .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navTransactionsButtonActionPerformed
        new Transactions().setVisible(true);
    }//GEN-LAST:event_navTransactionsButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountBalanceLabel2;
    private javax.swing.JTextField accountBalanceTextField2;
    private javax.swing.JComboBox<String> accountComboBox;
    private javax.swing.JPanel accountDetailsPanel1;
    private javax.swing.JLabel accountNumberLabel;
    private javax.swing.JLabel accountNumberLabel2;
    private javax.swing.JTextField accountNumberTextField2;
    private javax.swing.JTextField accountTextField;
    private javax.swing.JLabel accountTypeLabel2;
    private javax.swing.JTextField accountTypeTextField1;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JPanel customerInformationPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton navTransactionsButton;
    private javax.swing.JButton payMortgageButton;
    private javax.swing.JLabel transactionsLabel;
    private javax.swing.JButton transferButton;
    private javax.swing.JPanel transferPanel;
    // End of variables declaration//GEN-END:variables
}

