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
 * This class represents BlowFish algorithm. It generates a random key in its
 * constructor. Uses Base64 class for padding.
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date Updated on 02/09/2016
 */
public class BlowFish {

	KeyGenerator keyGenerator = null;
	SecretKey secretKey = null;
	Cipher cipher = null;

	/**
	 * Constructor generates secret key for encryption.
	 */
	public BlowFish() {
		try {

			// Generate a random key

			keyGenerator = KeyGenerator.getInstance("Blowfish");
			secretKey = keyGenerator.generateKey();

			// Create an instance of cipher m

			cipher = Cipher.getInstance("Blowfish");
		} catch (NoSuchPaddingException ex) {
			System.out.println(ex);
		} catch (NoSuchAlgorithmException ex) {
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