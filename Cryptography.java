package cryptography;

import data.DataObject;

/**
 * Interface that all encryption algorithm classes will implement
 * 
 * @author Grant Sweeney
 */

/*
 * updated by Olga Kazlova on 02/14/2016
 * updated by Jonathan Wojack on 2/20/2016
 * updated by Jonathan Wojack on 2/21/2016
 * updated by Grant Sweeney on 2/27/2016
 * 
 * Corrected Javadoc comments
 */

public interface Cryptography {
    
    /**
     * Encrypts given data
     * 
     * @param data Data to be encrypted
     * @return DataObject encrypted data 
     */
    
    public DataObject encrypt(String data);
    
    /**
     * Decrypts given data
     * 
     * @param data to be decrypted
     * @return Original data
     */
    
    public String decrypt(DataObject data);
    
}
