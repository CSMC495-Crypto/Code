package client;

public class DataObject implements java.io.Serializable {
    
    byte[] encryptedData;
    int[]key;
    
    public DataObject(byte[] encryptedData, int[] key) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        
    }
    
}
