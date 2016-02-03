/*
 * Class:     CMIS 495
 * File:      Get Encryption-Decryption Program
 *
 * Author:    Walter Baynard
 */

package getencrypdecyrp;

import java.util.Random;

/**
 *
 * @author waltbaynard
 * 
 * Generates 3 random numbers. To select which encryption program 
 * will be used.
 */

public class GetEncrypDecyrp 
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        //Initialize variables
        boolean 
        int ranNum;                       
        Random getRanNum = new Random();
        
        //Get a random number
        ranNum = getRanNum.nextInt(3) + 1;
        
        switch (ranNum)
        {
            case 1:
                System.out.println("AES Encryption, place holder");
                break;
            case 2:
                System.out.println("Blowfish Encryption, place holder");
                break;
            default:
                System.out.println("XOR Encryption, place holder");
        }    
    }      
}
