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

import cryptography.DataProcessor;
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
    
    String username;
    String password;
  
    public JTextArea jta = new JTextArea();
    
    /**
     * Initialize server
     * 
     * @param args 
     */

    public static void main(String[] args) {
        
        new Server();
    
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
                    
                    DatabaseController bankingDOA = new DatabaseController(socket);
   
                    String[] loginCredentials = bankingDOA.processData(clientEncryptedObject, getUsername(), getPassword());
                    
                    setUsername(loginCredentials[0]);
                    setPassword(loginCredentials[1]);
                    
                    System.out.println("Server username: " + getUsername());
                    System.out.println("Server password: " + getPassword());
                    
                } 
                
            } catch (IOException|ClassNotFoundException ex) {
                            
            }
                    
        }
        
        
               
    }
            
}