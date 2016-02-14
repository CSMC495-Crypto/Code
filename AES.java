
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
 */
public class AES {

	static Cipher cipher;
	SecretKey secretKey;

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

		Encrypt encrypt = new Encrypt(cipherBytes);

		DataObject encryptedObject = encrypt.encryptData();

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
		Decrypt decrypt = new Decrypt(encryptedData);

		byte[] decryptedData = decrypt.decryptData();
		try {

			// Initialize the cipher for decryption

			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			// Perform decryption with method doFinal()

			byte[] plainBytes = cipher.doFinal(decryptedData);

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
