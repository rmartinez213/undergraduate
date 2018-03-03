package chickenPages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.SigninUser;


@WebServlet("/chickenPages/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the session from the user to get status (admin or customer)
		HttpSession session = request.getSession();
		
		//User has not signed in (prevents session error)
		if(session.getAttribute("UserList") == null){
			request.getRequestDispatcher("/WEB-INF/Profile/NoProfile.jsp").forward(request, response);
		}
		
		else{
			request.getRequestDispatcher("/WEB-INF/Profile/ViewProfile.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
