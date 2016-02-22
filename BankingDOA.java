/**
 * Interface between the server and the database
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CMSC495
 * @date 2/21/2016
 */

package server;

import cryptography.DataProcessor;
import cryptography.XOR;
import data.DataObject;
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

public class BankingDOA extends Server {
   
    DataObject encryptedObject;
    Socket socket;
    
    public BankingDOA(Socket socket) {
        
        this.socket = socket;
        
    }
    
    /**
     * Process data from client
     * 
     * @param encryptedObject 
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
    
}