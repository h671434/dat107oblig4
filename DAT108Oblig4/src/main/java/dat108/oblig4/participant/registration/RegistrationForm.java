package dat108.oblig4.participant.registration;

import dat108.oblig4.validation.FieldsValueMatch;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@FieldsValueMatch(field = "password", fieldMatch = "repeatPassword")
public class RegistrationForm {
	
	@Size(min = 2, max = 20)
	@Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå\\- ]+$")
	@NotNull
	private String firstname; 
	
	@Size(min = 2, max = 20)
	@Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå\\-]+$")
	@NotNull
	private String lastname;
	
	@Pattern(regexp = "^\\d{8}$")
	@NotNull
	private String phone;
	
	@Pattern(regexp = "Male|Female")
	@NotNull
	private String gender;
	
	@Size(min = 4)
	@NotNull
	private String password;
	
	@NotNull
	private String repeatPassword;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
