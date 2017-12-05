package managers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {

	private final static String USER_NAME 	= "hourreport.p";
	private final static String PASS 		= "tomer7722";
	private final static String FROM_MAIL 	= "hourreport.p@gmail.com";
	
	public static void sendMail(String to, String subject, String msg) throws MessagingException{
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASS);
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROM_MAIL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(msg);

		Transport.send(message);
	}
}
