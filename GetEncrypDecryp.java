/*
 *  Class: 
 *   File: 
 *  
 * Author:
 */
package client;

import java.util.Random;

/**
 *
 * @author waltbaynard
 */
public class GetEncrypDecyrp implements java.io.Serializable
{    
   
    
    public static void main(String[] args) 
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
                DataObject AESEncrpy = new DataObject(encryptedData, key, AES);
                System.out.println("AES Encryption, place holder");
                break;
            case 2:
                DataObject BlowFishEncrpy = new DataObject(encryptedData, key, BlowFish);
                System.out.println("Blowfish Encryption, place holder");
                break;
            default:
                DataObject XOREncrpy = new DataObject(encryptedData, key, EncrypXOR);
                System.out.println("XOR Encryption, place holder");
        }    
    } 
    
}


