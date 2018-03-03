package Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet(urlPatterns = "/Login/Signin", loadOnStartup = 1)
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		/*NOT needed since info stored in a database// Create a local list of Todo Items
		ArrayList<SigninUser> ListOfUsers = new ArrayList<SigninUser>();
		
		//Pre-populate my list
		ListOfUsers.add(new SigninUser(1, "Robert Martinez", "rmartinez213@yahoo.com","rmart167", "test"));
		
	    getServletContext().setAttribute( "UserList", ListOfUsers);
	    */
		
	    //Connect to database
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	    
	    
	    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		
		request.getRequestDispatcher("/WEB-INF/Login_Registration/Signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gather user input
		HttpSession session = request.getSession();
		String usernameGiven = request.getParameter("username");
		String passwordGiven = request.getParameter("password");
		
		//Boolean to direct to error message
		boolean validUserName = usernameGiven != null && usernameGiven.trim().length() > 0;
        boolean validPassword = passwordGiven != null && passwordGiven.trim().length() > 0;
		
		//This will get the list of the users
		//NOT needed due to db ArrayList<SigninUser> UserList = (ArrayList<SigninUser>) getServletContext().getAttribute("UserList");
        
        ArrayList<SigninUser> user = new ArrayList<SigninUser>();
        
        Connection c = null; // set connection to db as null

		try {

			String url = "jdbc:mysql://localhost:3306/cs3220stu76";
			String username = "cs3220stu76";
			String password = "abcd";
            
			c = DriverManager.getConnection(url, username, password);
			Statement statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users");
			
			

			while (rs.next()) {//has been implemented: Ignore =>IMPLEMENT THIS Here if user matches username and password from db then signe them in
				if(rs.getString("username").equals(usernameGiven) && rs.getString("password").equals(passwordGiven)){
					SigninUser signedUser = new SigninUser(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("status"));
					user.add(signedUser);
					
					session.setAttribute("sFname", signedUser.getFirst_name() );
					session.setAttribute("sLname", signedUser.getLast_name());
					
					if(rs.getInt("farm_num") > 0){
						session.setAttribute("farmNum", rs.getInt("farm_num"));
					}
					session.setAttribute("UserList", user);
					
					if (c != null) {
						c.close();
					}
					//redirect to other servlet
					response.sendRedirect("../ChickenPages/index");
					
					
					
					return;	
					
				}
				

				else{
					ArrayList<SigninUser> currentUser = (ArrayList<SigninUser>) session.getAttribute("UserList"); //Null pointer
					
					
					
					if(!validUserName){
			            request.setAttribute("usernameError", "Please enter a username");
			            request.removeAttribute("incorrectusernameError");
						request.setAttribute("incorrectusernameError", "");
					}
					else{
						request.setAttribute("incorrectusernameError", "Incorrect username.");
						request.removeAttribute("usernameError");
						request.setAttribute("usernameError", "");
					}
					
					
					
					if(!validPassword){
			        	request.setAttribute("passwordError", "Please enter a password");
			        	request.removeAttribute("incorrectpasswordError");
			        	request.setAttribute("incorrectpasswordError", "");
						System.out.println("2");
			        }
			        else{
						request.setAttribute("incorrectpasswordError", "Incorrect password");
						request.removeAttribute("passwordError");
						request.setAttribute("passwordError", "");
						System.out.println("3");
			        }
			
				}
				
				
			}
			// To get column name if for some forgot.//// ResultSetMetaData meta
			// = rs.getMetaData();

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
		
		/*//Create for each loop to iterate through the list and get the data
		for(SigninUser user: UserList){
			if(username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())){
				
				//A session to store data for a limited amount of time
				HttpSession session = request.getSession();
				session.setAttribute("UserList", user);
				
				//redirect to other servlet
				response.sendRedirect("Homepage");
				return;
			}
			
			else{
				if(username.equalsIgnoreCase(user.getUsername())){
					request.removeAttribute("incorrectusernameError");
					request.removeAttribute("usernameError");
				}
				
				else if(!validUserName){
		            request.setAttribute("usernameError", "Please enter a username");
		            request.removeAttribute("incorrectusernameError");
					request.setAttribute("incorrectusernameError", "");
				}
				else{
					request.setAttribute("incorrectusernameError", "Incorrect username.");
					request.removeAttribute("usernameError");
					request.setAttribute("usernameError", "");
				}
				
				if(password.equals(user.getPassword())){
					request.removeAttribute("passwordError");
					request.removeAttribute("incorrectpasswordError");
					System.out.println("1");
				}
				
				else if(!validPassword){
		        	request.setAttribute("passwordError", "Please enter a password");
		        	request.removeAttribute("incorrectpasswordError");
		        	request.setAttribute("incorrectpasswordError", "");
					System.out.println("2");
		        }
		        else{
					request.setAttribute("incorrectpasswordError", "Incorrect password");
					request.removeAttribute("passwordError");
					request.setAttribute("passwordError", "");
					System.out.println("3");
		        }
			}
		}*/
		    
		doGet(request, response);
	}

}