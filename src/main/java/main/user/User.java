package main.user;


import jakarta.persistence.*;
import main.raw.RawInput;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(schema = "dat108", name = "attendee")
public class User {


    @Id
    @Column(name = "phone")
    private String phone;

    @Embedded
    private Password password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    @Column(name = "gender")
    private String gender;


    public User(){}

    public User(RawInput input , Password password){

        this.phone = input.getPhone();

        this.password = password;
        this.firstName = input.getFirstName();
        this.lastName = input.getLastName();
        this.gender = input.getGender();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", password=" + password +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
