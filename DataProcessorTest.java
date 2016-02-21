package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cryptography.DataProcessor;
import data.DataObject;

/**
 * This JUnit test case tests method of class DataProcessor
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date 02/21/2016
 **/

public class DataProcessorTest {

	DataProcessor dp = new DataProcessor();

	String str1 = "Random string to encrypt 1.";
	String str2 = "Another string to encrypt 2.";
	String str3 = "Third test case.";

	@Test
	public void testEncryptData() throws Exception {

		DataObject encryptedData1 = dp.encryptData(str1);

		DataObject encryptedData2 = dp.encryptData(str2);

		DataObject encryptedData3 = dp.encryptData(str3);
		// text case 1

		System.out.print("String to be encrypted 1: " + str1);
		System.out.print("\nEncryption algorithm used: "
				+ encryptedData1.getEncryptionAlgorithm());
		System.out.print("\nResult: "
				+ new String(encryptedData1.getEncryptedData()));

		assertTrue(!str1.equals(encryptedData1.getEncryptedData()));

		// text case 2

		System.out.print("\n\nString to be encrypted 2: " + str2);
		System.out.print("\nEncryption algorithm used: "
				+ encryptedData2.getEncryptionAlgorithm());
		System.out.print("\nResult: "
				+ new String(encryptedData2.getEncryptedData()));

		assertTrue(!str2.equals(encryptedData2.getEncryptedData()));

		// text case 3

		System.out.print("\n\nString to be encrypted 3: " + str3);
		System.out.print("\nEncryption algorithm used: "
				+ encryptedData3.getEncryptionAlgorithm());
		System.out.print("\nResult: "
				+ new String(encryptedData3.getEncryptedData()));

		assertTrue(!str3.equals(encryptedData3.getEncryptedData()));

	}

	@Test
	public void testDencryptData() throws Exception {

		DataObject encryptedData1 = dp.encryptData(str1);

		DataObject encryptedData2 = dp.encryptData(str2);

		DataObject encryptedData3 = dp.encryptData(str3);

		// text case 1
		String decrypted1 = null;
		System.out.print("\n\nOriginal string 1: " + str1);
		decrypted1 = dp.decryptData(encryptedData1);
		System.out.print("\nDecrypted: " + decrypted1);
		assertTrue(str1.equals(decrypted1));

		// test case 2
		String decrypted2 = null;
		System.out.print("\n\nOriginal string 2: " + str2);
		decrypted2 = dp.decryptData(encryptedData2);
		System.out.print("\nDecrypted: " + decrypted2);
		assertTrue(str2.equals(decrypted2));

		// test case 3
		String decrypted3 = null;
		System.out.print("\n\nOriginal string 3: " + str3);
		decrypted3 = dp.decryptData(encryptedData3);
		System.out.print("\nDecrypted: " + decrypted3);
		assertTrue(str3.equals(decrypted3));

	}
}
