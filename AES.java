package client;

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
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date Updated on 02/09/2016
 * @updated on 02/14/2016 by Grant Sweeney
 * @updated on 2/19/2016 by Jonathan Wojack: code was encrypting/decrypting data 
 *  with both the AES and XOR algorithms; removed XOR code references from file
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
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyGenerator.init(128);
		secretKey = keyGenerator.generateKey();
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public DataObject encrypt(String plainText) {
		byte[] cipherBytes = null;

		// Initialize the cipher for encryption

		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Convert the text string to byte format

		byte[] plainBytes = plainText.getBytes();

		// Perform encryption with method doFinal()

		try {
			cipherBytes = cipher.doFinal(plainBytes);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	        DataObject encryptedObject = new DataObject(cipherBytes, secretKey, "AES");
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
	public String decrypt(DataObject encryptedData) {
		String plainText = null;
		
		try {

			// Initialize the cipher for decryption

			cipher.init(Cipher.DECRYPT_MODE, encryptedData.secretKey);

			// Perform decryption with method doFinal()

			byte[] plainBytes = cipher.doFinal(encryptedData.encryptedData);

			// Convert encrypted text to string format

			plainText = new String(plainBytes);
		} catch (IllegalBlockSizeException ex) {
			System.out.println(ex);
		} catch (BadPaddingException ex) {
			System.out.println(ex);
		} catch (InvalidKeyException ex) {
			System.out.println(ex);
		}

		return plainText;
	}

}
