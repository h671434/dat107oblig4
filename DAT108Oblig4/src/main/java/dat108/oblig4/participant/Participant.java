package dat108.oblig4.participant;

import dat108.oblig4.participant.password.Password;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dat108oblig4")
public class Participant {
	
	@Id public String phone;
	@Embedded private Password password;
	private String firstname;
	private String lastname;
	private String gender;
	
	public Participant() {}
	
	public Participant(String phone, Password password, String firstname, String lastname, String gender) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
