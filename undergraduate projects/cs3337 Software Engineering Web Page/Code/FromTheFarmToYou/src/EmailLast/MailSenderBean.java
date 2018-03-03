package EmailLast;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Session Bean implementation class MailSenderBean
 */
@Stateless
@LocalBean
public class MailSenderBean {
	
	/* File no longer needed, but will be kept as a reference for the future. */
	public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message ){
	
		try{
			Properties props = System.getProperties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.ssl.enable", "true");
			
			
			
			Session mailSession = Session.getDefaultInstance(props);
			mailSession.setDebug(true);
			
			Message mailMessage = new MimeMessage(mailSession); 
			
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			mailMessage.setText(message);
			mailMessage.setSubject(subject);
			
			Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", username, password);
			
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			transport.close();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
    /**
     * Default constructor. 
     */
    public MailSenderBean() {
        // TODO Auto-generated constructor stub
    }

}
