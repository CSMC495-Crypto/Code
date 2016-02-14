package client;

/**
 * This class performs the decryption for the XOR algorithm
 * 
 * @author Jonathan Wojack
 * @project Bank Encryption Application
 * @course CSMC 495
 * @updated on 02/14/2016 by Grant Sweeney
 */
public class Decrypt {
    
    private DataObject encryptedData;
    
    public Decrypt(DataObject encryptedData) {
        
        this.encryptedData = encryptedData;
           
    }
    
    /**
     * Getter method for the data stored by the data object
     * 
     * @return data that will be decrypted
     */
    public byte[] getEncrypted() {
        
        return encryptedData.encryptedData;
        
    }
   
    /**
     * Getter method for key stored by the data object
     * 
     * @return encryption key
     */
    public int[] getKeyInitialFirst() {
        
        return encryptedData.key;
        
    }
    
    /**
     * Method that performs the decryption
     * 
     * @return decrypted data
     */
    public byte[] decryptData() {
        
        int[] keyInitialFirst = getKeyInitialFirst();
        byte[] encrypted = getEncrypted();
    
        // declare decryption array
        
    byte[] decrypted = new byte[encrypted.length];
    
    // declare array for copying the initial key words
    
    int[] keyInitial = new int[8];
    
    // declare array for storing the intermediate result during the process of generating key words
    
    int[] keyNext = new int[8];
    
    // declare array for storing the final value for each key word during each permuation
    
    int[] keyFinal = new int[8];
    
    // delcare array for storing the bit pattern of the selected key word for key word reordering
    
    int[] keyReorderArray = new int[8];
        
    // declare selected byte to define the pseudorandom reordering of key words    
    
        int keyReorder = encrypted.length % 8;        
        
        // get average of initial key words
        
        int keyInitialSum = 0;
        int keyInitialAverage = 0;
        
        for (int i = 0; i < 8; i++) {
            
            keyInitialSum = keyInitialSum + keyInitialFirst[i];
            keyInitial[i] = keyInitialFirst[i];
            
        }
        
        keyInitialAverage = keyInitialSum / 8;  // number of times to iterate decryption sequence
      
        int keyWordQuantity = keyInitialSum; // number of key words to be generated
        
        // array to store all iterations of key words
        
                int[] decryptedKeyWords = new int[keyWordQuantity];
                
        // generate all required key words
        
        for (int decryptionSequence = 0; decryptionSequence < keyInitialAverage; decryptionSequence++) {
        
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
       
        // get bits from selected byte for key word reordering
        
      int keyOnesCount = 0;
        int keyZerosCount = 8;
        
        for (int i = 0; i < 8; i++) {
            
            keyReorderArray[i] = keyNext[keyReorder] & (int)(Math.pow(2, 7 - i));
            
            if (keyReorderArray[i] > 0) {
                
                keyReorderArray[i] = 1;
                
                keyOnesCount++;
                keyZerosCount--;
                
            }
            
        }
        
        // store 1s and 0s of the selected byte for key word reordering in separate arrays  
        
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
        
        // reorder key words by alternating between arrays as defined by the
        // extracted bit pattern of 1s and 0s of the selected key word
        
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
        
      
        
        // copy current iteration's key words to array
        
        for (int i = 0; i < 8; i++) {
            
            decryptedKeyWords[(i % 8) + (8 * decryptionSequence)] = keyFinal[i];      
            
        }     
        
         // generate new key word permutation by Exclusive ORing each key word to the first key word
        
        for (int i = 0; i < 8; i++) {
            
            keyInitial[i] = keyFinal[i] ^ keyInitial[0];
            
        }       
        
        }
        
      //  all key words have been generated; perform decryption of encrypted data
        // recover the original data by iteratively Exclusive ORing the key words to the encrypted data
        
        for (int i = keyInitialAverage - 1; i >= 0; i--) {
        
for (int j = 0; j < decrypted.length; j++) {
            
            decrypted[j] = (byte) (decryptedKeyWords[(j % 8) + (i * 8)] ^ Integer.parseInt(Byte.toString(encrypted[j])));
            encrypted[j] = decrypted[j];
            
}

        }
   
   // data decryption completed
        
        return decrypted;
             
    }
    
}
