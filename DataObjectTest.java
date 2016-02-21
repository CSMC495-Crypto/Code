import static org.junit.Assert.*;

import org.junit.Test;

import cryptography.AES;
import cryptography.BlowFish;
import cryptography.XOR;
import data.DataObject;

public class DataObjectTest {

	AES aes = new AES();
	BlowFish fish = new BlowFish();
	XOR xor = new XOR();

	DataObject obj1 = aes.encrypt("Encrypting with AES");
	DataObject obj2 = fish.encrypt("Encrypting with Fish");
	DataObject obj3 = xor.encrypt("Encrypting with XOR");

	@Test
	public void testGetEncryptionAlgorythmDesignator() {

		// test case 1

		System.out
				.print("\nEncryption algorithm designater for AES should be 1: "
						+ obj1.getEncryptionAlgorithmDesignator("AES"));
		assertTrue(obj1.getEncryptionAlgorithmDesignator("AES") == 1);

		// test case 2

		System.out
				.print("\n\nEncryption algorithm designater for BlowFish should be 2: "
						+ obj2.getEncryptionAlgorithmDesignator("BlowFish"));
		assertTrue(obj2.getEncryptionAlgorithmDesignator("BlowFish") == 2);

		// test case 3

		System.out
				.print("\n\nEncryption algorithm designater for XOR should be 3: "
						+ obj3.getEncryptionAlgorithmDesignator("XOR"));
		assertTrue(obj3.getEncryptionAlgorithmDesignator("XOR") == 3);
	}

	@Test
	public void testGetEncryptionAlgorythm() {
		// test case 1
		System.out.print("\n\nShould be AES 1: "
				+ obj1.getEncryptionAlgorithm());
		assertTrue(obj1.getEncryptionAlgorithm() == 1);

		// test case 3
		System.out.print("\n\nShould be XOR 3: "
				+ obj3.getEncryptionAlgorithm());
		assertTrue(obj3.getEncryptionAlgorithm() == 3);

		// test case 2
		System.out.print("\n\nShould be BlowFish 2: "
				+ obj2.getEncryptionAlgorithm());
		assertTrue(obj2.getEncryptionAlgorithm() == 2);
	}

}
