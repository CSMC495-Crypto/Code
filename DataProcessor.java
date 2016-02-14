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
    String dataCryption;
    int[] key= null;    
    int getEncrypNum;
    
    public String encrypData(int encrypNum) throws Exception
    {
        switch (encrypNum)
        {
            //AES decryption
            case 1:
                getKey = AESencrp.generateKey();
                
                // get base64 encoded version of the key
                String AESKey = getKey.toString();                
                dataCryption = AESencrp.encrypt(encryptedData, getKey);
                
                break;
            //Blowfish decryption
            case 2:                
                           
                dataCryption = BlowFish.encrypt(encryptedData, "blowFishKey");
                break;
            //XOR decryption
            default:                
                //XOR;
        }   
        
        return dataCryption;
        
    }
    
    public String decrypData(int decrypNum) throws Exception
    {
        switch (decrypNum)
        {
            //AES encryption
            case 1:
                getKey = AESencrp.generateKey();
                
                // get base64 encoded version of the key
                String AESKey = getKey.toString();                
                dataCryption = AESencrp.decrypt(decrypData, getKey);
                
                break;
            //Blowfish encryption
            case 2:                
                           
                dataCryption = BlowFish.encrypt(decrypData, "blowFishKey");
                break;
            //XOR encryption
            default:                
                //XOR..class;
        }   
        
        return dataCryption;
    }
    
    public int getEncryptionAlgorithm() throws Exception
    {
        Random getRanNum = new Random();
        
        //Get a random number
        getEncrypNum = getRanNum.nextInt(3) + 1;        
                        
        return getEncrypNum; 
    }    
}
