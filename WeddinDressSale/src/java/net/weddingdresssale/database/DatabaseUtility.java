/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 *
 * @author Nargiz
 */
public class DatabaseUtility {
    
 public static DataSource connect() throws Exception {
        InitialContext cxt = new InitialContext();
        if (cxt == null) {
            throw new Exception("No context!");
        }

        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/db_weddress");
        if (ds == null) {
            throw new Exception("Data source not found!");
        }        
        return ds;
    }
    
    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if(rs != null) {
                rs.close();
            }
            
            if(ps != null) {
                ps.close();
            }
            
            if(con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
