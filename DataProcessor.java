/**
 * Interface between client/server and data; performs encryption/decryption
 *
 * @author Walter Baynard
 */

/*
 * Class: CMSC495
 * File: DataProcessor.java  
 * Author: Walter Baynard
 *
 * Completed on 2/20/2016 by Jonathan Wojack
 * Updated on 2/20/2016 by Jonathan Wojack
 * updated by Grant Sweeney on 2/27/2016
 *
 * Changes:
 * 
 * 1.  Changed package to cryptography
 * 2.  Accesses getter method in DataObject to get encryption algorithm
 * 3.  Updated Javadoc comments
 * 
 */

package cryptography;

import data.DataObject;
import java.security.Key;
import java.util.Random;
import javax.crypto.SecretKey;

public class DataProcessor implements java.io.Serializable {
    
    public DataProcessor() {
        
    }
    
    /**
     * Encrypts data using random encryption algorithm (XOR by default)
     * 
     * @param data String to be encrypted
     * @return encrypted data
     * @throws Exception error encrypting
     */
       
    public DataObject encryptData(String data) throws Exception {
        
        DataObject encryptedData;               // object to store encrypted data
        
        switch (getEncryptionAlgorithm()) {     // retrieves random encryption algorithm
            
            // AES encryption
            
            case 1:
                
                AES aes = new AES();
                encryptedData = aes.encrypt(data);
                System.out.println("AES");
                
                break;
                
            //Blowfish encryption
                
            case 2:     
                
                BlowFish blowFish = new BlowFish();
                encryptedData = blowFish.encrypt(data);
                System.out.println("BlowFish");

                break;
                
            //XOR encryption
                
            case 3:
            default:
                
                XOR xor = new XOR();
                encryptedData = xor.encrypt(data);
                System.out.println("XOR");
                
                break;
                
        }   
        
        return encryptedData;
        
    }
    
    /**
     * Decrypts data from DataObject object which stores encrypted data, encryption key, 
     * and encryption algorithm
     * 
     * @param encryptedData data to decrypt
     * @return data
     * @throws Exception error in method
     */
    
    public String decryptData(DataObject encryptedData) throws Exception {
        
        String decryptedData = null;                        // String to store decrypted data
        
        switch (encryptedData.getEncryptionAlgorithm()) {   // get encryption algorithm
            
            //AES decryption
            
            case 1:
            
                AES aes = new AES();
                decryptedData = aes.decrypt(encryptedData);
                
                break;
            
            // BlowFish decryption
                
            case 2:                
                           
                BlowFish blowFish = new BlowFish();
                decryptedData = blowFish.decrypt(encryptedData);
                
                break;
                
            //XOR encryption
                
            case 3:
                
                XOR xor = new XOR();
                decryptedData = xor.decrypt(encryptedData);
                
                break;
                
            // invalid algorithm indicator
                
            default:                
                
                System.out.println("ERROR!!! Invalid decryption algorithm!");
                System.out.println("Algorithm " + encryptedData.getEncryptionAlgorithm());
                System.out.println("Program will now terminate.");
                
            //    System.exit(1);
                
        }   
        
        return decryptedData;
        
    }
    
    /**
     * Get random integer to select encryption algorithm at random
     * 
     * @return integer representing algorithm choice
     */
    
    public int getEncryptionAlgorithm() {
        
        Random randomNumber = new Random();
        
        // get random number
        
        int getEncryptionSelector = randomNumber.nextInt(3) + 1;        
                        
        return getEncryptionSelector; 
        
    }   
    
}
