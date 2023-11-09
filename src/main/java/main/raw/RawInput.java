package main.raw;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RawInput {


    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]{1,19}$", message = "2-20 letters and start with an uppercase")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]{2,19}$", message = "2-20 letters and start with an uppercase")
    private String lastName;


    @NotNull
    @Pattern(regexp = "\\d{8}", message = "has to be 8 digits")
    private String phone;


    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[\\W_]).{8,}$", message = "8 characters, atleast 1 uppercase, and 1 special character")
    private String password;

    @NotNull
    @Pattern(regexp ="^(?=.*[A-Z])(?=.*[\\W_]).{8,}$", message = "8 characters, atleast 1 uppercase, and 1 special character")
    private String confirmPassword;


    @NotNull
    @Pattern(regexp = "^M|F$")
    private String gender;


    public RawInput(String firstName, String lastName, String phone, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
