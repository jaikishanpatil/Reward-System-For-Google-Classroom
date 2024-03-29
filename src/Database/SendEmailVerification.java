package Database;




import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailVerification {
	static int OTP;
	public static String str1;
	//EOTP_valid ev=new EOTP_valid();

	public static void sendmail(String recepient) throws Exception{
		System.out.println("Preparing to send email");
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail=Credentials.username;
		String password=Credentials.password;
		
		Session session=Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(myAccountEmail,password);
			}
		});
		Message message=prepareMessage(session,myAccountEmail,recepient);	
		Transport.send(message);
		System.out.println("Message sent successfully");
	}
	private static Message prepareMessage(Session session, String myAccountEmail ,String recepient){
		try{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("OTP for Student Verification");
			Random rand=new Random();
			OTP = rand.nextInt(99999);
			str1=Integer.toString(OTP);
			message.setText("Your OTP is "+ str1);
			return message;
			
		}catch(Exception ex){
			Logger.getLogger(SendEmailVerification.class.getName()).log(Level.SEVERE,null,ex);
			
		}
		return null;
	}

}
