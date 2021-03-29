package model.bo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import model.dao.SendEmailDAO;
public class SendEmailBO {
	SendEmailDAO sendemailDAO= new SendEmailDAO();
	public String SelectAccout(String accId) {
		return sendemailDAO.SelectAccout(accId);
	}
	public  void sendMail(String recepient) throws Exception{
		System.out.println("ok");
		Properties properties = new Properties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		String fromUser ="fourclover1912@gmail.com";
		String Password="1154920152325555";
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromUser, Password);
			}
		}) ;
		Message message = prepareMessage(session, fromUser, recepient);
		Transport.send(message);
		System.out.println("ok");
	}
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("WTF");
			message.setText("game là dễ");
			return message;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SendEmailBO.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		return null;
	}
}
