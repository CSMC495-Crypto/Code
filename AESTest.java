package test;

import static org.junit.Assert.*;

/**
 * This JUnit test case tests methods of class AES
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date 02/14/2016
 * @updated 02/21/2016 by Olga Kazlova Changed package, updated with getters from DataObject
 * 
 **/


import org.junit.Test;

import cryptography.AES;
import cryptography.Base64;

import data.DataObject;

public class AESTest {

	AES aes = new AES();

	@Test
	public void testEncrypt() {
		String text1 = "Test case 1";
		String text2 = "Test case 2";
		String text3 = "Test case 3";
		// test case 1
		System.out.println("\nText before Encryption: " + text1);
		DataObject cipherText1 = aes.encrypt(text1);
		String plainText1 = Base64.encode(cipherText1.getEncryptedData());
		System.out.println("Cipher Text: " + plainText1);
		// test case 2
		System.out.println("\nText before Encryption: " + text2);
		DataObject cipherText2 = aes.encrypt(text2);
		String plainText2 = Base64.encode(cipherText2.getEncryptedData());
		System.out.println("Cipher Text: " + plainText2);
		// test case 3
		System.out.println("\nText before Encryption: " + text3);
		DataObject cipherText3 = aes.encrypt(text3);
		String plainText3 = Base64.encode(cipherText3.getEncryptedData());
		System.out.println("Cipher Text: " + plainText3);

		assertFalse(text1.equals(cipherText1));
		assertFalse(text2.equals(cipherText2));
		assertFalse(text3.equals(cipherText3));
	}

	@Test
	public void testDecrypt() {
		// test case 1
		String text1 = "Test case 1";
		DataObject cipherText1 = aes.encrypt(text1);
		String plainText1 = Base64.encode(cipherText1.getEncryptedData());
		System.out.println("\nCipher Text: " + plainText1);
		String decr1 = aes.decrypt(cipherText1);
		System.out.println("Text after Decryption: " + decr1);

		// test case 2
		String text2 = "Test case 2";
		DataObject cipherText2 = aes.encrypt(text2);
		String plainText2 = Base64.encode(cipherText2.getEncryptedData());
		System.out.println("\nCipher Text: " + plainText2);
		String decr2 = aes.decrypt(cipherText2);
		System.out.println("Text after Decryption: " + decr2);

		// test case 3
		String text3 = "Test case 3";
		DataObject cipherText3 = aes.encrypt(text3);
		String plainText3 = Base64.encode(cipherText3.getEncryptedData());
		System.out.println("\nCipher Text: " + plainText3);
		String decr3 = aes.decrypt(cipherText3);
		System.out.println("Text after Decryption: " + decr1);

		assertTrue(text1.equals(decr1));
		assertTrue(text2.equals(decr2));
		assertTrue(text3.equals(decr3));
	}


}
