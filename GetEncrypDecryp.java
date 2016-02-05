/*
 *  Class: CMIS495
 *   File: GetEncrypDecryp
 *  
 * Author: Walter Baynard
 */
 
package client;

import java.security.Key;
import java.util.Random;

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
                getKey = AESencrp.generateKey();
                DataObject AESEncrpy = new DataObject(encryptedData, key, AES);
                System.out.println("AES Encryption, place holder");
                break;
            case 2:
                //getKey = generateKey();
                DataObject BlowFishEncrpy = new DataObject(encryptedData, key, BlowFish);
                System.out.println("Blowfish Encryption, place holder");
                break;
            default:
                //getKey = generateKey();
                DataObject XOREncrpy = new DataObject(encryptedData, key, EncrypXOR);
                System.out.println("XOR Encryption, place holder");
        }    
    }
    
}


