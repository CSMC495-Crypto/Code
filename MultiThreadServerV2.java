/*

Server program which provides multiple threading to enable multiple clients to connect simultaneously
Enables clients to access server-based SQL tables and to perform data and table manipulations and other services

Author: Jonathan Wojack
Date: February 1, 2016
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

                // create a new thread for the connection
                
                HandleAClient task = new HandleAClient(socket);

                // start a new thread
        
                new Thread(task).start();

                // increment clientNo
        
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

        // run thread
        
        public void run() {
      
            try {
        
                // create data input and output streams
        
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                // continuously serve the client
                
                while (true) {
          
                    // get data from client
            
                    DataObject clientEncryptedObject = null;
                    ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                    clientEncryptedObject = (DataObject) fromClient.readObject();
         
                    // decrypt and report data
                    
                    XOR xorDecrypt = new XOR("");
                    jta.append("Transmission from client encrypted: " + new String(clientEncryptedObject.encryptedData));
                    String clientDecrypted = xorDecrypt.decryptData(clientEncryptedObject);
                    jta.append("\nDecrypted: " + clientDecrypted);
           
                    // access SQL database
                    
                    String connUrl="jdbc:mysql://localhost:3306/cmsc495";
                    String username="default";
                    String password="superSecretPassword";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(connUrl,username,password);
                    Statement st = conn.createStatement();
        
                    // rows of data in database table to be selected
                    
                    int rows = 0;        
                    
                    // determine whether client desires to display or modify data
        
                    String query=clientDecrypted;
        
                    if (!query.startsWith("SELECT")) {  // update data
         
                        st.executeUpdate(query);  // perform database update
                        continue;  // wait for next transmission from client...
                        
                    }
                    
                    // otherwise, the client wishes to display data
       
                    // determine the number of rows of data in the selected database table
                    
                    ResultSet rs= st.executeQuery(query);
                                       
                    while(rs.next()) {
            
                        rows++;
                        
                    }
                    
                    // determine the number of columns of data in the selected database table
                    
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columns = rsmd.getColumnCount();
                    int cells = rows * columns;

                    // send client the number of cells in database table
                    // so that the data can be properly displayed
                    
                    // encrypt data
                    
                    XOR xorEncryptInitial = new XOR(Integer.toString(cells));
                    DataObject serverEncryptedObjectInitial = xorEncryptInitial.encryptData();
      
                    // transmit encrypted data
                    
                    ObjectOutputStream toClientInitial = new ObjectOutputStream(socket.getOutputStream());
                    toClientInitial.writeObject(serverEncryptedObjectInitial);
                    toClientInitial.flush();
         
                    // execute client's query
                    
                    // get each desired cell from the table
                    
                    rs = st.executeQuery(query);
        
                    while(rs.next()) {  // get next row from table
                        
                        // get each cell in the row
            
                        for (int i = 1; i <= columns; i++) {
                      
                            jta.append("Sending: " + rs.getString(i));
                            
                            // encrypt data
                            
                            XOR xorEncrypt = new XOR(rs.getString(i));
                            DataObject serverEncryptedObject = xorEncrypt.encryptData();
        
                            // send data to client
           
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
