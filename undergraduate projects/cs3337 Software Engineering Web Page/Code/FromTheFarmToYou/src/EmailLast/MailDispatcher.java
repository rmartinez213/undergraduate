package EmailLast;

import java.io.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

@WebServlet("/Farms/MailDispatcher")
public class MailDispatcher extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/mail/EmailClient.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String to = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        //String user = request.getParameter("user");
        //String pass = request.getParameter("pass");
        SendMail.send(to, subject, message, "farmerSecond@gmail.com", "notAbc123");
        out.println("Mail sent successfully");
        //Redirect to index
        
    }   
}