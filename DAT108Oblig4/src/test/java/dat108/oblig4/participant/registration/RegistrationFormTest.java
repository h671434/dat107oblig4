package dat108.oblig4.participant.registration;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.groups.Default;

public class RegistrationFormTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Test
	public void registrationFormValidityTest() {
		RegistrationForm valid = buildValidRegistrationForm();
		RegistrationForm invalid = buildValidRegistrationForm();
		
		invalid.setFirstname("f");
		invalid.setLastname("f");
		invalid.setGender("");
		invalid.setPhone("");
		invalid.setPassword("p");
		invalid.setRepeatPassword("");
		
		Assertions.assertTrue(isValidRegistrationForm(valid));
		Assertions.assertFalse(isValidRegistrationForm(invalid));
	}
	
	private static RegistrationForm buildValidRegistrationForm() {
		RegistrationForm valid = new RegistrationForm();
		
		valid.setFirstname("Jonas");
		valid.setLastname("Etternavn");
		valid.setPhone("12345678");
		valid.setGender("Male");
		valid.setPassword("pass");
		valid.setRepeatPassword("pass");
		
		return valid;
	}
	
	private boolean isValidRegistrationForm(RegistrationForm form) {
		return validator.validate(form, Default.class).isEmpty();
	}
	
	@Test
	public void firstNameValidityTest() {
		Assertions.assertTrue(isValidFirstName("Jonas"));
		Assertions.assertTrue(isValidFirstName("Per Åge"));
		Assertions.assertTrue(isValidFirstName("Jonny-Dj"));
		Assertions.assertFalse(isValidFirstName("P"));
		Assertions.assertFalse(isValidFirstName("ThisIsAStringWithOverTwentyCharacters"));
		Assertions.assertFalse(isValidFirstName("per"));
		Assertions.assertFalse(isValidFirstName(null));
		Assertions.assertFalse(isValidFirstName("Illegal_"));
	}
	
	private boolean isValidFirstName(String firstname) {
		return isValidPropertyValue("firstname", firstname);
	}

	private boolean isValidPropertyValue(String propertyName, Object value) {
		Set<ConstraintViolation<RegistrationForm>> violations = 
				validator.validateValue(RegistrationForm.class, propertyName, value, Default.class);
		
		return violations.isEmpty();
	}
	
	@Test
	public void lastNameValidityTest() {
		Assertions.assertTrue(isValidLastName("Lastname"));
		Assertions.assertTrue(isValidLastName("Last-Name"));
		Assertions.assertFalse(isValidLastName("Jonny Dj"));
		Assertions.assertFalse(isValidLastName("P"));
		Assertions.assertFalse(isValidLastName("ThisIsAStringWithOverTwentyCharacters"));
		Assertions.assertFalse(isValidLastName("per"));
		Assertions.assertFalse(isValidLastName(null));
		Assertions.assertFalse(isValidLastName("Illegal_"));
	}
	
	private boolean isValidLastName(String lastname) {
		return isValidPropertyValue("lastname", lastname);
	}
	
	@Test
	public void phoneValidityTest() {
		Assertions.assertTrue(isValidPhone("00000000"));
		Assertions.assertFalse(isValidPhone("8Letters"));
		Assertions.assertFalse(isValidPhone("7777777"));
		Assertions.assertFalse(isValidPhone("999999999"));
		Assertions.assertFalse(isValidPhone(null));
	}
	
	private boolean isValidPhone(String phone) {
		return isValidPropertyValue("phone", phone);
	}

	@Test
	public void passwordValidityTest() {
		Assertions.assertTrue(isValidPassword("PdaefD"));
		Assertions.assertTrue(isValidPassword("8-.fsd"));
		Assertions.assertFalse(isValidPassword("tre"));
		Assertions.assertFalse(isValidPassword(null));
	}
	
	private boolean isValidPassword(String password) {
		return isValidPropertyValue("password", password);
	}
	
	@Test
	public void repeatPasswordValidityTest() {
		RegistrationForm withMatchingRepeatPassword = buildValidRegistrationForm();
		RegistrationForm withNonMatchingRepeatPassword = buildValidRegistrationForm();
		
		withMatchingRepeatPassword.setPassword("pass");
		withMatchingRepeatPassword.setRepeatPassword("pass");
		
		withNonMatchingRepeatPassword.setPassword("not");
		withNonMatchingRepeatPassword.setPassword("matching");
		
		Assertions.assertTrue(isValidRegistrationForm(withMatchingRepeatPassword));
		Assertions.assertFalse(isValidRegistrationForm(withNonMatchingRepeatPassword));
		Assertions.assertTrue(isValidRepeatPassword("PdaefD"));
		Assertions.assertTrue(isValidRepeatPassword(null));
	}
	
	private boolean isValidRepeatPassword(String repeatPassword) {
		return isValidPropertyValue("repeatPassword", repeatPassword);
	}
	
	@Test
	public void genderValidityTest() {
		Assertions.assertTrue(isValidGender("Male"));
		Assertions.assertTrue(isValidGender("Female"));
		Assertions.assertFalse(isValidGender("Neither"));
		Assertions.assertFalse(isValidGender(null));
	}
	
	private boolean isValidGender(String gender) {
		return isValidPropertyValue("gender", gender);
	}
	
}
