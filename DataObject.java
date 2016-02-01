package client;

// object to store encrypted data and encryption key
// to be send between communication parties to enable encrypted communications

public class DataObject implements java.io.Serializable {
    
    byte[] encryptedData;
    int[]key;
    
    public DataObject(byte[] encryptedData, int[] key) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        
    }
    
}
