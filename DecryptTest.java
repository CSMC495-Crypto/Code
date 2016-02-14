package client;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * This JUnit test case tests methods of class Decrypt. 
 * It makes sure decryptData() method decrypts encrypted data passed 
 * as an argument into an array of bytes
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date 02/14/2016
 **/
public class DecryptTest {

	String string1 = "Decrypting this data test case 1";
	String string2 = "Decrypting this data test case 2";
	String string3 = "Decrypting this data test case 3";
	//encrypt data to pass it to decrypt method
	Encrypt encryptObj1 = new Encrypt (string1.getBytes());
	Encrypt encryptObj2 = new Encrypt (string2.getBytes());
	Encrypt encryptObj3 = new Encrypt (string3.getBytes());
	
		
	@Test
	public void testDecryptData() {
		
		DataObject encryptedData1 = encryptObj1.encryptData();
		DataObject encryptedData2 = encryptObj2.encryptData();
		DataObject encryptedData3 = encryptObj3.encryptData();
		
		Decrypt decryptObj1 = new Decrypt(encryptedData1);
		Decrypt decryptObj2 = new Decrypt(encryptedData2);
		Decrypt decryptObj3 = new Decrypt(encryptedData3);
		
		
		System.out.print("Initial data that was incrypted test case 1: "+string1);
		System.out.print("\nEncrypted: "+new String(encryptedData1.encryptedData));
		
		String decrypted1 = new String(decryptObj1.decryptData());
		
		System.out.print("\nDecrypted result test case 1: "+decrypted1);
		
		assertTrue(string1.equals(decrypted1));
		
		System.out.print("\n\nInitial data that was incrypted test case 2: "+string2);
		System.out.print("\nEncrypted: "+ new String(encryptedData2.encryptedData));
		
		String decrypted2 = new String(decryptObj2.decryptData());
		
		System.out.print("\nDecrypted result test case 2: "+ decrypted2);
		
		assertTrue(string2.equals(decrypted2));
		
		System.out.print("\n\nInitial data that was incrypted test case 3: "+string3);
		System.out.print("\nEncrypted: "+ new String(encryptedData3.encryptedData));
		
		String decrypted3 = new String(decryptObj3.decryptData());
		
		System.out.print("\nDecrypted result test case 3: "+ decrypted3);
		
		assertTrue(string3.equals(decrypted3));
		
	}

}
