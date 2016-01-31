package client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.sql.*;

public class MultiThreadServerV2 extends JFrame {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();


  public static void main(String[] args) {
    new MultiThreadServerV2();
  }

  public MultiThreadServerV2() {
    // Place text area on the frame
      
   DefaultCaret caret = (DefaultCaret)jta.getCaret();
 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
      
    setLayout(new BorderLayout());
    add(new JScrollPane(jta), BorderLayout.CENTER);

    setTitle("MultiThreadServer");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      jta.append("MultiThreadServer started at " + new java.util.Date() + '\n');

      // Number a client
      int clientNo = 1;

      while (true) {
        // Listen for a new connection request
        Socket socket = serverSocket.accept();

        // Display the client number
        jta.append("\n\nStarting thread for client " + clientNo +
          " at " + new java.util.Date() + '\n');

        // Find the client's host name, and IP address
        InetAddress inetAddress = socket.getInetAddress();
        jta.append("Client " + clientNo + "'s host name is "
          + inetAddress.getHostName() + "\n");
        jta.append("Client " + clientNo + "'s IP Address is "
          + inetAddress.getHostAddress() + "\n");

        // Create a new thread for the connection
        HandleAClient task = new HandleAClient(socket);

        // Start the new thread
        new Thread(task).start();

        // Increment clientNo
        clientNo++;
      }
    }
    catch(IOException ex) {
      System.err.println(ex);
    }
  }

  // Inner class
  // Define the thread class for handling new connection
  class HandleAClient implements Runnable {
    private Socket socket; // A connected socket

    /** Construct a thread */
    public HandleAClient(Socket socket) {
      this.socket = socket;
    }

    /** Run a thread */
    public void run() {
      try {
        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
          socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
          socket.getOutputStream());

        // Continuously serve the client
        while (true) {
          // Receive radius from the client
            
           DataObject clientEncryptedObject = null;
           ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
           clientEncryptedObject = (DataObject) fromClient.readObject();
         //  fromClient.close();
           
           XOR xorDecrypt = new XOR("");
           
           jta.append("Transmission from client encrypted: " + new String(clientEncryptedObject.encryptedData));
           
           String clientDecrypted = xorDecrypt.decryptData(clientEncryptedObject);
           
           
           String connUrl="jdbc:mysql://localhost:3306/cmsc495";
        String username="default";
        String password="superSecretPassword";
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connUrl,username,password);
        Statement st = conn.createStatement();
        
        int rows = 0;
        
        
        
        
        String query="select * from Customer";
        ResultSet rs= st.executeQuery(query);
        
        while(rs.next()) {
            
            rows++;
        }
        ResultSetMetaData rsmd = rs.getMetaData();

int columnsNumber = rsmd.getColumnCount();

System.out.println("\n" + rows + "\n" + columnsNumber);
        
        XOR xorEncryptInitial = new XOR(Integer.toString(rows));
        XOR xorEncryptInitial2 = new XOR(Integer.toString(columnsNumber));
       //    String encryptedText = new String(xorEncrypt.encryptData().encryptedData);
            System.out.println(Integer.toString(rows));
            System.out.println(Integer.toString(columnsNumber));
            
       DataObject serverEncryptedObjectInitial = xorEncryptInitial.encryptData();
       DataObject serverEncryptedObjectInitial2 = xorEncryptInitial2.encryptData();
       //    jta.append("\nMirror original transmission back to client, encrypted as\n" + new String(xorEncrypt.encryptData().encryptedData));
           
           
           ObjectOutputStream toClientInitial = new ObjectOutputStream(socket.getOutputStream());
           toClientInitial.writeObject(serverEncryptedObjectInitial);
           toClientInitial.flush();
           
           ObjectOutputStream toClientInitial2 = new ObjectOutputStream(socket.getOutputStream());
           toClientInitial2.writeObject(serverEncryptedObjectInitial2);
           toClientInitial2.flush();
        
        rs = st.executeQuery(query);
        
        
        
       
         
        while(rs.next())
        {
            
            for (int i = 1; i <= 7; i++) {
          //  jta.append("\n\nUsername - "+rs.getString(1)+" Password -"+rs.getString(2));
            
            XOR xorEncrypt = new XOR(rs.getString(i));
       //    String encryptedText = new String(xorEncrypt.encryptData().encryptedData);
            
            jta.append("Sending: " + rs.getString(i));
       DataObject serverEncryptedObject = xorEncrypt.encryptData();
        //   jta.append("\nMirror original transmission back to client, encrypted as\n" + new String(xorEncrypt.encryptData().encryptedData));
           
           
           ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
           toClient.writeObject(serverEncryptedObject);
           toClient.flush();
            }
        }
        
           
           XOR xorEncrypt = new XOR("EOF");
       //    String encryptedText = new String(xorEncrypt.encryptData().encryptedData);
            
            jta.append("EOF");
       DataObject serverEncryptedObject = xorEncrypt.encryptData();
       //    jta.append("\nMirror original transmission back to client, encrypted as\n" + new String(xorEncrypt.encryptData().encryptedData));
           
           
           ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
           toClient.writeObject(serverEncryptedObject);
           toClient.flush();
           
           
           
           jta.append(clientDecrypted);
           
           
           
        }
      }catch(SQLException ex) {
               
           }
           
      catch(IOException e) {
        System.err.println(e);
      }
      catch(ClassNotFoundException x) {
          
      }
    }
  }
}
