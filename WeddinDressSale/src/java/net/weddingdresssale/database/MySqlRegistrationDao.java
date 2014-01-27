/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.weddingdresssale.domain.RegistrationForm;
import net.weddingdresssale.utility.EncryptionUtility;

/**
 *
 * @author Nargiz
 */
public class MySqlRegistrationDao implements RegistrationDao {

    private DataSource dataSource;
    
    public MySqlRegistrationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public boolean isUniqueUsername(String username) {
        boolean unique = true;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.CHECK_USERNAME);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                unique = false;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, null, con);
        }
        
        return unique;
    }

    @Override
    public boolean register(RegistrationForm form) {
        boolean success = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.REGISTER_USER);
            
            ps.setInt(1, getMax()+1);
            ps.setString(2, form.getFirstname());
            ps.setString(3, form.getLastname());
            ps.setString(4, form.getUsername());
            ps.setString(5, EncryptionUtility.sha1(form.getPassword()));
            ps.setString(6, form.getEmail());
            ps.setString(7, form.getCountry());
            ps.setString(8, form.getCity());
            ps.setString(9, form.getAddress());
            ps.setString(10, form.getPostalCode());
            ps.setString(11, form.getPhoneNo());
            
            int count = ps.executeUpdate();
            if(count == 1) {
                success = true;
            }
        } catch(Exception e) {
                e.printStackTrace();
            
        } finally {
            DatabaseUtility.close(null, ps, con);
        }
        
        return success;        
    }
    
public int getMax() throws Exception{
    String query = "SELECT MAX(userId) FROM user";
        ResultSet resultSet;
        Connection con = dataSource.getConnection();
        Statement stmnt = con.createStatement();
        resultSet = stmnt.executeQuery(query);
        resultSet.next();
        int i = resultSet.getInt("Max(UserID)");
        con.close();
        return i; 
}
    
}
