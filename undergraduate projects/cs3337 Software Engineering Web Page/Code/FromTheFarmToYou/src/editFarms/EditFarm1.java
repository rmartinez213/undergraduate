package editFarms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditFarm1
 */
@WebServlet("/Farms/EditFarm1")
public class EditFarm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditFarm1() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/EditFarms/EditFarm1.jsp").forward(request, response);
		
		
		//Check if the farmer is logged in in the view of Farm1.jsp
		
	
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Get parameters that the farmer chose to edit 
		String h1_header = request.getParameter("h1_header");
		String service_text = request.getParameter("service_text");
		String first_h4 = request.getParameter("first_h4");
		String arranging_text = request.getParameter("arranging_text");
		String second_h4 = request.getParameter("second_h4");
		String arranging2_text = request.getParameter("arranging2_text");
		String third_h4 = request.getParameter("third_h4");
		String arranging3_text = request.getParameter("arranging3_text");
		String fourth_h4 = request.getParameter("fourth_h4");
		String arranging4_text = request.getParameter("arranging4_text");
		
		
		//Egg param
        String egg1Name = request.getParameter("egg1Name");
        String egg2Name = request.getParameter("egg2Name");
        String egg3Name = request.getParameter("egg3Name");
        String egg4Name = request.getParameter("egg4Name");
        String egg1Description = request.getParameter("egg1Description");
        String egg2Description = request.getParameter("egg2Description");
        String egg3Description = request.getParameter("egg3Description");
        String egg4Description = request.getParameter("egg4Description");
        int egg1Quantity = Integer.parseInt(request.getParameter("egg1Quantity"));
        int egg2Quantity = Integer.parseInt(request.getParameter("egg2Quantity"));
        int egg3Quantity = Integer.parseInt(request.getParameter("egg3Quantity"));
        int egg4Quantity = Integer.parseInt(request.getParameter("egg4Quantity"));
        double egg1Price = Double.parseDouble(request.getParameter("egg1Price"));
        double egg2Price = Double.parseDouble(request.getParameter("egg2Price"));
        double egg3Price = Double.parseDouble(request.getParameter("egg3Price"));
        double egg4Price = Double.parseDouble(request.getParameter("egg4Price"));
        
 
		
		
        Connection c = null;
        try
        {
			String url = "jdbc:mysql://localhost:3306/cs3220stu76";
			String username = "cs3220stu76";
			String password = "abcd";
			
            //Update the farms services
            String sql = "UPDATE farmerInfo SET h1_header = ?, service_texT = ?, first_h4 = ?, arranging_text = ?, second_h4 = ?, arranging2_text = ?, third_h4 = ?, arranging3_text = ?, fourth_h4 = ?, arranging4_text = ? WHERE id = 1";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1, h1_header);
            pstmt.setString(2, service_text);
            pstmt.setString(3, first_h4);
            pstmt.setString(4, arranging_text);
            pstmt.setString(5, second_h4);
            pstmt.setString(6, arranging2_text);
            pstmt.setString(7, third_h4);
            pstmt.setString(8, arranging3_text);
            pstmt.setString(9, fourth_h4);
            pstmt.setString(10, arranging4_text);
            pstmt.executeUpdate();
            
            //Update all egg info
            String update1Eggs = "UPDATE inventory SET name = ?, description = ?, price = ?, quantity = ? WHERE id = 1";
            String update2Eggs = "UPDATE inventory SET name = ?, description = ?, price = ?, quantity = ? WHERE id = 2";
            String update3Eggs = "UPDATE inventory SET name = ?, description = ?, price = ?, quantity = ? WHERE id = 3";
            String update4Eggs = "UPDATE inventory SET name = ?, description = ?, price = ?, quantity = ? WHERE id = 4";
            
            //Statement for egg 1. Update it
            pstmt = c.prepareStatement(update1Eggs);
            pstmt.setString(1, egg1Name);
            pstmt.setString(2, egg1Description);
            pstmt.setFloat(3, (float) egg1Price);
            pstmt.setInt(4, egg1Quantity);
            pstmt.executeUpdate();
            
            //For egg 2 
            pstmt = c.prepareStatement(update2Eggs);
            pstmt.setString(1, egg2Name);
            pstmt.setString(2, egg2Description);
            pstmt.setFloat(3, (float) egg2Price);
            pstmt.setInt(4, egg2Quantity);
            pstmt.executeUpdate();
            
            //For egg 3 
            pstmt = c.prepareStatement(update3Eggs);
            pstmt.setString(1, egg3Name);
            pstmt.setString(2, egg3Description);
            pstmt.setFloat(3, (float) egg3Price);
            pstmt.setInt(4, egg3Quantity);
            pstmt.executeUpdate();
            
            //For egg 4 
            pstmt = c.prepareStatement(update4Eggs);
            pstmt.setString(1, egg4Name);
            pstmt.setString(2, egg4Description);
            pstmt.setFloat(3, (float) egg4Price);
            pstmt.setInt(4, egg4Quantity);
            pstmt.executeUpdate();
                 
            /*ResultSet rs = pstmt.executeQuery();

            if( rs.next() != false ){
                entry = new GuestBookEntry( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getString( "message" ) );
            }*/
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
		
		//redirect here 
		response.sendRedirect("FarmController");
        
        
        
        
	}

}
