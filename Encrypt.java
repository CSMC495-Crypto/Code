package client;

import java.security.SecureRandom;


/**
 * This class performs the encryption for the XOR algorithm
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @updated on 02/14/2016 by Grant Sweeney
 */
public class Encrypt {

    private int[] keyInitialFirst = new int[8]; // initial key value
    private byte[] plainText64;                 // original data Base64-encoded
    private byte[] encrypted;                   // encrypted data
    

    public Encrypt(byte[] plainText64) {
        
        this.plainText64 = plainText64;
        
    }
    
    /**
     * generate 64-bit encryption key composed of eight 8-bit key words
     */
    public void generateKey() {
        
        SecureRandom secureRandom = new SecureRandom();      
        
        for (int i = 0; i < 8; i++) {
        
        keyInitialFirst[i] = secureRandom.nextInt(256);       
       
        }
        
        setKey(keyInitialFirst);
        
    }
    
    /**
     * set method for encryption key
     * 
     * @param keyInitialFirst encryption key
     */
    public void setKey(int[] keyInitialFirst) {
        
        this.keyInitialFirst = keyInitialFirst;
        
    }
    
    /**
     * get method for encryption key
     * 
     * @return encryption key 
     */
    public int[] getKey() {
        
        return keyInitialFirst;
        
    }

    /**
     * set method for Base64-encoded plain text
     * 
     * @param plainText64 Base64
     */
    public void setPlainText64(byte[] plainText64) {
        
        this.plainText64 = plainText64;
        
    }
    
    /**
     * get method for Base64-encoded plain text
     * 
     * @return Base64
     */
    public byte[] getPlainText64() {
        
        return plainText64;
        
    }
    
    /**
     * set method for encrypted data
     * 
     * @param encrypted encrypted data
     */
    public void setEncrypted(byte[] encrypted) {
        
        this.encrypted = encrypted;
        
    }
    
   /**
    * get method for encrypted data
    * 
    * @return encrypted data
    */ 
    public byte[] getEncrypted() {
        
        return encrypted;
        
    }
        
    // encrypt data
    /**
     * Method that performs the encryption for XOR
     * 
     * @return data object including encrypted data and key
     */
    public DataObject encryptData() {
         
         
        
         // generate encryption key
         
         generateKey();
         
         // create encryption arrays
        
        byte[] intermediate = new byte[plainText64.length];
        intermediate = plainText64;
        byte[] encrypted = new byte[plainText64.length];
        
        // calculate average of key words
       
        int keyInitialSum = 0;
        
        // array to store each key word separate from the initial generation
        
        int[] keyInitial = new int[8];     
      
        for (int i = 0; i < 8; i++) {
            
            keyInitial[i] = keyInitialFirst[i]; // copy key words to separate array
            keyInitialSum = keyInitialSum + keyInitial[i];
            
        }
        
        
        int keyInitialAverage = keyInitialSum / 8;  // number of encryption iterations to perform
     
        int keyReorder = encrypted.length % 8; // key word for pseudorandom word reording
        
        int[] keyReorderArray = new int[8]; // array to store bits of selected key word for reordering
        int[] keyFinal = new int[8];    // final state of key words after each permutation        
    
         int[] keyNext = new int[8];         // array to store partially-completed key word permutation
         
         // generate key word permutations

        for (int encryptionSequence = 0; encryptionSequence < keyInitialAverage; encryptionSequence++) {
        
        // Exclusive OR (XOR) the key words to each other:
        // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5, 5 -> 6, 6 -> 7, 7 -> 0
        
        for (int i = 0; i < 8; i++) {
            
           if (i == 0) {
                
                keyNext[i] = keyInitial[0] ^ keyInitial[7];
                
            }
            
            else {
                
                keyNext[i] = keyInitial[i - 1] ^ keyInitial[i];
                
            }
            
       }
       
        // get bits from selected key word to generate reordering pattern
        
      int keyOnesCount = 0;     // store number of 1s in key word
        int keyZerosCount = 8;  // store number of 0s in key word
        
        for (int i = 0; i < 8; i++) {
            
            // logically AND the bit value for a 1 in the current iterative bit position
            // to extract each bit value into a separate array
            
            keyReorderArray[i] = keyNext[keyReorder] & (int)(Math.pow(2, 7 - i));
            
            // convert all non-zero values into 1s to produce a completely binary values
            
            if (keyReorderArray[i] > 0) {
                
                keyReorderArray[i] = 1;
                
                keyOnesCount++;
                keyZerosCount--;
                
            }
            
        }
        
        // store 1s and 0s in separate arrays  
        
        int[] keyOnes = new int[keyOnesCount];
        int[] keyZeros = new int[keyZerosCount];
        
        int keyOnesIncrementer = 0;
        int keyZerosIncrementer = 0;
        
        for (int i = 0; i < 8; i++) {
            
            if (keyReorderArray[i] == 1) {
                
                keyOnes[keyOnesIncrementer] = keyNext[i];
                keyOnesIncrementer++;
                
            }
            
            else {
                
                keyZeros[keyZerosIncrementer] = keyNext[i];
                keyZerosIncrementer++;
            }
            
        }
        
        keyOnesIncrementer = 0;
        keyZerosIncrementer = 0;
        
        // reorder key words
        
        int arrayIndex = 0;
        
        while (arrayIndex < 8) {
            
            if (keyOnesIncrementer < keyOnesCount) {
                
                keyFinal[arrayIndex] = keyOnes[keyOnesIncrementer];
                keyOnesIncrementer++;
                arrayIndex++;
                
            }
            
            if (keyZerosIncrementer < keyZerosCount) {
                
                keyFinal[arrayIndex] = keyZeros[keyZerosIncrementer];
                keyZerosIncrementer++;
                arrayIndex++;
                
            }
            
        }
        
        // Exclusive OR (XOR) the key words to the data
        // each key word is operated on the first eight bytes of data before switching to the next key word
        // after each group of 64 bytes of data, the first key word is used again and so on in a cyclical manner        
              
        for (int i = 0; i < encrypted.length; i++) {
            
            encrypted[i] = (byte) (keyFinal[i % 8] ^ Integer.parseInt(Byte.toString(intermediate[i])));
            intermediate[i] = encrypted[i]; // copy results to array to enable iterative encryption
            
        }
        
        // Exclusive OR (XOR) each key word to the first key word prior to the next iteration
        
        for (int i = 0; i < 8; i++) {
            
            keyInitial[i] = keyFinal[i] ^ keyInitial[0];
            
        }
        
        }
        
        DataObject dataObject = new DataObject(encrypted, keyInitialFirst, "XOR");
        
        // final iteration done and encryption complete
        
        return dataObject;
}
    
}
