package Database;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegisterConfirmationEmail {
	static int OTP;
	public static String str1;

	public RegisterConfirmationEmail(String to) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Credentials.username, Credentials.password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Credentials.username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Random rand = new Random();
			OTP = rand.nextInt(99999);
			str1 = Integer.toString(OTP);
			message.setSubject("OTP for register in Reward System For google classroom");
			message.setText("Your OTP for registration is " + OTP);
			Transport.send(message);
		} catch (MessagingException max) {
			max.printStackTrace();
		}
	}
}
