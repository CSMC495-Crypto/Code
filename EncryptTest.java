import static org.junit.Assert.*;

import org.junit.Test;


public class EncryptTest {
	String string = "Encrypting this data";
	Encrypt encryptObj = new Encrypt (string.getBytes());

	@Test
	public void testEncryptData() {
		System.out.print(new String("Initial data to encrypt: "+string));
		System.out.print(new String("\nResult of encryption: "+new String(encryptObj.encryptData().encryptedData)));
		assertTrue(!string.equals(new String(encryptObj.encryptData().encryptedData)));
	}

}
