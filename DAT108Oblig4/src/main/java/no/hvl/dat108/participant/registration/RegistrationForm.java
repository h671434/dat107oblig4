package no.hvl.dat108.participant.registration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import no.hvl.dat108.validation.FieldsValueMatch;

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
	
	@Size(min = 2)
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
	
	
	// Probably useful for js
	private static final String INVALID_FIRSTNAME_SIZE_MESSAGE = "First name must be between 2 and 20 characters";
	private static final String INVALID_FIRSTNAME_PATTERN_MESSAGE ="First name can only be letters, hypen and space. (Must start with capital letter)";
	private static final String INVALID_FIRSTNAME_NOTNULL_MESSAGE = "First name is required";
	private static final String INVALID_LASTNAME_SIZE_MESSAGE = "Last name must be between 2 and 20 characters";
	private static final String INVALID_LASTNAME_PATTERN_MESSAGE ="Last name can only be letters and hyphen. (Must start with capital letter)";
	private static final String INVALID_LASTNAME_NOTNULL_MESSAGE = "Last name is required";
	private static final String INVALID_PHONE_PATTERN_MESSAGE =  "Phone must be exactly 8 digits";
	private static final String INVALID_PHONE_NOTNULL_MESSAGE = "Phone is required";
	private static final String INVALID_GENDER_PATTERN_MESSAGE = "Gender must be either Male or Female";
	private static final String INVALID_GENDER_NOTNULL_MESSAGE = "Gender is required";
	private static final String INVALID_PASSWORD_SIZE_MESSAGE = "Password must be atleast 4 characters";
	private static final String INVALID_PASSWORD_NOTNULL_MESSAGE = "Password is required";
	private static final String INVALID_PASSWORD_FIELDVALUESMATCH_MESSAGE = "Repeated password is not the same as password";
	private static final String INVALID_REPEAT_PASSWORD_NOTNULL_MESSAGE = "Repeat password is required";
	
	
}
