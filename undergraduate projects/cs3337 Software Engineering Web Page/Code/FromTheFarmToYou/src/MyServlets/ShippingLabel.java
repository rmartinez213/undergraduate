package MyServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.SigninUser;

import shoppingCart.Products;

/**
 * Servlet implementation class ShippingLabel
 */
@WebServlet("/Farms/ShippingLabel")
public class ShippingLabel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShippingLabel() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		java.util.Date newdate = Calendar.getInstance().getTime();
		System.out.println("The date is " + newdate);
		session.setAttribute("date", newdate.toString());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String address = "";
		if(session.getAttribute("UserList") == null){
			ArrayList<Products> product = (ArrayList<Products>) session.getAttribute("productList");
			
			int totalEggs = 0;
			//get total num of eggs bought
			for(Products p: product){
				totalEggs += p.getQuantity(); //This gives total price of everything in the list. 	
			
			}
			session.setAttribute("totalEggs", totalEggs);
		}
		
		//ArrayList<SigninUser> user = (ArrayList<SigninUser>) session.getAttribute("UserList");
		if(session.getAttribute("UserList") !=null){
			ArrayList<Products> product = (ArrayList<Products>) session.getAttribute("productList");
			
			int totalEggs = 0;
			//get total num of eggs bought
			for(Products p: product){
				totalEggs += p.getQuantity(); //This gives total price of everything in the list. 	
			}
			
			int farmNum = product.get(0).getFarm_num();
			double totalPrice = (double) session.getAttribute("sumTax");
			
			
			ArrayList<SigninUser> user = (ArrayList<SigninUser>) session.getAttribute("UserList");
			String fname = user.get(0).getFirst_name();
			String lname = user.get(0).getLast_name();
			
			
			session.setAttribute("totalEggs", totalEggs);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			
			
			
			//Connect to db
	        Connection c = null; // set connection to db as null
	
			try {
	
				String url = "jdbc:mysql://localhost:3306/cs3220stu76";
				String username = "cs3220stu76";
				String password = "abcd";
				
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "SELECT address FROM users WHERE farm_num = " + farmNum);
	            while( rs.next() ){
	            	address = rs.getString("address");
	            	session.setAttribute("farmAddress", address);
	            	System.out.println("Farmer address is : " + address);
	            }
				
				//Create prepared statement to prevent sql injections
				java.util.Date date = new java.util.Date();
		        java.sql.Date sqlDate = new Date(date.getYear(), date.getMonth(), date.getDate());
		        
		        String currDate = date.toString();
		        //session.setAttribute("date", currDate);
		        
				if(session.getAttribute("UserList") != null){
					String query = "INSERT INTO orderhistory (first_name, last_name, farm_num, eggsbought, totalprice, date) values(?,?,?,?,?,?)";
					PreparedStatement statement = c.prepareStatement(query);
					statement.setString(1, fname);
					statement.setString(2, lname);
					statement.setInt(3, farmNum);
					statement.setInt(4, totalEggs);
					statement.setDouble(5, totalPrice);
					statement.setDate(6, sqlDate);
					statement.executeUpdate();
					
					
				}
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				
	
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
			request.getRequestDispatcher("/WEB-INF/Farms/ShippingLabel.jsp").forward(request, response);
			
		}
		
		
		else{
			request.getRequestDispatcher("/WEB-INF/Farms/ShippingLabel.jsp").forward(request, response);	
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
