
package gui;

/**
 * This class is a GUI to display history of payments.
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date Updated on 02/19/2016
 * 
 *       02/20/2016 - Banner added by Brandon Lawson
 * 
 *       02/21/2016 - updated with variables names and removed exturnal class
 * 
 */
public class Transactions extends javax.swing.JFrame {

	/**
	 * Creates new form Transactions
	 */
	public Transactions() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		transactionsPanel = new javax.swing.JPanel();
		listScrolPane = new javax.swing.JScrollPane();
		transactionsTable = new javax.swing.JTable();
		transactions = new javax.swing.JLabel();
		backToAccount = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("UMUC Bank");

		transactionsTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null } }, new String[] {
						"Data", "Description", "Principal", "Interest", "Fees",
						"Total" }));
		transactionsTable.setGridColor(new java.awt.Color(153, 153, 153));
		transactionsTable.setRowHeight(23);
		transactionsTable.setShowVerticalLines(false);
		listScrolPane.setViewportView(transactionsTable);

		transactions.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
		transactions.setText("Transactions");

		// bannerLabel.setBackground(new java.awt.Color(0, 0, 153));
		// bannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		// bannerLabel.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/gui/UMUC.logo.jpg")));

		backToAccount.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
		backToAccount.setText("Back to Account");
		backToAccount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backToAccountActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout transactionsPanelLayout = new javax.swing.GroupLayout(
				transactionsPanel);
		transactionsPanel.setLayout(transactionsPanelLayout);
		transactionsPanelLayout
				.setHorizontalGroup(transactionsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								transactionsPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												transactionsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																transactionsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				listScrolPane,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				514,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																transactionsPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				transactions,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				163,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				backToAccount,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				149,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(26,
																				26,
																				26)))));
		transactionsPanelLayout
				.setVerticalGroup(transactionsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								transactionsPanelLayout
										.createSequentialGroup()
										.addContainerGap(88, Short.MAX_VALUE)
										.addGroup(
												transactionsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																transactions,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																24,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																backToAccount))
										.addGap(18, 18, 18)
										.addComponent(
												listScrolPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												294,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				transactionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				transactionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void backToAccountActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Transactions.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Transactions.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Transactions.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Transactions.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Transactions().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton backToAccount;
	private javax.swing.JScrollPane listScrolPane;
	private javax.swing.JLabel transactions;
	private javax.swing.JPanel transactionsPanel;
	private javax.swing.JTable transactionsTable;
	// End of variables declaration
}
