/*

Client program which provides local and network connectivity to server
Remotely connects to SQL database and provides text-based table and data manipulation

Author: Jonathan Wojack
Date: February 1, 2016
Filename: ClientV2.java

*/

package client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class ClientV2 extends JFrame {

    String plainText;

    // declare GUI components
    
    private JTextField jtf = new JTextField();
    private JTextArea jta = new JTextArea();

    // declare I/O streams
  
    private DataOutputStream toServer;
    private DataInputStream fromServer;
  
    public static void main(String[] args) {
    
        new ClientV2();
  
    }
    
    // default constructor

    public ClientV2() {
    
        // set GUI to auto-scroll
    
        DefaultCaret caret = (DefaultCaret)jta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
 
        // panel p to hold the label and text field
    
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Enter data to encrypt"), BorderLayout.WEST);
        p.add(jtf, BorderLayout.CENTER);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(new JScrollPane(jta), BorderLayout.CENTER);

        // register text field listener
        
        jtf.addActionListener(new Listener());

        // set frame
        
        setTitle("Client");
        
        setLocation(500,50);
        
        setSize(500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            
            // establish connection to server

            // Socket socket = new Socket("localhost", 8000); // local connection
            Socket socket = new Socket("68.134.160.249", 8000);  // network connection
       
            jta.append("Connection established!\n\n");
       
            // display menu
            
            jta.append("Enter '1' to view customer database\n");
            jta.append("Enter '2' to view employee database\n");
            jta.append("Enter '3' to view bank account database\n");
            jta.append("Enter '4' to view customer database\n");
            jta.append("Enter '5' to add customer to database\n");
            jta.append("Enter '6' to delete customer from database\n");
            jta.append("Enter '7' to deposit money into customer's bank account\n");
            jta.append("Enter '8' to withdrawal money from customer's bank account\n\n");
            jta.append("*****************************************************************\n\n");

            // create an input stream to receive data from the server
      
            fromServer = new DataInputStream(socket.getInputStream());
      
            // create an output stream to send data to the server
      
            toServer = new DataOutputStream(socket.getOutputStream());
    
        }
        
        catch (IOException ex) {
      
            jta.append(ex.toString() + '\n');
            
        }
        
    }
    
    // text field listener

    private class Listener implements ActionListener {
    
        @Override
    
        public void actionPerformed(ActionEvent e) {
  
            try {
          
                // socket connection
                
                Socket socket = new Socket("68.134.160.249", 8000);  // network connection
                // Socket socket = new Socket("localhost", 8000);  // local connection       
          
                // get user input from text field and convert to data to send to server
          
                int columns = 0;  // columns in selected SQL database table               
          
                switch (Integer.parseInt(jtf.getText().trim())) {
              
                    case 1: // view Customer table
              
                        plainText = "SELECT * FROM Customer;";
                        columns = 7;
                        break;
                  
                    case 2: // view Employee table
                  
                        plainText = "SELECT * FROM Employee;";
                        columns = 7;
                        break;
                  
                    case 3: // view bankAccount table
                  
                        plainText = "SELECT * FROM bankAccount;";
                        columns = 3;
                        break;
                  
                    case 4: // view mortgageAccount table
                  
                        plainText = "SELECT * FROM mortgageAccount;";
                        columns = 2;
                        break;
                  
                    case 5: // add entry to Customer table
                  
                        plainText = "INSERT INTO Customer VALUES ('John','Smith','101 Pine Street','202-123-4567','jsmith','P@SSW0RD','1234567');";
                        break;
                  
                    case 6: // remove entry from Customer table
                  
                        plainText = "DELETE FROM Customer WHERE accountNumber='1234567';";
                        break;
                  
                    case 7: // update individual cell in bankAccount table
                  
                        plainText = "UPDATE bankAccount SET accountBalance=5000 WHERE accountNumber='18011809';";
                        break;
                  
                    case 8: // update individual cell in bankAccount table
                  
                        plainText = "UPDATE bankAccount SET accounBalance=1000 WHERE accountNumber='18011809';";
                        break;
                  
                    default: // invalid entry
                  
                        jta.append("\nINVALID SELECTION!  Terminating connection.");
                        System.exit(0);
                        
                }      
                
                // encrypt data to be sent to server with custom XOR encryption algorithm       
        
                XOR xor = new XOR(plainText);        
                DataObject clientEncryptedObject = xor.encryptData();
                
                // transmit encrypted data to the server
                
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                toServer.writeObject(clientEncryptedObject);
                toServer.flush();

                // display transmission data
        
                jta.append("Data to send to server:\n" + plainText);        
                jta.append("\n\nData encrypted as\n" + new String(clientEncryptedObject.encryptedData) + "\n\n");
        
                // get data from server
                
                if (Integer.parseInt(jtf.getText().trim()) <= 4) {  // since updates don't generate return data
        
                    DataObject serverEncryptedObject = null;
                    try (ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream())) {
              
                        serverEncryptedObject = (DataObject) fromServer.readObject();
              
                        // get number of cells in selected SQL table
                        // decrypt and process data
                        
                        String cellsString = xor.decryptData(serverEncryptedObject).trim();
                        int cells = Integer.parseInt(cellsString);
                                      
                        // get table data from server, decrypt, and then process and display data
       
                        for (int i = 0; i < cells/columns; i++) {  // rows of data in table                 
                  
                            for (int j = 0; j < columns; j++) {
                      
                                DataObject serverEncryptedObjectLoop = null;                      
                                ObjectInputStream fromServerLoop = new ObjectInputStream(socket.getInputStream());
                                serverEncryptedObjectLoop = (DataObject) fromServerLoop.readObject();
                                jta.append("\n" + xor.decryptData(serverEncryptedObjectLoop));
                                
                            }
                  
                            jta.append("\n\n");  // end of row in table
                            
                        } 
                        
                    }
                    
                    
                
                }       
                
                else if (Integer.parseInt(jtf.getText().trim()) > 4) {  // since updates don't generate return data
        
                    DataObject serverEncryptedObject = null;
                    try (ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream())) {
                        
                        // get response from server
              
                        serverEncryptedObject = (DataObject) fromServer.readObject();
              
                        // decrypt and report server response
                   
                        jta.append("\n" + xor.decryptData(serverEncryptedObject) + "\n\n");            
                        
                    }
      
                }
                
            }
      
            catch (IOException ex) {
                
                System.err.println(ex);
                
            }
      
            catch (ClassNotFoundException ex) {
          
            }
    
        }
        
    }
  
}
