package com.sharemanagement.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

public class EncryptionUtil {
	 static PooledPBEStringEncryptor encryptor = null;
	    static {
	        encryptor = new PooledPBEStringEncryptor();
	        encryptor.setPoolSize(4); 
	        //  There are various approaches to pull this configuration via system level properties. 
	        encryptor.setPassword("InnowaveMahaULBAshok");
	        encryptor.setAlgorithm("PBEWITHMD5ANDDES");
	    }

	    public static String encrypt(String input) {
	        return encryptor.encrypt(input);
	    }

	    public static String decrypt(String encryptedMessage) {
	        return encryptor.decrypt(encryptedMessage);
	    }
	    
	     public static void main(String args[]) {
	    	
	    	 String user = encrypt("stockuser");
	    	 String password = encrypt("shivam8652");
	    	 System.out.println("user =>" + user);
	    	 System.out.println("password =>" + password);
	    	 System.out.println("user decrypt =>" + decrypt(user));
	    	 System.out.println("password decrypt=>" + decrypt(password));
	    	
	    }
}
