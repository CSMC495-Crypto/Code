/*
 *
 * Class:     CMIS 495
 * File:      Homework
 *
 */

package encrypdecryp;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class AESencrp 
{    
    private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'L', 'e', 't', 's', 'U', 's', 'G', 'e', 't', 
            'I', 't', 'R', 'i','g', 'h', 't' };

    public static String encrypt(String Data) throws Exception 
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception 
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        
        return decryptedValue;
    }
    
    private static Key generateKey() throws Exception 
    {
        Key key = new SecretKeySpec(keyValue, ALGO);
        
        return key;
    }
}
