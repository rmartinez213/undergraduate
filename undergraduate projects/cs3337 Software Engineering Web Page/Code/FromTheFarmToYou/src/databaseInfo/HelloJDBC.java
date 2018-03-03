package databaseInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Db/HelloJDBC")
public class HelloJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloJDBC() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("	<html>");
		out.println("	<head>");
		out.println("		<title> Hello Database! </title>");
		out.println("	</head>");
		out.println("	<body>");
		
		Connection c = null; // set connection to db as null

		try {

			String url = "jdbc:mysql://localhost:3306/cs3220stu76";
			String username = "cs3220stu76";
			String password = "abcd";
			c = DriverManager.getConnection(url, username, password);
			Statement statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users");

			while (rs.next()) {
				out.println("<br/>");
				out.println(rs.getInt("ids"));
				out.println(rs.getString("first_name"));
				out.println(rs.getString("last_name"));
				out.println(rs.getString("username"));
				out.println(rs.getString("email"));
				out.println(rs.getString("password"));
				out.println(rs.getString("status"));
				out.println("<br/>");
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

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
