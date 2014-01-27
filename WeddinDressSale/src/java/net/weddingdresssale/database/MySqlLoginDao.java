/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;

/**
 *
 * @author Nargiz
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import net.weddingdresssale.domain.User;


public class MySqlLoginDao implements LoginDao {

    private DataSource dataSource;
    
    public MySqlLoginDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public User login(String username, String password) {
        
        User user = null;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.LOGIN);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setCity(rs.getString("city"));
                user.setAddress(rs.getString("address"));
                user.setPostalCode(rs.getString("postalCode"));
                user.setPhoneNo(rs.getString("phoneNo"));
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, ps, con);
        }
        
        return user;
        
    }
    
}

