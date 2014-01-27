/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.weddingdresssale.domain.RegistrationForm;
import org.apache.commons.validator.GenericValidator; 
/**
 *
 * @author Nargiz
 */
public class ValidationUtility {
     public static Map<String, List<String>> validateRegistrationForm(RegistrationForm form) {
       //Map<String , List<String> > errorMap = new HashMap<>(); 
        Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
        
        //GenericValidator.
        
        // TODO 1.validate username
        List<String> usernameErrors = new ArrayList<String>();
        
        if(GenericValidator.isBlankOrNull(form.getUsername())) {
            usernameErrors.add("Username can not be empty");
        }
        
        if(form.getUsername().length() < 3) {
            usernameErrors.add("Minimum username length is 3 characters");
        }
        
        if(form.getUsername().length() > 30) {
            usernameErrors.add("Maximum username length is 30 characters");
        }
                       
        errorMap.put("username", usernameErrors);
        
        // TODO 2.validate name
        List<String> firstnameErrors = new ArrayList<String>();   
        if(GenericValidator.isBlankOrNull(form.getFirstname())) {
            firstnameErrors.add("Name can not by empty");
        }
        
        if(form.getFirstname().length() < 5) {
            firstnameErrors.add("Minimum name length is 5 characters");
        }
        
        if(form.getFirstname().length() > 30) {
            firstnameErrors.add("Maximum name length is 30 characters");
        }
        errorMap.put("firstname", firstnameErrors);
        
        // TODO 3.validate surname
        List<String> lastnameErrors = new ArrayList<String>();        
        if(GenericValidator.isBlankOrNull(form.getLastname())) {
            lastnameErrors.add("Surname can not by empty");
        }
        
        if(form.getLastname().length() < 5) {
            lastnameErrors.add("Minimum surname length is 5 characters");
        }
        
        if(form.getLastname().length() > 30) {
            lastnameErrors.add("Maximum surname length is 30 characters");
        }
        errorMap.put("lastname", lastnameErrors);
        
        // TODO 4.validate email
        List<String> emailErrors = new ArrayList<String>();        
        if(!GenericValidator.isEmail(form.getEmail())) {
            emailErrors.add("Email is invalid");
        }
        errorMap.put("email", emailErrors);
        
        // TODO 5.validate password
        List<String> passwordErrors = new ArrayList<String>();       
        if(GenericValidator.isBlankOrNull(form.getPassword()) || GenericValidator.isBlankOrNull(form.getPasswordConfirmation())) {
            passwordErrors.add("Password and confirmation can not be the empty");
        }
        
        if(!form.getPassword().equals(form.getPasswordConfirmation())) {
            passwordErrors.add("Password and confirmation must be same.");
        }
        errorMap.put("password", passwordErrors);
        
        // TODO 6.validate Country
        List<String> countryErrors = new ArrayList<String>();        
        if(GenericValidator.isBlankOrNull(form.getCountry())) {
            countryErrors.add("Country is invalid");
        }
        errorMap.put("country", countryErrors);
          
         List<String> cityErrors = new ArrayList<String>();        
        if(GenericValidator.isBlankOrNull(form.getCity())) {
            cityErrors.add("City is invalid");
        }
        errorMap.put("city", cityErrors);
      
    
   List<String> phoneNoErrors = new ArrayList<String>(); 
    if(GenericValidator.isBlankOrNull(form.getPhoneNo())) {
     phoneNoErrors.add("PhoneNo is invalid"); } 
    
    errorMap.put("PhoneNo", phoneNoErrors);
     
    List<String> addressErrors = new ArrayList<String>(); 
    if(GenericValidator.isBlankOrNull(form.getAddress())) { 
        addressErrors.add("Address is invalid"); }
    errorMap.put("address", addressErrors);
    
    List<String> postalCodeErrors = new ArrayList<String>();
    if(GenericValidator.isBlankOrNull(form.getPostalCode())) { 
        postalCodeErrors.add("PostalCode is invalid");
    } errorMap.put("PostalCode", postalCodeErrors);
    return errorMap;
    
}
}

