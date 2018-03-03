package Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/Login/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static int idSeed = 1;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/Login_Registration/Registration.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the user input
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");  
        String email = request.getParameter("email");
        String usernameGiven = request.getParameter("username");
        String passwordGiven = request.getParameter("password");
        String password2Given = request.getParameter("password2");
        
        
        //Boolean variables to validate & display error message
        boolean validfName = firstname != null && firstname.trim().length() > 0;
        boolean validlName = lastname != null && lastname.trim().length() > 0;
        boolean validEmail = email != null && email.trim().length() > 0;
        boolean validUserName = usernameGiven != null && usernameGiven.trim().length() > 0;
        boolean validPassword = passwordGiven != null && passwordGiven.trim().length() > 0;
        boolean validPassword2 = password2Given != null && password2Given.trim().length() > 0;
        
        
        
        if (validfName && validEmail && validUserName && validPassword && validPassword2 && passwordGiven.equals(password2Given)){
        
        	
            //Create new user, that matches that of the db requirements. USE PREPARED STATEMENTS
            SigninUser UserEntry = new SigninUser( idSeed++, firstname, lastname, usernameGiven, email, passwordGiven, "Customer");
            
            //add to database the users
            Connection c = null; // set connection to db as null

    		try {

    			String url = "jdbc:mysql://localhost:3306/cs3220stu76";
    			String username = "cs3220stu76";
    			String password = "abcd";
    			
    			c = DriverManager.getConnection(url, username, password);
    			
    			
    			//Create prepared statement to prevent sql injections
    			String query = "INSERT INTO users (first_name, last_name, username, email, password, status) values(?,?,?,?,?,?)";
    			PreparedStatement statement = c.prepareStatement(query);
    			statement.setString(1, firstname);
    			statement.setString(2, lastname);
    			statement.setString(3, usernameGiven);
    			statement.setString(4, email);
    			statement.setString(5, passwordGiven);
    			statement.setString(6, "Customer");
    			statement.executeUpdate();
    			
    			

    		} catch (SQLException e) {
    			throw new ServletException(e);
    		}

    		finally {
    			try {
    				if (c != null) {
    					c.close();
    				}

    			} catch (SQLException e) {
    				throw new ServletException(e);
    			}
    		}
            

            // send the user back to the guest book page
            response.sendRedirect("Signin");
            
        }
        
        else{
            if (!validfName)
                request.setAttribute("fnameError", "Please enter your first name");
            if (!validlName)
                request.setAttribute("lnameError", "Please enter your last name");
            if(!validEmail)
                request.setAttribute("emailError", "Please enter a email");
            if(!validUserName)
                request.setAttribute("usernameError", "Please enter a username");
            if(!passwordGiven.equals(password2Given))
            	request.setAttribute("failsameError", "Passwords do not match");
            if(!validPassword)
                request.setAttribute("passwordError", "Please enter a password");
            if(!validPassword2)
                request.setAttribute("password2Error", "Please confirm the password");
            
            doGet(request, response);
        }
	}

}
