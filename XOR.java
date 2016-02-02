// simple cryptographic program which encrypts and decrypts data
// by XORing a binary key to each byte of data

package client;

public class XOR {
    
    public static String plainText;
    public static Base64 base64 = new Base64();
    public XOR(String plainText) {
        
        this.plainText = plainText;
        
    }
    
    public DataObject encryptData() {  
        
       
        
        byte[] plainText64 = base64.encode(plainText.getBytes()).getBytes();
        
        Encrypt encrypt = new Encrypt(plainText64);
        
        DataObject encryptedObject = encrypt.encryptData();
        
       
        
        return encryptedObject;
    }
    
    public String decryptData(DataObject encryptedData) {
        
        Decrypt decrypt = new Decrypt(encryptedData);
        
        byte[] decryptedData = decrypt.decryptData();
        
        String decodedData = new String(base64.decode(new String(decryptedData)));
                
        return decodedData;
        
    }
        
    }
    
