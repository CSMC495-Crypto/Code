package client;

import javax.crypto.SecretKey;

/**
 * object to store encrypted data and encryption key
 * to be send between communication parties to enable encrypted communications
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @updated on 02/19/2016 by Jonathan Wojack
 */
public class DataObject implements java.io.Serializable {
    
    byte[] encryptedData;
    int[]key;               // for XOR
    SecretKey secretKey;    // for AES and Blowfish
    
    // encryption algorithm identifier
    // possible values are "XOR", "Blowfish", "AES"
    
    String encryptionAlgorithm;
    
    // constructor for XOR algorithm, since it does not store key as SecretKey
    
    public DataObject(byte[] encryptedData, int[] key, String encryptionAlgorithm) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        this.encryptionAlgorithm = encryptionAlgorithm;
        
    }
    
    // constructor for AES and Blowfish algorithms
    
    public DataObject(byte[] encryptedData, SecretKey secretKey, String encryptionAlgorithm) {
        
        this.encryptedData = encryptedData;
        this.secretKey = secretKey;
        this.encryptionAlgorithm = encryptionAlgorithm;
        
    }
    
}
