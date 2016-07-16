package Project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
 

public class EncryptionAlgorithm {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
   
 
    public static void encrypt(String key, File inputFile, File outputFile) throws Exception {
        doAlgorithm(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    public static void decrypt(String key, File inputFile, File outputFile) throws Exception {
        doAlgorithm(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
 
    private static void doAlgorithm(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
        
	    	try {
	        	// Create a pass phrase (key) to be used with the encryption/decryption algorithm
	         
	    	  SecretKeySpec secretkey = new SecretKeySpec(key.getBytes(), ALGORITHM);
	    	   
	           
	            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
	           
	            cipher.init(cipherMode, secretkey);
	            
	        
	            FileInputStream inputStream = new FileInputStream(inputFile);
	         
	            byte[] inputBytes = new byte[(int) inputFile.length()];
	       
	            inputStream.read(inputBytes);
	         
	             
	            byte[] outputBytes = cipher.doFinal(inputBytes);
	        
	            FileOutputStream outputStream = new FileOutputStream(outputFile);
	            outputStream.write(outputBytes);
	            inputStream.close();
	            outputStream.close();
	             
	        } catch (Exception ex) {
	        	//In case the user wants to encrypt a file
	        	if (cipherMode == Cipher.ENCRYPT_MODE) {
	        		System.out.println("Error encrypting file"+ ex);
	        	}
	        	//In case the user wants to decrypt the file
	        	else {
	        		System.out.println("Error decrypting file"+ ex);
	        	}
	        }
    	}
    	
    }


