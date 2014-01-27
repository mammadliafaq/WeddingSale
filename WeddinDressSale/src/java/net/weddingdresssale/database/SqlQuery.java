/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;

/**
 *
 * @author Nargiz
 */
public class SqlQuery {
    public static final String LOGIN = "SELECT userId, firstname, lastname, city, country,address, postalCode, phoneNo, email FROM db_weddress.user where username = ? and password = ?";
    
    public static final String CHECK_USERNAME = "SELECT userId FROM db_weddress.user where username = ?";
    
    public static final String REGISTER_USER = "insert into db_weddress.user (userId, firstname, lastname, username, password, city, country, address, postalCode, phoneNo, email) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
}
