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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
      //      System.out.println(query);
            
            
        
            String connUrl = "jdbc:mysql://localhost:3306/cmsc495";
            username = getUsername();
            password = getPassword();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connUrl, username, password);
            Statement st = conn.createStatement();
            
       //     System.out.println("Username: " + username);
         //   System.out.println("Password: " + password);
                    
            jta.append("rows of data in database table to be selected\n");
                    
            int rows = 0;  
                    
            jta.append("determine whether client desires to display or modify data\n");
        
            
            jta.append(query);
            
            System.out.println(query);
            
            if (query.startsWith("Login")) {  // update data
                        
                     System.out.println("Login...");
                     
                               
            username = getUsername();
            password = getPassword();
            Class.forName("com.mysql.jdbc.Driver");
            Connection loginConn = DriverManager.getConnection(connUrl, username, password);
            Statement loginSt = loginConn.createStatement();
            
         //   System.out.println(".....");
            
          //  ResultSet rs = st.executeQuery("SELECT * FROM personData");
            
            ResultSet loginRs = loginSt.executeQuery("SELECT employeeStatus FROM personData WHERE Username='" + 
                    username + "';");
            

            
       //     System.out.println("ResultSet...");
            
            loginRs.next();
            System.out.println(loginRs.getString(1));
            
            DataObject encryptedToClient = prepareData(loginRs.getString(1));
            transmitData(encryptedToClient);
            
            
        //    System.out.println(".....");
            
                         
               //         DataObject encryptedToClient = prepareData("Error: Incorrect username or password");
             //   transmitData(encryptedToClient);
                         
                     }
                        
            
            
            else if (query.startsWith("getRows")) {
                
                String[] getRows = query.split(" ");
                
                ResultSet rs = st.executeQuery("SELECT * FROM " + getRows[1]);
                rs = st.executeQuery("SELECT COUNT(*) FROM " + getRows[1]);
                rs.next();
                int rowCount = rs.getInt(1);
                rowCount++;
                DataObject encryptedToClient = prepareData(Integer.toString(rowCount));
                transmitData(encryptedToClient);
                
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
            
            DataObject columnsData = dataProcessor.encryptData(Integer.toString(columns));
            transmitData(columnsData);  
        
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
                
                ResultSet rs = st.executeQuery("SELECT ROW_COUNT();");
                rs.next();
                
                String result = "Error: No records updated";
                
                if (rs.getInt(1) > 0) {
                    
                    result = "Update successful";
                    
                }
                        
                jta.append("encrypt and transmit data\n");
            
                DataObject encryptedToClient = prepareData(result);
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
            
            System.out.println (decryptedData);
            
            if (decryptedData.startsWith("Login")) {
                
                System.out.println("Starts with login....");
            
            String[] loginCredentials = decryptedData.split(" ", 3);
            
            setUsername(loginCredentials[1]);
            setPassword(loginCredentials[2]);
            
            
	        try {

	 FileWriter writer = new FileWriter("LoginCredentials.dat");

	           System.out.println("Username: " + getUsername() + " Password: " + getPassword());

	            writer.write(getUsername());
                    writer.write("\n" + getPassword());

	 

	     /*   } catch (IOException e) {

	 

	            System.err.println("Error writing the file : ");

	            e.printStackTrace();

	 

	        } 
	 */
                        writer.close();
	            

	            } catch(IOException ex) {
                        
                        System.out.println("IOException!");
                        
                    }

	 

	        
            
            
            /*
            LoginCredentials loginCreds = new LoginCredentials(getUsername(), getPassword());
            
            FileOutputStream login = new FileOutputStream("loginCredentials");
            ObjectOutputStream save = ObjectOutputStream(login);
            save.writeObject(loginCreds);
            save.close();
            */
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
        
        System.out.println("Data: " + data);
               
        try {
            
            DataProcessor dataProcessor = new DataProcessor();
            return dataProcessor.encryptData(data);
               
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
        
        try {

	 FileWriter writer = new FileWriter("username.dat");        

	            writer.write(username);     
                        writer.close();
	            

	            } catch(IOException ex) {
                        
                        System.out.println("IOException!");
                        
                    }
        
       this.username = username;
        
    }
    
    public void setPassword(String password) {
        
       try {

	 FileWriter writer = new FileWriter("password.dat");        

	            writer.write(password);     
                        writer.close();
	            

	            } catch(IOException ex) {
                        
                        System.out.println("IOException!");
                        
                    }
        
       this.password = password;
        
    }
    
    public String getUsername() {
        
String username = null;
try {

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("username.dat")));
    
    username = br.readLine();
    br.close();

} catch (IOException e) {
    System.out.println("ERROR: unable to read file username.dat");
    e.printStackTrace();   
}



System.out.println("Read username " + username);
        
        return username;
        
    }
    
    public String getPassword() {
        
        

String password = null;
try {

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("password.dat")));
    
    password = br.readLine();
    br.close();

} catch (IOException e) {
    System.out.println("ERROR: unable to read file password.dat");
    e.printStackTrace();   
}



System.out.println("Read password " + password);
        
        return password;
    
}
    
}