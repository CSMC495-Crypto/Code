package client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
    
   
  // Text field for receiving radius
  private JTextField jtf = new JTextField();

  // Text area to display contents
  private JTextArea jta = new JTextArea();

  // IO streams
  private DataOutputStream toServer;
  private DataInputStream fromServer;

  public static void main(String[] args) {
    new Client();
  }

  public Client() {
    // Panel p to hold the label and text field
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Enter data to encrypt"), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);
    jtf.setHorizontalAlignment(JTextField.RIGHT);

    setLayout(new BorderLayout());
    add(p, BorderLayout.NORTH);
    add(new JScrollPane(jta), BorderLayout.CENTER);

    jtf.addActionListener(new Listener()); // Register listener

    setTitle("Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
     // Socket socket = new Socket("localhost", 8000);
       Socket socket = new Socket("68.134.160.249", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(
        socket.getInputStream());

      // Create an output stream to send data to the server
      toServer =
        new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  private class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
          
          Socket socket = new Socket("68.134.160.249", 8000);
          
        // Get the radius from the text field
        String plainText = jtf.getText().trim();
        
        XOR xor = new XOR(plainText);
        
        DataObject clientEncryptedObject = xor.encryptData();
                
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

        // Send the radius to the server
        toServer.writeObject(clientEncryptedObject);
        toServer.flush();

        // Display to the text area
        
        jta.append("Connection established!\n\n");
        
        jta.append("Data to send to server:\n" + plainText);        
        jta.append("\n\nData encrypted as\n" + new String(clientEncryptedObject.encryptedData));
        
             // Get from the server
        
        DataObject serverEncryptedObject = null;
        
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
        
        serverEncryptedObject = (DataObject) fromServer.readObject();
        
        fromServer.close();
        
        jta.append("\n\nData has been decrypted and processed by the server");
        jta.append("\nand re-encrypted and sent back to the client as\n" + new String(serverEncryptedObject.encryptedData));        
        jta.append("\n\nDecrypted data: " + xor.decryptData(serverEncryptedObject));
        
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
      
      catch (ClassNotFoundException ex) {
          
      }
    }
  }
}
