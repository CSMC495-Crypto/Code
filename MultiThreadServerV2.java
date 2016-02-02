/*

Server program which provides multiple threading to enable multiple clients to connect simultaneously
Enables clients to access server-based SQL tables and to perform data and table manipulations and other services

Update: Report status in window while server is running

Author: Jonathan Wojack
Date: February 2, 2016
Filename: MultiThreadServerV2.java

*/

package client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.sql.*;

// set up and start GUI

public class MultiThreadServerV2 extends JFrame {
  
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        
    new MultiThreadServerV2();
    
    }
    
    // default constructor

    public MultiThreadServerV2() {
    
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

        // construct thread
    
        public HandleAClient(Socket socket) {
      
            this.socket = socket;
    
        }
        
        public void run() {
            
            jta.append("run thread\n");
      
            try {
                
                jta.append("create data input and output streams\n");
        
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                
                jta.append("continuously serve the client\n");
                
                while (true) {
                    
                    jta.append("\n\nget data from client\n");
            
                    DataObject clientEncryptedObject = null;
                    ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                    clientEncryptedObject = (DataObject) fromClient.readObject();
                    
                    jta.append("decrypt and report data\n");
                    
                    XOR xorDecrypt = new XOR("");
                    jta.append("Transmission from client encrypted: " + new String(clientEncryptedObject.encryptedData));
                    String clientDecrypted = xorDecrypt.decryptData(clientEncryptedObject);
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
        
                    String query=clientDecrypted;
        
                    if (!query.startsWith("SELECT")) {  // update data
                        
                        jta.append("perform database update\n");
         
                        st.executeUpdate(query);
                        
                        jta.append("encrypt data\n");
                    
                    XOR xorEncryptInitial = new XOR("Database updated.");
                    DataObject serverEncryptedObjectInitial = xorEncryptInitial.encryptData();
                    
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
                    
                    XOR xorEncryptInitial = new XOR(Integer.toString(cells));
                    DataObject serverEncryptedObjectInitial = xorEncryptInitial.encryptData();
                    
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
                            
                            XOR xorEncrypt = new XOR(rs.getString(i));
                            DataObject serverEncryptedObject = xorEncrypt.encryptData();
                            
                            jta.append("\nsend data to client\n");
           
                            ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
                            toClient.writeObject(serverEncryptedObject);
                            toClient.flush();
                            
                        }
                        
                    }
        
                }
        
            }
            
            catch(SQLException ex) {
               
            }
           
            catch(IOException e) {
        
                System.err.println(e);
      
            }
      
            catch(ClassNotFoundException x) {
          
            }
    
        }       
        
    }
  
}
