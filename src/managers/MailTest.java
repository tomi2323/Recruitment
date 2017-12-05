package managers;

import javax.mail.MessagingException;

public class MailTest {

	public static void main(String[] args) {
		try {
			MailHelper.sendMail("hourreport.p@gmail.com", "test", "test");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
