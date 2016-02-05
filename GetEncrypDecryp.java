/*
 *  Class: CMIS 495
 *   File: GetEncrypDecryp
 *  
 * Author: W.Baynard
 */
package client;

import java.security.Key;
import java.util.Random;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author waltbaynard
 */
public class GetEncrypDecyrp implements java.io.Serializable 
{    
    private static final String ALGO = "AES";
    private static Key getKey = null;
    
    public static void main(String[] args) throws Exception 
    {
        //Initialize variables
         
        int ranNum;                       
        Random getRanNum = new Random();
        int[] key= null;
        byte[] encryptedData = null;    
        String AES = "AESencrp", BlowFish = "BlowFish", EncrypXOR = "XOR";
        
        //Get a random number
        ranNum = getRanNum.nextInt(3) + 1;        
        
        switch (ranNum)
        {
            case 1:
                getKey = generateKey();
                DataObject AESEncrpy = new DataObject(encryptedData, key, AES);
                System.out.println("AES Encryption, place holder");
                break;
            case 2:
                getKey = generateKey();
                DataObject BlowFishEncrpy = new DataObject(encryptedData, key, BlowFish);
                System.out.println("Blowfish Encryption, place holder");
                break;
            default:
                getKey = generateKey();
                DataObject XOREncrpy = new DataObject(encryptedData, key, EncrypXOR);
                System.out.println("XOR Encryption, place holder");
        }    
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


