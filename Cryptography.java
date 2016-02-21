package cryptography;

import data.DataObject;

/**
 * Interface that all encryption algorithm classes will implement
 * 
 * @author Grant Sweeney
 * 
 * @updated by Olga Kazlova on 02/14/2016
 * @updated by Jonathan Wojack on 2/20/2016
 * 
 */

// Changes: 
//
// Changed package to cryptography

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
