/**
 * Server program which provides multiple threading to enable multiple clients to connect simultaneously
 * Enables clients to access server-based SQL tables and to perform data and table manipulations and other services
 *
 * @Author: Jonathan Wojack
 * @Project: Bank Encryption Application
 * @Course: CMSC495
 * @Updated on 2/21/2016 by Jonathan Wojack
 * 
 * Changes:
 * 
 * 1.  Changed package to server
 * 2.  Changed line 162 to:
 * 
 *  jta.append("Transmission from client encrypted: " + new String(clientEncryptedObject.getEncryptedData()));
 * 
 *  with the new getter method in DataObject
 * 3.  Added Javadoc comments
 * 4.  Beautified code
 */

package server;

import data.DataObject;
import cryptography.XOR;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.sql.*;

// set up and start GUI

public class Server extends JFrame {
  
    private JTextArea jta = new JTextArea();
    
    /**
     * Initialize server
     * 
     * @param args 
     */

    public static void main(String[] args) {
        
        new Server();
    
    }
    
    // default constructor

    public Server() {
    
        // GUI

        // set window to auto-scroll
      
        DefaultCaret caret = (DefaultCaret)jta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
      
        // configure remaining applicable GUI parameters
        
        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);
        setTitle("Server");
        setLocation(1000, 50);
        setSize(500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
      
            // enable client to connect to server on TCP port 8000
            
            ServerSocket serverSocket = new ServerSocket(8000);
      
            // report status
            
            jta.append("Server started at " + new java.util.Date() + '\n');

            // number client
      
            int clientNo = 1;

            // wait for client to connect
            
            while (true) {
        
                Socket socket = serverSocket.accept();

                // Display client number
        
                jta.append("\n\nStarting thread for client " + clientNo + " at " + new java.util.Date() + '\n');

                // report the client's host name and IP address
                
                InetAddress inetAddress = socket.getInetAddress();
                jta.append("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
                jta.append("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
                
                jta.append("\ncreate a new thread for the connection\n");
                
                HandleAClient task = new HandleAClient(socket);
                
                jta.append("start a new thread\n");
        
                new Thread(task).start();

                jta.append("increment clientNo\n");
        
                clientNo++;
      
            }
            
        }
        
        catch(IOException ex) {
      
            System.err.println(ex);
    
        }
  
    }

    // inner class; defines the thread class for handling new connection
  
    class HandleAClient implements Runnable {
    
        // handle connection
        
        private Socket socket;

        // constructor creates a thread
    
        public HandleAClient(Socket socket) {
      
            this.socket = socket;
    
        }
        
        /**
         * Start server
         */
        
        public void run() {
            
            jta.append("run thread\n");
      
            try {
                
                jta.append("create data input and output streams\n");
        
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                
                jta.append("continuously serve the client\n");
                
                while (true) {
                    
                    jta.append("\n\nget data from client\n");                    
                    jta.append("create DataObject\n");
            
                    DataObject clientEncryptedObject = null;
                    
                    jta.append("create ObjectInputStream\n");
                            
                    ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                    
                    jta.append("read object from client\n");
                    
                    clientEncryptedObject = (DataObject) fromClient.readObject();
                    
                    jta.append("decrypt and report data\n");
                    
                    XOR xorDecrypt = new XOR();
                    
                    jta.append("Transmission from client encrypted: " + new String(clientEncryptedObject.getEncryptedData()));
                    String clientDecrypted = xorDecrypt.decrypt(clientEncryptedObject);
                    
                    jta.append("\nDecrypted: " + clientDecrypted);
                    jta.append("\naccess SQL database\n");
                    
                    String connUrl="jdbc:mysql://localhost:3306/cmsc495";
                    String username="default";
                    String password="superSecretPassword";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(connUrl,username,password);
                    Statement st = conn.createStatement();
                    
                    jta.append("rows of data in database table to be selected\n");
                    
                    int rows = 0;  
                    
                    jta.append("determine whether client desires to display or modify data\n");
        
                    String query = clientDecrypted;
        
                    if (!query.startsWith("SELECT")) {  // update data
                        
                        jta.append("perform database update\n");
         
                        st.executeUpdate(query);
                        
                        jta.append("encrypt data\n");
                    
                        XOR xorEncryptInitial = new XOR();
                        DataObject serverEncryptedObjectInitial = xorEncryptInitial.encrypt("Database successfully updated\n");
                    
                        jta.append("transmit encrypted data\n");
                    
                        ObjectOutputStream toClientInitial = new ObjectOutputStream(socket.getOutputStream());
                        toClientInitial.writeObject(serverEncryptedObjectInitial);
                        toClientInitial.flush();
                        
                        continue;  // wait for next transmission from client...
                        
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
                    
                    XOR xorEncryptInitial = new XOR();
                    DataObject serverEncryptedObjectInitial = xorEncryptInitial.encrypt(Integer.toString(cells));
                    
                    jta.append("transmit encrypted data\n");
                    
                    ObjectOutputStream toClientInitial = new ObjectOutputStream(socket.getOutputStream());
                    toClientInitial.writeObject(serverEncryptedObjectInitial);
                    toClientInitial.flush();
         
                    // execute client's query
                    
                    jta.append("get each desired cell from the table\n");
                    
                    rs = st.executeQuery(query);
        
                    while(rs.next()) {  // get next row from table
                        
                        jta.append("get each cell in the row\n");
            
                        for (int i = 1; i <= columns; i++) {
                      
                            jta.append("\nSending: " + rs.getString(i));
                            
                            jta.append("\nencrypt data");
                            
                            XOR xorEncrypt = new XOR();
                            DataObject serverEncryptedObject = xorEncrypt.encrypt(rs.getString(i));
                            
                            jta.append("\nsend data to client\n");
           
                            ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
                            toClient.writeObject(serverEncryptedObject);
                            toClient.flush();
                            
                        }
                        
                    }
        
                }
        
            }
            
            catch(SQLException ex) {
                
                // if client submits an invalid request
                
                String error1 = "************************************************\n";
                String error2 = "   ERROR!!! Incorrectly formatted request\n";
                String error3 = "************************************************\n\n";
                
                jta.append(error1 + error2 + error3);
                
                jta.append("\nencrypt data");
                            
                XOR xorEncrypt = new XOR();
                DataObject serverEncryptedObject = xorEncrypt.encrypt(error1 + error2 + error3);
                            
                jta.append("\nsend data to client\n");
                            
                try {
           
                    ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
                    toClient.writeObject(serverEncryptedObject);
                    toClient.flush();
                            
                }
                            
                catch (IOException ex1) {
                            
                }
                
            }
           
            catch(IOException|ClassNotFoundException ex) {
        
            }
    
        }       
        
    }
  
}