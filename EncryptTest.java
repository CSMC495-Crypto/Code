import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This JUnit test case tests methods of class Encrypt
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date 02/14/2016
 **/

public class EncryptTest {
	String string1 = "Encrypting this data. Test case 1";
	Encrypt encryptObj1 = new Encrypt(string1.getBytes());

	String string2 = "Encrypting this data. Test case 2";
	Encrypt encryptObj2 = new Encrypt(string2.getBytes());

	String string3 = "Encrypting this data. Test case 3";
	Encrypt encryptObj3 = new Encrypt(string3.getBytes());

	// this test unit makes sure that plain text passed to method encryptData
	// gets encrypted. It also makes sure that returned object is of DataObject
	// class

	@Test
	public void testEncryptData() {

		// test case 1
		DataObject data1 = encryptObj1.encryptData();

		System.out.print(new String("\nInitial data to encrypt: " + string1));
		System.out.print("\nResult of encryption: "
				+ new String(data1.encryptedData));
		assertTrue(!string1.equals(new String(
				encryptObj1.encryptData().encryptedData)));
		assertTrue(data1.getClass().getName().equals("DataObject"));

		// test case 2
		DataObject data2 = encryptObj2.encryptData();

		System.out.print(new String("\n\nInitial data to encrypt: " + string2));
		System.out.print("\nResult of encryption: "
				+ new String(data2.encryptedData));
		assertTrue(!string2.equals(new String(
				encryptObj2.encryptData().encryptedData)));
		assertTrue(data2.getClass().getName().equals("DataObject"));

		// test case 3
		DataObject data3 = encryptObj3.encryptData();

		System.out.print(new String("\n\nInitial data to encrypt: " + string3));
		System.out.print("\nResult of encryption: "
				+ new String(data3.encryptedData));
		assertTrue(!string3.equals(new String(
				encryptObj3.encryptData().encryptedData)));
		assertTrue(data3.getClass().getName().equals("DataObject"));
	}

}
