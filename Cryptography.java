package client;

/**
 * Interface that all encryption algorithm classes will implement
 * 
 * @author Grant Sweeney
 * 
 * @updated by Olga Kazlova on 02/14/2016
 * 
 */

// Changes: 
// 1. return value of encrypt(String) was changed from String to DataObject
// 2. arguments of decrupt method was changed from String to DataObject

public interface Cryptography {
    
    /**
     * Encrypts given data
     * 
     * @param data Data to be encrypted
     * @return DataObjrct encrypted data 
     */
    public DataObject encrypt(String data);
    
    /**
     * Decrypts given data
     * 
     * @param DataObject to be decrypted
     * @return Original data
     */
    public String decrypt(DataObject data);
    
} //end interface
