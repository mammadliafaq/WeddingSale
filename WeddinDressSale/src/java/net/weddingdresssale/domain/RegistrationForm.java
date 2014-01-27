/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.domain;

/**
 *
 * @author Nargiz
 */
public class RegistrationForm {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String phoneNo;
    private String city;
    private String country;
    private String address;
    private String postalCode;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
public String getCountry() {
    return country;
}
public void setCountry (String country)
{
    this.country= country;
}
public String getCity() {
    return city; 
}
public void setCity (String city) {
    this.city = city; 
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address= address;
}
public String getPhoneNo() {
    return phoneNo;
}
public void setPhoneNo (String phoneNo) {
    this.phoneNo= phoneNo;
}
public String getPostalCode () {
    return postalCode;
}
public void setPostalCode(String postalCode) {
    this.postalCode= postalCode;
}
}

