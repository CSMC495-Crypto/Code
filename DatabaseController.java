/**
 * Database controller
 * 
 * @author Jonathan Wojack
 */

/* 
 * project Bank Encryption Application
 * course CMSC495
 * date 2/21/2016
 * updated by Jonathan Wojack on 2/23/2016
 * updated by Grant Sweeney on 2/27/2016
 * 
 * Changes:
 * 
 * 1.  Added line 166
 * 
 * dispose();
 * 
 * so that only one GUI window for the server would remain and that multiple
 * windows would not be populated and not closed for each client interaction
 * with the server
 * 
 * 2.  Refactored class from BankingDOA to DatabaseController
 * 
 * 
 */

package server;

import cryptography.DataProcessor;
import cryptography.XOR;
import data.DataObject;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

public class DatabaseController extends Server {
   
    DataObject encryptedObject;
    Socket socket;
    
    public DatabaseController(Socket socket) {
        
        this.socket = socket;
        
    }
    
    /**
     * Process data from client
     * 
     * @param encryptedObject Encrypted data to be processed
     */
    
    public void processData(DataObject encryptedObject) {
        
        try {
            
            DataProcessor dataProcessor = new DataProcessor();
        
            setEncryptedObject(encryptedObject);
            String query = retrieveData();     
            System.out.println(query);
        
            String connUrl="jdbc:mysql://localhost:3306/cmsc495";
            String username="default";
            String password="superSecretPassword";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connUrl,username,password);
            Statement st = conn.createStatement();
                    
            jta.append("rows of data in database table to be selected\n");
                    
            int rows = 0;  
                    
            jta.append("determine whether client desires to display or modify data\n");
        
            
            jta.append(query);
            
            if (!query.startsWith("SELECT")) {  // update data
                        
                jta.append("perform database update\n");
         
                st.executeUpdate(query);
                        
                jta.append("encrypt and transmit data\n");
            
                DataObject encryptedToClient = prepareData("Database successfully updated\n");
                transmitData(encryptedToClient);              
                        
            }
                    
            // otherwise, the client wishes to display data
                    
            jta.append("determine the number of rows of data in the selected database table\n");
                    
            ResultSet rs= st.executeQuery(query);
                                       
            while(rs.next()) {
            
                rows++;
                        
            }
                    
            jta.append("determine the number of columns of data in the selected database table\n");
                    
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            int cells = rows * columns;

            // send client the number of cells in database table
            // so that the data can be properly displayed
                    
            jta.append("encrypt data\n");
                    
            DataObject cellsData = dataProcessor.encryptData(Integer.toString(cells));
            transmitData(cellsData);  
        
            // execute client's query
                    
            jta.append("get each desired cell from the table\n");
                    
            rs = st.executeQuery(query);
        
            while(rs.next()) {  // get next row from table
                        
                jta.append("get each cell in the row\n");
            
                for (int i = 1; i <= columns; i++) {
                      
                    jta.append("\nSending: " + rs.getString(i));
                            
                    jta.append("\nencrypt data");
                
                    DataObject serverEncryptedObject = dataProcessor.encryptData(rs.getString(i));
                    transmitData(serverEncryptedObject);
                           
                }
                        
            }
        
        } catch(SQLException ex) {
                
            // if client submits an invalid request
                
            String error1 = "************************************************\n";
            String error2 = "   ERROR!!! Incorrectly formatted request\n";
            String error3 = "************************************************\n\n";
                
            jta.append(error1 + error2 + error3);
                
            jta.append("\nencrypt data");
                
            DataObject error = prepareData(error1 + error2 + error3);
            transmitData(error);
                            
        } catch (Exception ex) {
            
        }
        
        dispose();
        
    }
    
    /**
     * Decrypt data from client
     * 
     * @return decrypted data
     */
    
    public String retrieveData() {
                
        try {
            
            DataProcessor dataProcessor = new DataProcessor();
            DataObject object = getEncryptedObject();
            
            String decryptedData = dataProcessor.decryptData(object);
            return decryptedData;
            
        } catch (Exception ex) {
            
            System.out.println(ex);
            
        }    
        
        return null;
        
    }
    
    /**
     * Encrypt data before sending it to the client
     * 
     * @param data data to be encrypted
     * @return data object to be returned
     */
    
    public DataObject prepareData(String data) {
                
        try {
            
            DataObject encryptedData;
            DataProcessor dataProcessor = new DataProcessor();
            encryptedData = dataProcessor.encryptData(data);
               
        } catch (Exception ex) {
            
        }
        
        return null;
        
    }
    
    /**
     * Send data to client
     * 
     * @param encryptedToClient data to be transferred
     */
    
    public void transmitData(DataObject encryptedToClient) {
        
        jta.append("transmit encrypted data\n");
        
        try {
                    
            ObjectOutputStream toClientInitial = new ObjectOutputStream(socket.getOutputStream());
            toClientInitial.writeObject(encryptedToClient);
            toClientInitial.flush();
                        
        } catch (IOException ex) {
            
        }
        
    }
    
    /**
     * DataObject setter method
     * 
     * @param encryptedObject object to be set
     */
    
    public void setEncryptedObject(DataObject encryptedObject) {
        
        this.encryptedObject = encryptedObject;
        
    }
    
    /**
     * DataObject getter method
     * 
     * @return current data object
     */
    
    public DataObject getEncryptedObject() {
        
        return encryptedObject;
        
    }
    
}