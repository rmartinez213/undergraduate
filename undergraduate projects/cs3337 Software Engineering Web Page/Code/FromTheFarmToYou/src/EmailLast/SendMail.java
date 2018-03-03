package EmailLast;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail{ 
    public static void send(String to, String sub,String msg, final String user,final String pass){ 
    	
    	//Help from: https://www.youtube.com/watch?v=gy2eEZhLihk
    	
    	Properties props = System.getProperties();
    	props.put("mail.smtp.host", "smtp.gmail.com");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.port", "465");
    	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	props.put("mail.smtp.socketFactory.port", "465");
    	props.put("mail.smtp.socketFactory.fallback", "false");
    	
    	Session mailSession = Session.getDefaultInstance(props);
    	//mailSession.setDebug(true); //Displays on console steps necessary to debug. 
    	
    	
    	try{
	    	Message mailMessage = new MimeMessage(mailSession);
	    	
	    	mailMessage.setFrom(new InternetAddress (user));
	    	mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	mailMessage.setContent(msg, "text/html");
	    	mailMessage.setSubject(sub);
	    	
	    	//Transport.send(mailMessage); //This works as well 
	    	
	    	Transport transport = mailSession.getTransport("smtp");
	    	transport.connect("smtp.gmail.com",user, pass);	//This is what what was missing  and causing authentication errors
	    	transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    		
	    	transport.close(); //end connection
    	
    	} catch(MessagingException e){
    		//Logger.getLogger(MailSenderBean.class.getName()).log(Level.SEVERE, null, e);
    		throw new RuntimeException(e);
    	}
   
    }
    
}
