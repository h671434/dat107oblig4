package no.hvl.dat108.registration;

import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistrationData {

	private String firstname;
	private String lastname;
	private String phone;
	private String password;
	private String repeatPassword;
	private String gender;
	
	public RegistrationData(String firstname, String lastname, String phone, 
			String password, String repeatPassword, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public String getGender() {
		return gender;
	}
	
}
