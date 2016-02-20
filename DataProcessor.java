/*
 * Class: CMSC495
 * File: DataProcessor.java  
 * Author: Walter Baynard
 * 
 * Interface between client/server and data; performs encryption/decryption
 *
 * @Updated on 2/20/2016 by Jonathan Wojack: completed all methods
 *
 */

package client;

import java.security.Key;
import java.util.Random;
import javax.crypto.SecretKey;


/**
 *
 * @author waltbaynard
 */

public class DataProcessor implements java.io.Serializable 
{    
       
    public DataObject encryptData(String data) throws Exception {
        
        DataObject encryptedData;
        
        switch (getEncryptionAlgorithm()) {
            
            // AES encryption
            
            case 1:
                
                AES aes = new AES();
                encryptedData = aes.encrypt(data);
                
                break;
                
            //Blowfish encryption
                
            case 2:     
                
                BlowFish blowFish = new BlowFish();
                encryptedData = blowFish.encrypt(data);

                break;
                
            //XOR encryption
                
            case 3:
            default:
                
                XOR xor = new XOR();
                encryptedData = xor.encrypt(data);
                
                break;
                
        }   
        
        return encryptedData;
        
    }
    
    public String decryptData(DataObject encryptedData) throws Exception {
        
        String decryptedData = null;
        
        switch (encryptedData.encryptionAlgorithm) {
            
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
                System.out.println("Program will now terminate.");
                
                System.exit(1);
        }   
        
        return decryptedData;
    }
    
    public int getEncryptionAlgorithm() throws Exception
    {
        Random randomNumber = new Random();
        
        // get random number
        int getEncryptionSelector = randomNumber.nextInt(3) + 1;        
                        
        return getEncryptionSelector; 
        
    }   
    
}
