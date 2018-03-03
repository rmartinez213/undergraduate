package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab3/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Variables needed for servlet
		String Method = request.getMethod();
		
		/*
		 * Create enumeration/getParameterNames() in order to get data
		 * Data is then added to the arraylist created below
		*/
		Enumeration<String> ParameterValues = request.getParameterNames();
		ArrayList<String>ArrayListParameter = new ArrayList<String>();
		while(ParameterValues.hasMoreElements()){
			ArrayListParameter.add(ParameterValues.nextElement());
		}
		
		Enumeration<String> HeaderValues = request.getHeaderNames(); 
		ArrayList<String> ArrayListHeader = new ArrayList<String>();
	
		while(HeaderValues.hasMoreElements()){
			ArrayListHeader.add((String)HeaderValues.nextElement()); 
		}
		 
		out.println( "<html>" );
        out.println( "<head><title>Display Request Info</title><link rel='stylesheet' href='https://bootswatch.com/paper/bootstrap.min.css'></head>" );
        out.println( "<body>" );
        
        
        out.println( 
        "<div class='jumbotron'> "+
        	"<h1 style = 'text-align: center'>Request Parameters (Lab3)</h1> " +
        	"<p><h4 style = 'text-align: center'>The following <b>" + Method + "</b> request was submitted on: " + new Date() + "</h4></p>" +
        "</div>"
        );
		
		//Parameter Information
		out.println("<h1 align= 'center'>Request Parameters </h1>");

		
		//Header Value
		out.println("<table class='table table-striped table-hover ' align='center' style='width:50%'>"
				+ "<thead>"
				+ 	"<tr>"
				+ 		"<th>Paraemeter Field</th>"
				+		"<th>Parameter Value</th>"
				+ 	"</tr>"
				+ "</thead><tbody>");
		
		
		for(String ParameterInfo: ArrayListParameter){
			out.println("<tr>"
					+      "<td>" + ParameterInfo + "</td>"
					+      "<td>" + request.getParameter(ParameterInfo) + "</td>"
					+   "</tr>");
		}
		out.println("</tbody></tabel></body></html>");
		
		
		
		
				
		//Header Value
		out.println("<table class='table table-striped table-hover ' align='center' style='width:50%'>"
				+ "<thead>"
				+ 	"<tr>"
				+ 		"<th>Header Field</th>"
				+		"<th>Header Value</th>"
				+ 	"</tr>"
				+ "</thead>");
		
		for(String HeadInfo:ArrayListHeader){
			out.println("<tbody>"
					+   "<tr>"
					+      "<td>" + HeadInfo + "</td>"
					+      "<td>" + request.getHeader(HeadInfo) + "</td>"
					+   "</tr>");
		}
		out.println("</tbody></tabel></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
