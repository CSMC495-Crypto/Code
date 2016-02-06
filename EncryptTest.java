import static org.junit.Assert.*;

import org.junit.Test;


public class EncryptTest {
	String string = "Encrypting this data";
	Encrypt encryptObj = new Encrypt (string.getBytes());

	//this test unit makes sure that plain text passed to method encryptData 
	//gets encrypted. It also makes sure that returned object is of DataObject class
	
	@Test
	public void testEncryptData() {
		
		DataObject data = encryptObj.encryptData();
		
		System.out.print(new String("Initial data to encrypt: "+string));
		System.out.print(new String("\nResult of encryption: "+new String(data.encryptedData)));
		assertTrue(!string.equals(new String(encryptObj.encryptData().encryptedData)));
		assertTrue(data.getClass().getName().equals("DataObject"));
	}

}

