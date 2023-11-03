package dat108.oblig4.participant.login;

import jakarta.validation.constraints.NotNull;

public class LoginForm {

	@NotNull
	private String phone;
	
	@NotNull
	private String password;
	
	public LoginForm() {}
	
	public LoginForm(String phone, String password) {
		this.phone = phone;
		this.password = password;
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
	
	
	
}
