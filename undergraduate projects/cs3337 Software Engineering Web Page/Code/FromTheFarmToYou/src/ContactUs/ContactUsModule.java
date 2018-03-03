package ContactUs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import Login.SigninUser;


/**
 * Servlet implementation class ContactUs
 */

@WebServlet("/ContactUs/ContactUsModule")
public class ContactUsModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Get the session from the user to get status (admin or customer)
		HttpSession session = request.getSession();
		
		//User has not signed in (prevents session error)
		if(session.getAttribute("UserList") == null){
			request.getRequestDispatcher("/WEB-INF/ContactUs/ContactUs.jsp").forward(request, response);
		}
		
		else{
			
			ArrayList<SigninUser> List = (ArrayList) session.getAttribute("UserList");
			String status = "";
			
			for(SigninUser user: List){
				status = user.getStatus();
			}
			
			if(status.equals("Admin")){
				request.getRequestDispatcher("/WEB-INF/ContactUs/ContactUsAdmin.jsp").forward(request, response);
			}
			
			else{
				request.getRequestDispatcher("/WEB-INF/ContactUs/ContactUs.jsp").forward(request, response);
			}
			
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String names = request.getParameter("name");
		System.out.println("For name i got " + names );
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		String itemUploaded = "";	//Eventually becomes, names of files uploaded
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getYear(), date.getMonth(), date.getDate());
		
		//Fix error. Cannot get parameters if file is uploaded, so will leave as so for demo
		//ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		
		//List<FileItem> multifiles;
	
		
		Connection c = null;
		try
		{

            String url = "jdbc:mysql://localhost:3306/cs3220stu76";
            String username = "cs3220stu76";
            String password = "abcd";
			
            String sql = "insert into ContactUs (name, email, comment, date) values(?,?,?,?);";

            c = DriverManager.getConnection( url, username, password);
            PreparedStatement pstmt = c.prepareStatement(sql);
            
            
			pstmt.setString(1, names);
			pstmt.setString(2, email);
			pstmt.setString(3, comment);
			pstmt.setDate(4, sqlDate);
		//	pstmt.setString(5, itemUploaded);
			pstmt.executeUpdate();
		}
		
		catch( SQLException e )
		{
			throw new ServletException( e );
		}
		finally
		{
			try
			{
				if( c != null ) c.close();
			}
			catch( SQLException e )
			{
				throw new ServletException( e );
			}
		}
		
	
		request.getRequestDispatcher("/WEB-INF/ContactUs/ContactUsThankYou.jsp").forward(request, response);
		
	}
}
