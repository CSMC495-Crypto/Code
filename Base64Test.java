import static org.junit.Assert.*;

import java.util.Arrays;

/*This class tests encrypt and decrypt methods of Base64 classes*/

import org.junit.Test;

public class Base64Test {
	
	Base64 obj = new Base64();

	//method encode takes an array of bytes as an argument and 
	//returns an encoded string
	@Test
	public void encodeTest() {
		String string = "I want to encode this!\n";
		String encoded = obj.encode(string.getBytes());
		System.out.print("\nTest 1: Encoding:\nPassing: "+string);
		System.out.print("Encoded result: "+encoded);
		assertFalse(string.equals(encoded));
	}

	//method decode takes an encoded string as an argument and 
	//returns a decoded string
	@Test
	public void decodeTest() {
		String string = "I want to decodet this!\n";
		String encoded = obj.encode(string.getBytes());
		String decoded = new String(obj.decode(encoded));
		
		System.out.print("\nTest 2 Decoding:\nPassing encoded: " + encoded+"\n");
		System.out.print("Decoded result: "+decoded);
		assertTrue(string.equals(decoded));
	}
}
