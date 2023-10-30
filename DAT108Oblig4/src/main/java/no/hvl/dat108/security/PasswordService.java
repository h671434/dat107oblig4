package no.hvl.dat108.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import jakarta.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	/**
	 * @return a randomly generated 16 byte salt by using SHA1PRNG
	 */
	public String generateRandomSalt() {
	    SecureRandom sr;
	    byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}	
		
	    return DatatypeConverter.printHexBinary(salt);
	}

	/**
	 * Generates a cryptographic hash for given password and salt.
	 * 
	 * Algorithm used is PBKDF2WithHmacSHA1
	 * 	- PBKDF2: Password-Based-Key-Derivation-Function
	 *  - WithHmac: HMAC stands for Keyed-Hash Message Authentication Code
	 *  - SHA1: SHA1 hashing-algorithm
	 * 
	 * It's iterated 1000 times.
	 * Output from this algorithm is 256 bits(32 bytes).
	 * 
	 * See https://en.wikipedia.org/wiki/PBKDF2 for more info.
	 * 
	 * In the end the byte-array is converted to a HEX-string with 64 characters/digits.
	 *  
	 * @param password
	 * @param salt
	 * @return a 64 character long HEX-string which represents a 32 byte/256 bit hash.
	 */
	public String hashWithSalt(String password, String salt) { 
		
		if (password == null || salt == null) { //should validate properly!!
			throw new IllegalArgumentException();
		}
		
		char[] passchar = password.toCharArray();
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
		
		byte[] keyhash = null;
		try {
			PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			keyhash = skf.generateSecret(pks).getEncoded();
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(keyhash);
	}
	
	/**
	 * Sjekker om et password matcher en hash generert med korresponderende 
	 * hashMedSalt(). 
	 * 
	 * @param password - Password to check
	 * @param salt - The salt used when generating passwordhash
	 * @param hash - The "saved" password 
	 * @return true if password matches
	 */
	public boolean isCorrectPassword(
			String password, String salt, String hash) {
		
		if (password == null || salt == null || hash == null) {  //should validate properly!!
			throw new IllegalArgumentException();
		}
		
		return hash.equals(hashWithSalt(password, salt));
	}
}
