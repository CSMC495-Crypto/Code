package cryptography;

import data.DataObject;

/**
 * This class represents simple cryptographic program 
 * which encrypts and decrypts data
 * by XORing a binary key to each byte of data.
 * 
 * @author Jonathan Wojack
 */

/*
 * project Bank Encryption Application
 * course CSMC 495
 * date created 02/02/2016
 * updated on 02/14/2016 by Olga Kazlova and Grant Sweeney
 * updated on 2/20/2016 by Jonathan Wojack
 * updated by Grant Sweeney on 2/27/2016
 */

// Changes:
//
// 1. Changed package to cryptography 
// 2. Updated Javadoc comments

public class XOR implements Cryptography {
    
   // public static String plainText;
    
    public static Base64 base64 = new Base64();
    
    /**
     * This method encrypts plain text passed as an argument 
     * by XORing a binary key to each byte of the data 
     * 
     * @param plainText String
     * @return DataObject decodedData
     */
    
    public DataObject encrypt(String plainText) {         
        
        byte[] plainText64 = base64.encode(plainText.getBytes()).getBytes();
        
        Encrypt encrypt = new Encrypt(plainText64);
        
        DataObject encryptedObject = encrypt.encryptData();       
        
        return encryptedObject;
    }
    
    /**
     * This method decrypts encrypted text passed as a DataObject
     * argument by removing binary key to each byte of the data 
     * 
     * @return String decodedData
     */
    
    public String decrypt(DataObject encryptedData) {
        
        Decrypt decrypt = new Decrypt(encryptedData);
        
        byte[] decryptedData = decrypt.decryptData();
        
        String decodedData = new String(base64.decode(new String(decryptedData)));
                
        return decodedData;
        
    }        
        
}