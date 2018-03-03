package ExtraCredit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExtraCredit/Todo")
public class Todo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	      PrintWriter out = response.getWriter();
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
	        
	      Connection c = null;
	        
	      try
	        { 
	            String query = request.getParameter("query");
	            query = query == null ? "" : query;
	            
	          String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu76";
	            String username = "cs3220stu76";
	            String password = "wTc#o7#M";

	          c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from todo WHERE id LIKE '%" + query + "%'" );

	          out.println("[");
	            while( rs.next() )
	            {
	                out.println("{");
	                out.println( "\t\"id\": \"" + rs.getString( "id" ) + "\", " );
	                out.println( "\t\"text\": \"" + rs.getString( "text" ) + "\", " );
	                out.println( "\t\"done\": " + rs.getInt( "done" ) );                
	              out.println( "}," );
	            }
	            out.println("]");

	          c.close();
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
	      
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("text");
		
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu76";
			String username = "cs3220stu76";
			String password = "wTc#o7#M";
			
            String sql = "delete FROM todo WHERE id=" + id;

            c = DriverManager.getConnection( url, username, password);
            PreparedStatement pstmt = c.prepareStatement(sql);
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
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		Connection c = null;
		try
		{


			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu76";
			String username = "cs3220stu76";
			String password = "wTc#o7#M";
			
            String sql = "delete FROM todo WHERE id=" + id;

            c = DriverManager.getConnection( url, username, password);
            PreparedStatement pstmt = c.prepareStatement(sql);
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
	}

}
