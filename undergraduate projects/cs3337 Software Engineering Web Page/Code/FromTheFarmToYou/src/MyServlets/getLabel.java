package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmailLast.SendMail;
import Login.SigninUser;
import shoppingCart.Products;


@WebServlet("/Farms/getLabel")
public class getLabel extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		ArrayList<Products> products = (ArrayList<Products>) request.getSession().getAttribute("productList");
		//int farm_num = products.get(0).getFarm_num(); // Get the place egg is from
	
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String date = request.getParameter("date");
		
		
		String farmerText = "<body>"+
				"<h1 align=center> Show shipping label </h1>"+
				"<br><br>"+
				"<center><img style=\"vertical-align: right;\" width=\"100px\" height=\"75px\" src=\"http://cs3.calstatela.edu:8080/cs3220stu63/images/chick.png\"></center>"+
				"<br>"+
				"<center><table border=\"7\"><thead><tr>"+
				"<th>To:" + firstName + " " + lastName + "</th></tr></thead>"+
				"<tr><td>" + address + "</td>"+
				"</tr>"+
				"<tr><td>" + city + " " + state +  ", " + zip + "</td>"+
				"<tr>"+
				"<th>FROM: Daryl Dixon</th></tr>"+
				"<tr><td>Address: 123 Sesame street </td>"+
				"</tr><tr><td>Los Angeles, CA, 90123</td> "+
				"</tr><tr><td>United States</td></tr>"+
				"<tr><td><img style=\"vertical-align: bottom;\" width=\"274px\" height=\"50px\" src=\"http://cs3.calstatela.edu:8080/cs3220stu63/images/barcode.jpg\"></td></tr>"+
				"</table></center>"+
			"</body>";
					
				
		if(request.getSession().getAttribute("UserList") == null){ //No one is signed in
			double totalSum = (double) request.getSession().getAttribute("sumTax");
			double totalEggs = (int) request.getSession().getAttribute("totalEggs");
			String currdate = (String) request.getSession().getAttribute("date");
			String message = "";

			SigninUser currentUser = new SigninUser(0, firstName, lastName, null, email, null, null); 
			request.getSession().setAttribute("currentUser", currentUser);
			request.getSession().setAttribute("address", address);
			request.getSession().setAttribute("city", city);
			request.getSession().setAttribute("state", state);
			request.getSession().setAttribute("email", email);
			message = "<h2>Thank You For Your purchase </h2>" + firstName +  " " + lastName + "<br>"
					+ "----------------------------------------------------------------------------<br>"
					+ "You bought " + totalEggs + " eggs.<br><br>"
							+ "For a total of: $"+ totalSum + ". <br><br> "
									+ "On: " + currdate
									+"<br>----------------------------------------------------------------------------<br><br>"
									+ "<a href = \"http://cs3.calstatela.edu:8080/cs3220stu63/Review/ReviewModule\">Leave a review here! </a>"
									;
			
			SendMail.send(email, "Thank You For Your Purchase! ", message, "farmerSecond@gmail.com", "notAbc123"); //To customer
			SendMail.send("farmerSecond@gmail.com", "Shipping Label for customer", farmerText, "farmerSecond@gmail.com", "notAbc123");
			//request.getRequestDispatcher("/WEB-INF/Farms/ShippingLabel.jsp").forward(request, response);	//REDIRECT TO INDEX
			
		}
		
		else{
			double totalSum = (double) request.getSession().getAttribute("sumTax");
			double totalEggs = (int) request.getSession().getAttribute("totalEggs");
			String currdate = (String) request.getSession().getAttribute("date");
			String message = "";

			SigninUser currentUser = new SigninUser(0, firstName, lastName, null, email, null, null); 
			request.getSession().setAttribute("currentUser", currentUser);
			request.getSession().setAttribute("address", address);
			request.getSession().setAttribute("city", city);
			request.getSession().setAttribute("state", state);
			request.getSession().setAttribute("email", email);
			message = "<h2>Thank You For Your purchase </h2>" + firstName +  " " + lastName + "<br>"
					+ "----------------------------------------------------------------------------<br>"
					+ "You bought " + totalEggs + " eggs.<br> "
							+ "For a total of: $"+ totalSum + ". <br> "
									+ "On: " + currdate
									+"<br>----------------------------------------------------------------------------<br><br>"
									+ "<a href = \"http://cs3.calstatela.edu:8080/cs3220stu63/Review/ReviewModule\">Leave a review here! </a>"
									;
									;
			SendMail.send(email, "Thank You For Your Purchase! ", message, "farmerSecond@gmail.com", "notAbc123");
			SendMail.send("farmerSecond@gmail.com", "Shipping Label for customer", farmerText, "farmerSecond@gmail.com", "notAbc123");
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("The date " + date);
		//Invalidate session 
		request.getRequestDispatcher("/WEB-INF/Farms/ShowLabel.jsp").forward(request, response);		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
	}

}
