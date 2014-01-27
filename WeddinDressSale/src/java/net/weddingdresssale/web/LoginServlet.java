/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.weddingdresssale.database.DatabaseUtility;
import net.weddingdresssale.database.LoginDao;
import net.weddingdresssale.database.MySqlLoginDao;
import net.weddingdresssale.domain.User;
import net.weddingdresssale.service.DefaultLoginService;
import net.weddingdresssale.service.LoginService;
import net.weddingdresssale.utility.EncryptionUtility;

/**
 *
 * @author Nargiz
 */
public class LoginServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(username != null && username.trim().length() > 0 && 
                    password != null && password.trim().length() > 0) {
                username = username.trim();
                password = password.trim();
                
                DataSource ds = DatabaseUtility.connect();
                LoginDao loginDao = new MySqlLoginDao(ds);
                LoginService loginService = new DefaultLoginService(loginDao);
                User user = loginService.login(username, EncryptionUtility.sha1(password));
                HttpSession session = request.getSession();
                
                if(user != null) {                    
                    session.setAttribute("user", user);
                    session.setAttribute("loginTime", new Date());
                    response.sendRedirect("index.jsp");
                    System.out.println("user " + user.getUsername() + " successfully logged in");
                } else {
                    System.out.println("Invalid user and password. user " + username);                    
                    response.sendRedirect("login.jsp");
                }
                                
            } else {
                System.out.println("Username or password is invalid");
                response.sendRedirect("login.jsp");
            }
        } catch(Exception e) {  
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }   
}
