package ve.com.plasmodium.util;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailNotifier {
	public static final Logger logger = Logger.getLogger(MailNotifier.class);
	private String from;
	private String[] to;
	private String subject;
	private String text;
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_HOST_PORT = "587";
	private String SMTP_AUTH_USER = "cron@novared.com.ve";
	private String SMTP_AUTH_PWD  = "cron2011";

	public MailNotifier(String AuthUser, String AuthPwd, String from, String[] to, String subject, String text){
		this.SMTP_AUTH_USER = AuthUser;
		this.SMTP_AUTH_PWD = AuthPwd;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public MailNotifier(String from, String[] to, String subject, String text){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public MailNotifier(String[] to, String subject, String text){
		this.from = SMTP_AUTH_USER;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public void send(){

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.port", SMTP_HOST_PORT);
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", SMTP_AUTH_USER);
		props.put("mail.smtp.password", SMTP_AUTH_PWD);
		
		//props.put("mail.smtp.ssl.enable","true");

		Authenticator auth = new SMTPAuthenticator();
	    Session session = Session.getInstance(props, auth);
		//Session mailSession = Session.getDefaultInstance(props);
	    Message msg = new MimeMessage(session);
		
	    try {
	    	InternetAddress addressFrom = new InternetAddress(from);
		    msg.setFrom(addressFrom);

		    InternetAddress[] addressTo = new InternetAddress[to.length];
		    for (int i = 0; i < to.length; i++)	    {
					addressTo[i] = new InternetAddress(to[i]);
		    }
			msg.setRecipients(Message.RecipientType.TO, addressTo);
		    msg.setSubject(subject);
		    msg.setContent(text, "text/plain");
		    Transport.send(msg);
		    logger.debug("Correo enviado exitosamente");
		} catch (MessagingException e) {
			logger.error("MessagingException MailNotifier - send ", e);
		}
	}
	/**
	* SimpleAuthenticator is used to do simple authentication
	* when the SMTP server requires it.
	*/
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = SMTP_AUTH_USER;
	        String password = SMTP_AUTH_PWD;
	        return new PasswordAuthentication(username, password);
	    }
	}
}