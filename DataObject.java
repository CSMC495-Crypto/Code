package data;

import javax.crypto.SecretKey;

/**
 * object to store encrypted data and encryption key
 * to be send between communication parties to enable encrypted communications
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @updated on 02/19/2016 by Jonathan Wojack
 * @updated on 02/21/2016 by Olga Kazlova (added getSecretKey() and getEncryptedData()), package data;
 * 
 * 
 */
public class DataObject implements java.io.Serializable {
    
    byte[] encryptedData;
    int[]key;               // for XOR
    SecretKey secretKey;    // for AES and Blowfish
    
    // encryption algorithm identifier
    // 1 = AES
    // 2 = BlowFish
    // 3 = XOR
    
    int encryptionAlgorithm;
    
    // constructor for XOR algorithm, since it does not store key as SecretKey
    
    public DataObject(byte[] encryptedData, int[] key, String encryptionAlgorithm) {
        
        this.encryptedData = encryptedData;
        this.key = key;
        this.encryptionAlgorithm = getEncryptionAlgorithmDesignator(encryptionAlgorithm);
        
    }
    
    // constructor for AES and Blowfish algorithms
    
    public DataObject(byte[] encryptedData, SecretKey secretKey, String encryptionAlgorithm) {
        
        this.encryptedData = encryptedData;
        this.secretKey = secretKey;
        this.encryptionAlgorithm = getEncryptionAlgorithmDesignator(encryptionAlgorithm);
        
    }
    
    public int getEncryptionAlgorithmDesignator(String encryptionAlgorithm) {
        
        if (encryptionAlgorithm.startsWith("AES")) {
            
            return 1;
            
        }
        
        else if (encryptionAlgorithm.startsWith("BlowFish")) {
            
            return 2;
            
        }
        
        else if (encryptionAlgorithm.startsWith("XOR")) {
            
            return 3;
            
        }
        
        // invalid algorithm
        
        return -1;
        
    }
    
    public SecretKey getSecretKey(){
    	return secretKey;
    }
    
    public byte[] getEncryptedData(){
    	return encryptedData;
    }
    
}
