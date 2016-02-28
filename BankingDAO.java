package client;

import cryptography.DataProcessor;
import data.DataObject;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

/**
 * Implements the DAOInterface and converts GUI data into SQL database commands
 * and transceives data with the server
 * 
 * @author Jonathan Wojack
 * @date 2/27/2016
 * @course CMSC495
 * @project Cryptography Banking Application
 * 
 */

public class BankingDAO implements DAOInterface {
    
    String username = "";
    String password = "";
    
    public String client(String plainText, Boolean requestType) {

        // declare I/O streams
  
        DataOutputStream toServer;
        DataInputStream fromServer;  
    
        // establish connection to server
    
        try {
        
            //  Socket socket = new Socket("localhost", 8000); // local connection
            Socket socket = new Socket("68.134.160.249", 8000);  // network connection
          
            // create an input stream to receive data from the server
      
            fromServer = new DataInputStream(socket.getInputStream());
      
            // create an output stream to send data to the server
      
            toServer = new DataOutputStream(socket.getOutputStream()); 
                
            DataProcessor dataProcessor = new DataProcessor();

            // get user input from text field and convert to data to send to server
          
            int columns = 0;  // columns in selected SQL database table               
          
            // encrypt data to be sent to server with custom XOR encryption algorithm       
        
            DataObject clientEncryptedObject = dataProcessor.encryptData(plainText);
                
            // transmit encrypted data to the server
                
            ObjectOutputStream toServerOOS = new ObjectOutputStream(socket.getOutputStream());
            toServerOOS.writeObject(clientEncryptedObject);
            toServerOOS.flush();

            // get data from server
        
            String dataReturned = "";
                
            if (requestType) {  // if data is to be returned
        
                DataObject serverEncryptedObject = null;
        
                ObjectInputStream fromServerOIS = new ObjectInputStream(socket.getInputStream());
              
                serverEncryptedObject = (DataObject) fromServerOIS.readObject();
              
                // get number of cells in selected SQL table
                // decrypt and process data
                        
                String cellsString = dataProcessor.decryptData(serverEncryptedObject).trim();
                        
                int cells = Integer.parseInt(cellsString);
                                      
                // get table data from server, decrypt, and then process and display data
       
                for (int i = 0; i < cells/columns; i++) {  // rows of data in table                 
                  
                    for (int j = 0; j < columns; j++) {
                      
                        DataObject serverEncryptedObjectLoop = null;                      
                        ObjectInputStream fromServerLoop = new ObjectInputStream(socket.getInputStream());
                        serverEncryptedObjectLoop = (DataObject) fromServerLoop.readObject();
                        dataReturned.concat(dataProcessor.decryptData(serverEncryptedObjectLoop) + "\n");
                                
                    }
                                              
                } 
                
                return dataReturned;    // return requested data from database
                        
            }
                    
            else {  // if only a database update is to be performed
        
                DataObject serverEncryptedObject = null;
            
                ObjectInputStream fromServerOIS = new ObjectInputStream(socket.getInputStream());
                        
                // get response from server
              
                serverEncryptedObject = (DataObject) fromServerOIS.readObject();
              
                // decrypt and report server response
                        
                return dataProcessor.decryptData(serverEncryptedObject);    // return update status       
                        
            }
            
        }   catch (Exception ex) {
                
        }
    
        return "";
    
    }
    
    /**
     * Sends login information to be checked against database records
     * 
     * @param data: username, password
     * 
     * @return User type (customer or employee) if valid combination, denied if invalid
     */
   
    @Override
    public String confirmLogIn(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // transmit request
        
        String username = data[0];
        String password = data[1];
        
        String command = ("Login " + username + " " + password);
        
        setUsername(username);
        setPassword(password);
        
        return client(command, false);
        
    }
    
    /**
     * get customer information needed for start screen
     * 
     * @param data: username, password
     * 
     * @return customer first name, last name, and all customer account information
     */
    
    public String getCustomerScreenInfo(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // transmit request
        
        String username = data[0];
        String password = data[1];
        
        String command = ("GetCustomer " + username + " " + password);
        
        return client(command, true);
        
    }
        
    /**
     * get customer account information
     * 
     * @param data: accountNumber
     * 
     * @return account information including account balance, type, and number
     */
    
    public String getCustomerAccount(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 1).isEmpty()) {
            
            return errorChecking(data, 1);
            
        }
        
        // transmit request
        
        String accountNumber = data[0];
        
        String command = ("GetAccountInformation " + accountNumber);
        
        return client(command, true);
        
    }
    
    /**
     * Request for all customer information
     * 
     * @param data: firstName, lastName
     * 
     * @return all customer information including name, address, phone number, and account info
     */

    public String getCustomerInformation(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 2).isEmpty()) {
            
            return errorChecking(data, 2);
            
        }
        
        // transmit request
        
        String firstName = data[0];
        String lastName = data[1];
        
        String command = ("GetCustomerInformation " + firstName + " " + lastName);
        
        return client(command, true);
        
    }
    
    /**
     * Request to create a new user
     * 
     * @param data: username, password, employeeStatus, firstName, lastName, address, city, state, zipCode, phoneNumber
     * 
     * @return "confirm" if created, "username taken" or "profile exists" if these errors occur
     */

    public String createUserProfile(String...data) {
        
        // validate arguments
        
        if (!errorChecking(data, 10).isEmpty()) {
            
            return errorChecking(data, 10);
            
        }
        
        if (data[8].matches(".*[a-zA-Z]+.*")) { // if ZIP code field contains a letter
            
            return "Error: Invalid ZIP Code";
            
        }
        
        // transmit request
        
        String username = data[0];
        String password = data[1];
        String employeeStatus = data[2];
        String firstName = data[3];
        String lastName = data[4];
        String address = data[5];
        String city = data[6];
        String state = data[7];
        String zipCode = data[8];
        String phoneNumber = data[9];
        
        String command = ("CreateUser " + accountNumber);
        
        return client(command, true);
        
    }
    
    /**
     * Request to create a new bank account
     * 
     * @param data: accountType, accountBalance, date
     * 
     * @return String including new account number and all entered information, "error" if error occurs
     */
    
    public String createNewAccount(String...data);
    
    /**
     * Request to delete a user profile
     * 
     * @param data: firstName, lastName
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteUserProfile(String...data);
    
    /**
     * Request to delete bank account
     * 
     * @param data: accountNumber
     * 
     * @return "confirm" if deleted, "error" if error occurs
     */
    
    public String deleteAccount(String...data);
    
    /**
     * Request for the transaction history of a bank account
     * 
     * @param data: accountNumber
     * 
     * @return transaction history, including all fields to populate transaction screen
     *         comma-separated fields, with newlines between transactions
     */
    
    public String getTransactionHistory(String...data);
    
    /**
     * Request to deposit money in selected account
     * 
     * @param data: accountNumber, amount
     * 
     * @return new account balance if successful, "error" if error occurs
     */
    
    public String depositMoney(String...data);

    /**
     * Request to withdraw money from selected account
     * 
     * @param data: accountNumber, amount
     *
     * @return new account balance if successful, error type if error occurs
     */
    
    public String withdrawMoney(String...data);
    
    /**
     * Request to transfer money between two accounts
     * 
     * @param data: accountFrom, amount, accountTo
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String transferMoney(String...data);
    
    /**
     * Request to pay mortgage from a bank account
     * 
     * @param data: accountFrom, amount, mortgageAccount
     * 
     * @return new account balance for both accounts if successful, error type if error occurs
     */
    
    public String payMortgage(String...data);
    
    public String errorChecking(String[] data, int numberArguments) {
        
        // check for valid number of arguments
        
        if (data.length != numberArguments) {
            
            return "Error: Invalid number of arguments.  " + numberArguments + " arguments expected.";
            
        }
        
        // verify that none of the arguments are empty strings
        
        for (int i = 0; i < numberArguments; i++) {
            
            if (data[i].isEmpty()) {
                
                return "Error: Empty argument value.";
                
            }
            
        }
        
        return "";
        
    }
    
    public void setUsername(String username) {
        
        this.username = username;
        
    }
    
    public void setPassword(String password) {
        
        this.password = password;
        
    }
    
    public String getUsername() {
        
        return this.username;
        
    }
    
    public String getPassword() {
        
        return this.password;
        
    }
    
}
