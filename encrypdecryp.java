/*
 *
 * Class:     CMIS 495
 * File:      Homework
 *
 */

package encrypdecryp;

/**
 *
 * @author waltbaynard
 */
public class EncrypDecryp 
{
    public static void main(String[] args) throws Exception 
    {
        String password = "This is our password test. To see it I can maybe us a"
                + " file.";
        String passwordEnc = AESencrp.encrypt(password);
        String passwordDec = AESencrp.decrypt(passwordEnc);

        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }
}

