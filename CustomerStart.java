package gui;

import client.BankingDAO;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Screen with all customer functionality functionality
 * 
 * @author Brandon Lawson
 * 
 */

/*
 * Project: CryptographyBankingApplication
 * Course: CMSC 495
 * Date: 02/18/2016
 * 02/21/2016 - Updated by Grant Sweeney
 * 02/25/2016 - Added code to submit user information in a string format - WBaynard
 * 02/28/2016 - Add code for BankingDAO - WBaynard
 */

public class CustomerStart extends javax.swing.JFrame {

    private static final BankingDAO bankingDAO = new BankingDAO();

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
        jScrollPane2 = new javax.swing.JScrollPane();
        accountDetailsTable = new javax.swing.JTable();
        transferPanel = new javax.swing.JPanel();
        payMortgageButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        amountTextField = new javax.swing.JTextField();
        accountNumberToTextField = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        accountNumberToLabel = new javax.swing.JLabel();
        accountNumberFromLabel = new javax.swing.JLabel();
        accountNumberFromTextField = new javax.swing.JTextField();

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

        accountDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "select this account", "select this account"},
                {null, null, null, "select this account", "select this account"},
                {null, null, null, "select this account", "select this account"},
                {null, null, null, "select this account", "select this account"},
                {null, null, null, "select this account", "select this account"},
                {null, null, null, "select this account", "select this account"}
            },
            new String [] {
                "Account Number", "Account Type", "Account Balance", "Transaction History", "Transfer Funds"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountDetailsTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(accountDetailsTable);

        javax.swing.GroupLayout accountDetailsPanel1Layout = new javax.swing.GroupLayout(accountDetailsPanel1);
        accountDetailsPanel1.setLayout(accountDetailsPanel1Layout);
        accountDetailsPanel1Layout.setHorizontalGroup(
            accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountDetailsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );
        accountDetailsPanel1Layout.setVerticalGroup(
            accountDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountDetailsPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        transferPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer / Pay Mortgage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        payMortgageButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        payMortgageButton.setText("Pay Mortgage");

        transferButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        transferButton.setText("Transfer");

        amountTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        accountNumberToTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        amountLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("Amount");

        accountNumberToLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountNumberToLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumberToLabel.setText("Account Number To");

        accountNumberFromLabel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        accountNumberFromLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumberFromLabel.setText("Account Number From");

        accountNumberFromTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        javax.swing.GroupLayout transferPanelLayout = new javax.swing.GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);
        transferPanelLayout.setHorizontalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountNumberFromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountNumberFromTextField))
                .addGap(36, 36, 36)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountNumberToTextField)
                    .addComponent(accountNumberToLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountNumberFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transferPanelLayout.createSequentialGroup()
                        .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountLabel)
                            .addComponent(accountNumberToLabel)
                            .addComponent(accountNumberFromLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accountNumberToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(837, 837, 837)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(customerInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(accountDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(customerInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(accountDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(exitButton)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void accountDetailsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountDetailsTableMousePressed
        int col = accountDetailsTable.columnAtPoint(evt.getPoint());
        if(col == 3) {
            new Transactions().setVisible(true);
        }
    }//GEN-LAST:event_accountDetailsTableMousePressed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt)                                               
    {                                                    
        // TODO add your handling code here:
        //String amount = amountTextField.toString();
        String acctNumberfrom = accountNumberFromTextField.toString();
        //String firstName = firstNameTextField.toString();
        //String lastName = lastNameTextField.toString();
        String acctNumberTo = accountNumberToTextField.toString();
        String amount = amountTextField.toString();
        
        //Trans mit account information
        String[] transferAccount = { acctNumberfrom, amount, acctNumberTo };
        String newBalance = bankingDAO.transferMoney(transferAccount);
        
        if (!newBalance.equals(""))
        {
            JOptionPane.showMessageDialog((Component) null, 
                    "Your new balane is: " + newBalance,
    	       "Account Balance", JOptionPane.OK_OPTION);
        }

    } 
    
    private void payMortgageButtonActionPerformed(java.awt.event.ActionEvent evt)                                                  
    {                                                      
        // TODO add your handling code here:
        //String amount = amountTextField.toString();
        String acctNumberfrom = accountNumberFromTextField.toString();
        //String firstName = firstNameTextField.toString();
        //String lastName = lastNameTextField.toString();
        String acctNumberTo = accountNumberToTextField.toString();
        String amount = amountTextField.toString();
        
        //Trans mit account information
        String[] transferAccount = { acctNumberfrom, amount, acctNumberTo };
        String newBalance = bankingDAO.transferMoney(transferAccount);
        
        if (!newBalance.equals(""))
        {
            JOptionPane.showMessageDialog((Component) null, 
                    "Your new mortage balane is: " + newBalance,
    	       "Mortage", JOptionPane.OK_OPTION);
        }
    } 
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountDetailsPanel1;
    private javax.swing.JTable accountDetailsTable;
    private javax.swing.JLabel accountNumberFromLabel;
    private javax.swing.JTextField accountNumberFromTextField;
    private javax.swing.JLabel accountNumberToLabel;
    private javax.swing.JTextField accountNumberToTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JPanel customerInformationPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton payMortgageButton;
    private javax.swing.JButton transferButton;
    private javax.swing.JPanel transferPanel;
    // End of variables declaration//GEN-END:variables
}

