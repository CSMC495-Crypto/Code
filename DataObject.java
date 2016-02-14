package client;

/**
 * object to store encrypted data and encryption key
 * to be send between communication parties to enable encrypted communications
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @updated on 02/14/2016 by Grant Sweeney
 */
public class DataObject implements java.io.Serializable {
    
    byte[] encryptedData;
    int[]key;
    
    // encryption algorithm identifier
    // possible values are "XOR", "Blowfish", "AES"
    String encryptionAlgorithm;
    
    public DataObject(byte[] encryptedData, int[] key, String encryptionAlgorithm) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        this.encryptionAlgorithm = encryptionAlgorithm;
        
    }
    
    public DataObject(byte[] encryptedData, int[] key) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        
    }
    
}
