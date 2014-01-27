/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;
import net.weddingdresssale.domain.RegistrationForm;
/**
 *
 * @author Nargiz
 */
public interface RegistrationDao {
    public boolean isUniqueUsername(String username);
    
    public boolean register(RegistrationForm form);
}
