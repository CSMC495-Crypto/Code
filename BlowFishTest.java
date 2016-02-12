import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This JUnit test case tests method of class BlowFish
 * 
 * @author Olga Kazlova
 * @project Bank Encryption Application
 * @course CSMC 495
 * @date Updated on 02/09/2016
 **/

public class BlowFishTest {

	BlowFish blF = new BlowFish();

	@Test
	public void testEncrypt() {
		String text1 = "Blowfish Algorithm";
		String text2 = "Test case 2";
		String text3 = "Somithing random";
		//test case 1
		System.out.println("\nText before Encryption: " + text1);
		String cipherText1 = blF.encrypt(text1);
		System.out.println("Cipher Text: " + cipherText1);
		//test case 2
		System.out.println("\nText before Encryption: " + text2);
		String cipherText2 = blF.encrypt(text2);
		System.out.println("Cipher Text: " + cipherText2);
		//test case 3
		System.out.println("\nText before Encryption: " + text3);
		String cipherText3 = blF.encrypt(text3);
		System.out.println("Cipher Text: " + cipherText3);
		
		assertFalse(text1.equals(cipherText1));
		assertFalse(text2.equals(cipherText2));
		assertFalse(text3.equals(cipherText3));
	}

	@Test
	public void testDecrypt() {
		//test case 1
		String text1 = "Blowfish Algorithm";
		String cipherText1 = blF.encrypt(text1);
		System.out.println("\nCipher Text: " + cipherText1);
		String decr1 = blF.decrypt(cipherText1);
		System.out.println("Text after Decryption: "
				+ decr1);
		
		//test case 2
		String text2 = "Test case 2";
		String cipherText2 = blF.encrypt(text2);
		System.out.println("\nCipher Text: " + cipherText2);
		String decr2 = blF.decrypt(cipherText2);
		System.out.println("Text after Decryption: "
				+ decr2);
		
		//test case 3
		String text3 = "Somithing random";
		String cipherText3 = blF.encrypt(text3);
		System.out.println("\nCipher Text: " + cipherText3);
		String decr3 = blF.decrypt(cipherText3);
		System.out.println("Text after Decryption: "
				+ decr1);
		
		assertTrue(text1.equals(decr1));
		assertTrue(text2.equals(decr2));
		assertTrue(text3.equals(decr3));
	}

	

}
