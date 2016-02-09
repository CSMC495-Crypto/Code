package client;

/**
 * Interface that all encryption algorithm classes will implement
 * 
 * @author Grant Sweeney
 */
public interface Cryptography {
    
    /**
     * Encrypts given data
     * 
     * @param data Data to be encrypted
     * @return Encrypted data
     */
    public String encrypt(String data);
    
    /**
     * Decrypts given data
     * 
     * @param data Data to be decrypted
     * @return Original data
     */
    public String decrypt(String data);
    
} //end interface
