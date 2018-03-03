package Lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		
		List<Lab4User> registeredUsers = new ArrayList<Lab4User>();
		 registeredUsers.add(new Lab4User("John Doe", "john","abcd"));
		 registeredUsers.add(new Lab4User("Mary Jane", "mary","abcd"));
		 registeredUsers.add(new Lab4User("Joe Boxer", "joe","abcd"));

		 getServletContext().setAttribute("registeredUsers",registeredUsers);
	}
	
    private String getName( HttpServletRequest request ){
        Cookie[] cookies = request.getCookies();
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "username" ) )
                    return cookie.getValue();

        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        out.println( "<html>" );
        out.println( 
        		"<head>"
        		+ "<title>Lab 4</title>"
        		+ "<link src='loginCss.css' rel='stylesheet'>"
        		+ "<link rel=\"stylesheet\" href=\"https://bootswatch.com/paper/bootstrap.min.css\">"
        		+ "</head>" );
        out.println( "<body>" );
        
        //JumboTron
        out.println("    <div class=\"jumbotron\">");
        out.println("        <h1>Login Servlet</h1>");
        out.println("        <p></p>");
        out.println("    </div>");
        
        //Form
        out.println(" <div>");
        out.println("     <form action=\"Login\" method=\"post\">");
        out.println("         <p  align=\"center\">");
        out.println("             <span class=\"glyphicon glyphicon-user\">");
        out.println("                 Username: <br><input type=\"text\" name=\"username\" />");
        out.println("             </span> <br><br>");
        out.println("             <span class=\"glyphicon glyphicon-lock\">");
        out.println("                 Password: <br><input type=\"password\" name=\"password\" id=\"passw\"/>");
        out.println("             </span> <br><br>");
        out.println("             <input type=\"checkbox\" value=\"Rememberme\" name=\"username\"> Remember me");
        out.println("             <input type=\"submit\" name=\"add\" value=\"Login\"/>");
        out.println("         </p>");
        out.println("     </form>");
        out.println(" </div>");
        
      //  out.println(getName);
        

        
        out.println( "</body></html>" );
        
        
        
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//This will get the username and password the user entered and store into a variable
		String InputName = request.getParameter("username");
		String InputPassword = request.getParameter("password");
		
		out.println(InputName);
		out.println(InputPassword);
		
		//This will get the list of the users
		ArrayList<Lab4User> UserList = (ArrayList<Lab4User>) getServletContext().getAttribute("registeredUsers");
		
		//Create for each loop to iterate through the list and get the data
		for(Lab4User user: UserList){
			if(InputName.equalsIgnoreCase(user.getUsername()) && InputPassword.equals(user.getPassword())){
				
				 
				HttpSession session = request.getSession();
				request.getSession().setAttribute("UserList", user); 
				 
				
				response.sendRedirect("Welcome");
				return;
			}	
		}			
		
			out.println( 
		    		"<head>"
		    		+ "<title>Lab 4</title>"
		    		+ "<link src='loginCss.css' rel='stylesheet'>"
		    		+ "<link rel=\"stylesheet\" href=\"https://bootswatch.com/paper/bootstrap.min.css\">"
		    		+ "</head>" );
		    out.println( "<body>" );
		    
		    //JumboTron
		    out.println("    <div class=\"jumbotron\">");
		    out.println("        <h1>Login Servlet</h1>");
		    out.println("        <p></p>");
		    out.println("    </div>");
		    
		    //Form
		    out.println(" <div>");
		    out.println("     <form action=\"Welcome\" method=\"post\">");
		    out.println(" 		  <h3 align='center' style='color:red;'>Invalid Username/and or Password</h3>");
		    out.println("         <p  align=\"center\">");
		    out.println("             <span class=\"glyphicon glyphicon-user\">");
		    out.println("                 Username: <br><input type=\"text\" name=\"username\" />");
		    out.println("             </span> <br><br>");
		    out.println("             <span class=\"glyphicon glyphicon-lock\">");
		    out.println("                 Password: <br><input type=\"password\" name=\"password\" id=\"passw\"/>");
		    out.println("             </span> <br><br>");
		    out.println("             <input type=\"checkbox\" name=\"box\"> Remember me");
		    out.println("             <input type=\"submit\" name=\"add\" value=\"Login\"/>");
		    out.println("         </p>");
		    out.println("     </form>");
		    out.println(" </div>");
		    
		 
	
			//Create a session
			HttpSession SendSession = request.getSession();
			SendSession.setAttribute("user", SendSession);
			
		
		
		doGet(request, response);
	}

}
