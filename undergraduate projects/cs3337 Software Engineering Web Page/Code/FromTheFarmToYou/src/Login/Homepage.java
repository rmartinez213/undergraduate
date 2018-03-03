package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Homepage
 */
@WebServlet("/Login/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//Deliver the session to welcome page
		HttpSession SessionValue = request.getSession();
		ArrayList<SigninUser>  UserObj = (ArrayList<SigninUser>) SessionValue.getAttribute("UserList");
		
		//These if statements will redirect to Login if user accidentally lands on Welcome page
		if(UserObj != null){
			out.println("Welcome " + UserObj.get(0).getUsername());
		}
		
		else{
			response.sendRedirect("Login");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
