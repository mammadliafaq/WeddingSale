/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.domain;

/**
 *
 * @author Nargiz
 */
public class User extends BaseDomain {
    private static final long serialVersionUID = -6989060742595185677L;
     private String firstname;
    private String lastname;
    private String username;
    private String country;
    private String email;
    private String city;
    private String address;
    private String phoneNo;
    private String postalCode;
    
    public User() {
        this.firstname="";
        this.lastname="";
        this.username="";
        this.country="";
        this.email="";
        this.city="";
        this.address="";
        this.phoneNo="";
        this.postalCode="";
    }
    
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
     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "User{" + "name=" + firstname + ", surname=" + lastname + ", username=" + username + " email=" + email +", country=" + country + ", city=" + city +", address="+address + ", postalCode="+postalCode+ ", phoneNo="+phoneNo + '}';
    }    
}
