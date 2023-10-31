package no.hvl.dat108.password;

import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
	
	private String hash;
	private String salt;
	
	public Password(String hash, String salt) {
		this.hash = hash;
		this.salt = salt;
	}
	
	public String getHash() {
		return hash;
	}
	
	public String getSalt() {
		return salt;
	}

}
