/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.weddingdresssale.database.DatabaseUtility;
import net.weddingdresssale.database.MySqlRegistrationDao;
import net.weddingdresssale.database.RegistrationDao;
import net.weddingdresssale.domain.RegistrationForm;
import net.weddingdresssale.service.DefaultRegistrationService;
import net.weddingdresssale.service.RegistrationService;

/**
 *
 * @author raminorujov
 */
public class ControllerServlet extends HttpServlet {

    
    private RegistrationForm readRegistrationData(HttpServletRequest request) {
        RegistrationForm form = new RegistrationForm();
        
        if(request.getParameter("username") != null) {
            form.setUsername(request.getParameter("username").trim());
        }
        
        if(request.getParameter("firstname") != null) {
            form.setFirstname(request.getParameter("firstname").trim());
        }
        
        if(request.getParameter("lastname") != null) {
            form.setLastname(request.getParameter("lastname").trim());
        }
        
        if(request.getParameter("email") != null) {
            form.setEmail(request.getParameter("email").trim());
        }
        
        if(request.getParameter("password") != null) {
            form.setPassword(request.getParameter("password").trim());
        }
        
        if(request.getParameter("passwordConfirmation") != null) {
            form.setPasswordConfirmation(request.getParameter("passwordConfirmation").trim());
        }
        if(request.getParameter("country") != null) {
            form.setCountry(request.getParameter("country").trim());
        }
     if(request.getParameter("city") != null) {
            form.setCity(request.getParameter("city").trim());
        }
        
     if(request.getParameter("address") != null) {
            form.setAddress(request.getParameter("address").trim());
        }
     
     if(request.getParameter("postalCode") != null) {
            form.setPostalCode(request.getParameter("postalCode").trim());
        }
     if(request.getParameter("phoneNo") != null) {
            form.setPhoneNo(request.getParameter("phoneNo").trim());
        }
        return form;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            DataSource ds = DatabaseUtility.connect();
            RegistrationDao registrationDao = new MySqlRegistrationDao(ds);
            RegistrationService registrationService = new DefaultRegistrationService(registrationDao);
            System.out.println("1");
            
            HttpSession session = request.getSession();
            String action = "";
            
           // if(request.getParameter("action") != null) {
               // action = request.getParameter("action").trim();
            
            
            
           // if(action.equals("register")) {
                // Action plan
                // 1.read registration form data
                // 2.validate form data
                // 3.process registration business logic
                // 4.redirect/forward user to required page
                
                //1.read registration form data
                RegistrationForm form = readRegistrationData(request);
                
                Map<String, List<String>> errors = ValidationUtility.validateRegistrationForm(form);
            System.out.println("2");    
                if(!registrationService.isUniqueUsername(form.getUsername())) {
                    errors.get("username").add("Username must be unique");
                }
                
                boolean isValidForm = true;
                
                for(String key : errors.keySet()) {
                    List<String> validationErrors = errors.get(key);
                    if(!validationErrors.isEmpty()) {
                        isValidForm = false;
                        break;
                    }
                }
                System.out.println("3");
                // 3.process registration business logic
                // 3a.if data is valid, continue registration processing
                // 3b.save reg data and redirect user to registration page, show errors
                if(isValidForm) {
                    // 3a.if data is valid, continue registration processing
                    boolean success = registrationService.register(form);
                    String registrationResult = "";
                    if(success) {
                        registrationResult = "You've successfully registered";
                    } else {
                        registrationResult = "Your registration failed. Please try again or contact support";
                    }
                    
                    /*RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
                    request.setAttribute("message", registrationResult);
                    rd.forward(request, response);*/
                    response.sendRedirect("result.jsp");
                } else {
                    // 3b.save reg data and redirect user to registration page, show errors
                    session.setAttribute("registrationErrors", errors);
                    session.setAttribute("registrationForm", form);
//                    response.sendRedirect("register.jsp");
                    response.sendRedirect("register.jsp");
                }
                System.out.println("4");
            }// else {
                
            //} }
         catch(Exception e) {
            e.printStackTrace();
            System.out.println("Catch'e dusur");
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
