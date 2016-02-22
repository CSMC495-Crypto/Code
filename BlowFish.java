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
 * This class represents BlowFish algorithm. It generates a random key in its
 * constructor. Uses Base64 class for padding.
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date Updated on 02/09/2016
 * @updated on 02/14/2016 by Grant Sweeney
 * @updated on 2/19/2016 by Jonathan Wojack
 * @updated on 2/20/2016 by Jonathan Wojack
 * @updated on 2/21/2016 by Jonathan Wojack
 * 
 * Changes:
 * 
 * 1.  Replaced catch statements with multicatch statements
 * 2.  Removed printStackTrace statements
 * 3.  Added Override annotation
 * 4.  Beautified code
 * 
 */

public class BlowFish implements Cryptography {

    private KeyGenerator keyGenerator = null;
    private SecretKey secretKey = null;
    private Cipher cipher = null;

    /**
     * Constructor generates secret key for encryption.
     */
        
    public BlowFish() {

        try {

            // Generate a random key

            keyGenerator = KeyGenerator.getInstance("Blowfish");
            secretKey = keyGenerator.generateKey();

            // Create an instance of Cipher

            cipher = Cipher.getInstance("Blowfish");
	
        } catch (NoSuchPaddingException|NoSuchAlgorithmException ex) {
            
            System.out.println(ex);
	
        } 

    }

    /**
     * This method encrypts plain text passed as a parameter and returns an
     * object of DataObject
     * 
     * @param plainText
     *            String
     * @return encryptedObject DataObject
     */

    @Override
    public DataObject encrypt(String plainText) {

        byte[] cipherBytes = null;	

	try {
            
            // Initialize the cipher for encryption
            
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            // Convert the text string to byte format
            
            byte[] plainBytes = plainText.getBytes();
        
            // Perform encryption with method doFinal()
        
            cipherBytes = cipher.doFinal(plainBytes);
        
        } catch (InvalidKeyException|IllegalBlockSizeException|BadPaddingException ex) {
			
	}
        
        // store encrypted data in DataObject
        
        DataObject encryptedObject = new DataObject(cipherBytes, secretKey, "BlowFish");
        return encryptedObject;
	
    }

    /**
     * This method decrypts DataObject passed as a parameter and returns plain
     * text as a string
     * 
     * @param encryptedData
     *            DataObject
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

            // Convert decrypted text to string format

            plainText = new String(plainBytes);
	
        } catch (IllegalBlockSizeException|BadPaddingException|InvalidKeyException ex) {
		
            System.out.println(ex);
		
        } 

        return plainText;
	
    }

}
