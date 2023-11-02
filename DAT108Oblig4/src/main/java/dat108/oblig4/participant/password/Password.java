package dat108.oblig4.participant.password;

import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
	
	private String hash;
	private String salt;
	
	public Password() {}
	
	public Password(String hash, String salt) {
		this.hash = hash;
		this.salt = salt;
	}
	
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
		
}
