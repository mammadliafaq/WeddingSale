/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.service;
import net.weddingdresssale.database.LoginDao;
import net.weddingdresssale.domain.User;
/**
 *
 * @author Nargiz
 */
public class DefaultLoginService implements LoginService {
    
    private LoginDao loginDao;
    
    public DefaultLoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    @Override
    public User login(String username, String password) {
        return loginDao.login(username, password);
    }           

 
    
}
