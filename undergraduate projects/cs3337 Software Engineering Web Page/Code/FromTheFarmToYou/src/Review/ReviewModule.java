package Review;

import java.io.IOException;



import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

@WebServlet("/Review/ReviewModule")
public class ReviewModule extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		request.getRequestDispatcher("/WEB-INF/Review/ReviewModule.jsp").forward(request, response);
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		
		String name = request.getParameter("name");
		String farm = request.getParameter("farm");
		String comment = request.getParameter("comment");
		
		/* Implements the date using both java method and sql method */
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getYear(), date.getMonth(), date.getDate());
		
		Connection c = null;
		try
		{

			String url = "jdbc:mysql://localhost:3306/cs3220stu76";
			String username = "cs3220stu76";
			String password = "abcd";
			
            String sql = "insert into Review (name, farm, comment, date) values(?,?,?,?);";

            c = DriverManager.getConnection( url, username, password);
            PreparedStatement pstmt = c.prepareStatement(sql);
            
			pstmt.setString(1, name);
			pstmt.setString(2, farm);
			pstmt.setString(3, comment);
			pstmt.setDate(4, sqlDate);
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


		response.sendRedirect("PostReviewModule");
	}
}