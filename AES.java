package cryptography;

import data.DataObject;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * This class represents AES algorithm. It generates a random key in its
 * constructor. Uses Base64 class for padding.
 * 
 * @author Olga Kazlova
 */

/*
 * project Bank Encryption Application
 * course CSMC 495
 * date Updated on 02/09/2016
 * updated on 02/14/2016 by Grant Sweeney
 * updated on 2/19/2016 by Jonathan Wojack
 * updated on 2/20/2016 by Jonathan Wojack
 * updated by Grant Sweeney on 2/27/2016
 * 
 * Changes:
 * 
 * 1.  Changed package to cryptography
 * 2.  decrypt method accesses secretKey and encryptedData fields by using getter
 *  methods in DataObject
 * 3.  Beautified code
 * 
 */

public class AES implements Cryptography {

    private static Cipher cipher;
    private SecretKey secretKey;

    /**
     * Constructor generates secret key for encryption.
     */
        
    public AES() {
            
        KeyGenerator keyGenerator = null;
	
        try {
	
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
            cipher = Cipher.getInstance("AES");
        
        } catch (NoSuchAlgorithmException|NullPointerException|NoSuchPaddingException ex) {
		
        }

    }

    /**
     * This method encrypts plain text passed as a parameter and returns an
     * object of DataObject
     * 
     * @param plainText String
     * @return encryptedObject DataObject
     */
	
    @Override
    public DataObject encrypt(String plainText) {
                
        byte[] cipherBytes = null;

        // Initialize the cipher for encryption

        try {
	
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
        } catch (InvalidKeyException e) {

        }

        // Convert the text string to byte format

        byte[] plainBytes = plainText.getBytes();

        // Perform encryption with method doFinal()

        try {
	
            cipherBytes = cipher.doFinal(plainBytes);
		
        } catch (IllegalBlockSizeException|BadPaddingException ex) {
			
        } 

        DataObject encryptedObject = new DataObject(cipherBytes, secretKey, "AES");
        return encryptedObject;
                
    }

    /**
     * This method decrypts DataObject passed as a parameter and returns plain
     * text as a string
     * 
     * @param encryptedData DataObject
     * @return plainText String
     */
        
    @Override
    public String decrypt(DataObject encryptedData) {
	
        String plainText = null;
		
        try {

            // Initialize the cipher for decryption

            cipher.init(Cipher.DECRYPT_MODE, encryptedData.getSecretKey());

            // Perform decryption with method doFinal()

            byte[] plainBytes = cipher.doFinal(encryptedData.getEncryptedData());

            // Convert encrypted text to string format

            plainText = new String(plainBytes);
	
        } catch (IllegalBlockSizeException|BadPaddingException|InvalidKeyException ex) {
            System.out.println(ex);
            
        } 

        return plainText;
	
    }

}