import static org.junit.Assert.*;

import org.junit.Test;

//this JUnit test makes sure decryptData() method decrypts encrypted data passed 
//as an argument into an array of bytes

public class DecryptTest {

	String string1 = "Decrypting this data test case 1";
	String string2 = "Decrypting this data test case 2";
	//encrypt data to pass it to decrypt method
	Encrypt encryptObj1 = new Encrypt (string1.getBytes());
	Encrypt encryptObj2 = new Encrypt (string2.getBytes());
	
		
	@Test
	public void testDecryptData() {
		
		DataObject encryptedData1 = encryptObj1.encryptData();
		DataObject encryptedData2 = encryptObj2.encryptData();
		
		Decrypt decryptObj1 = new Decrypt(encryptedData1);
		Decrypt decryptObj2 = new Decrypt(encryptedData2);
		
		
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
		
	}

}
