/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.service;
import net.weddingdresssale.domain.RegistrationForm;
/**
 *
 * @author Nargiz
 */
public interface RegistrationService {
    public boolean isUniqueUsername(String username);
    
    public boolean register(RegistrationForm form);
}
