package no.hvl.dat108.participant;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Participant {

	public enum Gender {
		MALE, FEMALE, OTHER
	}
	
	@Id public String phone;
	@Embedded private Password password;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING) private Gender gender;
	
	public Participant(String phone, Password password, String firstname, String lastname, Gender gender) {
		this.phone = phone;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
