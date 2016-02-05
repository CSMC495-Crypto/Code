/*
 *  Class: CMIS 495
 *   File: AESencrp
 *  
 * Author:
 */
package client;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class AESencrp 
{    
    private static final String ALGO = "AES";
    /*
    private static final byte[] keyValue = 
        new byte[] { 'L', 'e', 't', 's', 'U', 's', 'G', 'e', 't', 
            'I', 't', 'R', 'i','g', 'h', 't' };
    */
    private static Key key = null;
    
    public static String encrypt(String Data) throws Exception 
    {
        //key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception 
    {
        //key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        
        return decryptedValue;
    }
    
    private static Key generateKey() throws Exception 
    {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
        keyGen.init(128); 
        SecretKey secretKey = keyGen.generateKey();
        byte[] aesKey = secretKey.getEncoded();
        Key key = new SecretKeySpec(aesKey, ALGO);
        
        return key;
    }
}
