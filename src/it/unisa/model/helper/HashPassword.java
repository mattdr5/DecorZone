package it.unisa.model.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword 
{
	private MessageDigest md;
	private String passwordDaCripatare;
	
	public HashPassword(String password)
	{
		 try 
		 {
			md = MessageDigest.getInstance("SHA-512");
			passwordDaCripatare= password;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	   public String cryptWithSHA512()
	   {
	      
		// digest() method is called 
           // to calculate message digest of the input string 
           // returned as array of byte 
           byte[] messageDigest = md.digest(passwordDaCripatare.getBytes()); 
 
           // Convert byte array into signum representation 
           BigInteger no = new BigInteger(1, messageDigest); 
 
           // Convert message digest into hex value 
           String hashtext = no.toString(16); 
 
           // Add preceding 0s to make it 32 bit 
           while (hashtext.length() < 32) { 
               hashtext = "0" + hashtext; 
           } 
 
           // return the HashText 
           return hashtext; 
	
	   }
	   
	   
}
	


