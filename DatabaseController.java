/**
 * Database controller
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CMSC495
 * @date 2/21/2016
 * @updated by Jonathan Wojack on 2/23/2016
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
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DatabaseController extends Server {
   
    DataObject encryptedObject;
    Socket socket;
    String username;
    String password;
    
    public DatabaseController(Socket socket) {
        
        this.socket = socket;
        
    }
    
    /**
     * Process data from client
     * 
     * @param encryptedObject
     * @param username
     * @param password
     * @return loginCredentials
     */
    
    public String[] processData(DataObject encryptedObject, String username, String password) {
        
        try {
            
            DataProcessor dataProcessor = new DataProcessor();
        
            setEncryptedObject(encryptedObject);
            String query = retrieveData();     
            System.out.println(query);
            
            
        
            String connUrl = "jdbc:mysql://localhost:3306/cmsc495";
            String username = getUsername();
            String password = getPassword();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connUrl, username, password);
            Statement st = conn.createStatement();
                    
            jta.append("rows of data in database table to be selected\n");
                    
            int rows = 0;  
                    
            jta.append("determine whether client desires to display or modify data\n");
        
            
            jta.append(query);
            
            if (query.startsWith("Login")) {  // update data
                        
                     
                     
                     String s = "";
                     
                     Process p = Runtime.getRuntime().exec("mysql -h localhost -u " + getUsername() + " -p" + getPassword());
                     BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                     while ((s = stdInput.readLine()) != null) {
                         
                         if (s.startsWith("ERROR")) {
                             
                             s = "Error: Incorrect Username or Password";
                             
                         }
                         
                         else {
                             
                             s = "Successful login";
                             
                         }
                         
                         DataObject encryptedToClient = prepareData(s);
                transmitData(encryptedToClient);
                         
                     }
                        
            }
            
            else if (query.startsWith("getRows")) {
                
                String 
                
            }
            
            else if (query.startsWith("SELECT")) {
            
            
                    
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
            
            }
            
            else {
                    
                    jta.append("perform database update\n");
         
                st.executeUpdate(query);
                        
                jta.append("encrypt and transmit data\n");
            
                DataObject encryptedToClient = prepareData("Database successfully updated\n");
                transmitData(encryptedToClient); 
                    
                    }
        
        } catch(SQLException ex) {
                
            // if client submits an invalid request
                
            jta.append("\nencrypt data");
                
            DataObject error = prepareData("Error");
            transmitData(error);
                            
        } catch (Exception ex) {
            
        }        
        
        dispose();
        
        String[] storeLoginCredentials = {getUsername(), getPassword()};
        
        return storeLoginCredentials;
        
    }
    
    /**
     * Decrypt data from client
     * 
     * @return 
     */
    
    public String retrieveData() {
                
        try {
            
            DataProcessor dataProcessor = new DataProcessor();
            DataObject object = getEncryptedObject();
            
            String decryptedData = dataProcessor.decryptData(object);
            
            if (decryptedData.startsWith("Login")) {
            
            String[] loginCredentials = decryptedData.split(" ", 3);
            
            setUsername(loginCredentials[1]);
            setPassword(loginCredentials[2]);
            
            return loginCredentials[0];
            
            }
            
            return decryptedData;
            
        } catch (Exception ex) {
            
            System.out.println(ex);
            
        }    
        
        return null;
        
    }
    
    /**
     * Encrypt data before sending it to the client
     * 
     * @param data
     * @return 
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
     * @param encryptedToClient 
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
     * @param encryptedObject 
     */
    
    public void setEncryptedObject(DataObject encryptedObject) {
        
        this.encryptedObject = encryptedObject;
        
    }
    
    /**
     * DataObject getter method
     * 
     * @return 
     */
    
    public DataObject getEncryptedObject() {
        
        return encryptedObject;
        
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