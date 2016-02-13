// server class under construction
// author: Jonathan Wojack
// date: February 7, 2016

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

public class DataProcessor implements java.io.Serializable 
{    
    private static Key getKey = null;
    String encryptedData = null, decrypData = null;
    String AESEncrypData, BlowFishEncrypData, XOREncrypData;
    int[] key= null;    
    int getEncrypNum;
    
    public void encrypData(int encrypNum) throws Exception
    {
        switch (encrypNum)
        {
            //AES decryption
            case 1:
                getKey = AESencrp.generateKey();
                
                // get base64 encoded version of the key
                String AESKey = getKey.toString();                
                AESEncrypData = AESencrp.encrypt(decrypData, getKey);
                
                break;
            //Blowfish decryption
            case 2:                
                           
                BlowFishEncrypData = BlowFish.encrypt(encryptedData, "blowFishKey");
                break;
            //XOR decryption
            default:                
                //XOR;
        }    
        
    }
    
    public void decrypData(int decrypNum) throws Exception
    {
        switch (decrypNum)
        {
            //AES encryption
            case 1:
                getKey = AESencrp.generateKey();
                
                // get base64 encoded version of the key
                String AESKey = getKey.toString();                
                AESDecrypData = AESencrp.decrypt(encryptedData, getKey);
                
                break;
            //Blowfish encryption
            case 2:                
                           
                BlowFishEncrypData = BlowFish.encrypt(encryptedData, "blowFishKey");
                break;
            //XOR encryption
            default:                
                //XOR..class;
        }   
    }
    
    public int getEncryptionAlgorithm() throws Exception
    {
        Random getRanNum = new Random();
        
        //Get a random number
        getEncrypNum = getRanNum.nextInt(3) + 1;        
                        
        return getEncrypNum; 
    }    
}

