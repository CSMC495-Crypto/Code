package client;

// object to store encrypted data and encryption key
// to be send between communication parties to enable encrypted communications

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
    
}
