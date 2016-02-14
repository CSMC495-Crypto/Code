package client;

/**
 * This class represents simple cryptographic program 
 * which encrypts and decrypts data
 * by XORing a binary key to each byte of data.
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date created 02/02/2016
 * @updated on 02/14/2016 by Olga Kazlova 
 */

//Changes:
// 1. method name changed from encryptData to encrypt to match interface
// 2. Constructor that initializes a value to String plainText removed
// 3. String plainText is passed as argument to encrypt method to match interface
// 4. method name decryptData is changed to 'decrypt' to match interface
//   added JavaDoc for the class and methods

public class XOR implements Cryptography {
    
   // public static String plainText;
    public static Base64 base64 = new Base64();
    //public XOR(String plainText) {
        
   //     this.plainText = plainText;
        
   // }
    
    /**
     * This method encrypts plain text passed as an argument 
     * by XORing a binary key to each byte of the data 
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
     * @param DataObject encryptedData
     * @return String decodedData
     */
    
    public String decrypt(DataObject encryptedData) {
        
        Decrypt decrypt = new Decrypt(encryptedData);
        
        byte[] decryptedData = decrypt.decryptData();
        
        String decodedData = new String(base64.decode(new String(decryptedData)));
                
        return decodedData;
        
    }
        
        
    }
