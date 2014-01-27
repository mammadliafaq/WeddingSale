/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;
import net.weddingdresssale.domain.User;
/**
 *
 * @author Nargiz
 */
public interface LoginDao {
    User login(String username, String password); 
    
}
