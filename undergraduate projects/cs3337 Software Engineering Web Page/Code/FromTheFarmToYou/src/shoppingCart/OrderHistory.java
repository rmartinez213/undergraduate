package shoppingCart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.SigninUser;


@WebServlet("/Farms/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderHistory() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		if(session.getAttribute("UserList") == null){
			//No one is signed in
			request.getRequestDispatcher("/WEB-INF/Farms/OrderHistory.jsp").forward(request, response);	
			
		}
		else{
			ArrayList<SigninUser> user = (ArrayList<SigninUser>) session.getAttribute("UserList"); 
			request.getRequestDispatcher("/WEB-INF/Farms/OrderHistory.jsp").forward(request, response);			
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
