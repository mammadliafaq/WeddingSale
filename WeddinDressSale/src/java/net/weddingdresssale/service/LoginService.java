/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.service;
import net.weddingdresssale.domain.User;
/**
 *
 * @author Nargiz
 */
public interface LoginService {
    User login(String username, String password);
    
}
