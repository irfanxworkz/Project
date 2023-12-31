package com.xworkz.parking.util;

import java.text.DecimalFormat;
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

import org.springframework.stereotype.Component;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.UserInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserParkingEmail {
	
	private String hostName;
	private String user;
	private String password;
	private String to;
	private String portNumber;
	
	public boolean sendMail(String email, UserParkingInfoDTO userParkingInfoDTO) {
		log.info("running sendMail");
		hostName = "smtp.office365.com";
		user = "irfankhan2690@outlook.com";
		password = "IRas@0409";
		to = email;
		portNumber = "587";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", hostName);
		properties.put("mail.smtp.port", portNumber);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.transport.protocal", "smtp");
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.setSubject("registration completed");
			message.setText("Thank you for registration");
			message.addRecipient (Message.RecipientType.TO, new InternetAddress(to));
			message.setContent("<h1>Hello , you are registered successfully!<h1/>" 
					+"<h5>Your Parking Details:</h5>"
					+"Location: "+userParkingInfoDTO.getLocation()+"<br/>"
					+"Type: "+userParkingInfoDTO.getType()+"<br/>"
					+"Classification: "+userParkingInfoDTO.getClassification()+"<br/>"
					+"terms: "+userParkingInfoDTO.getTerms()+"<br/>"
					+"Total Amount: "+userParkingInfoDTO.getTotalAmount()+"<br/>"
					+"<b>Thanks & Regards</b>,<br/>"
					+"x=workz", "text/html");
			Transport.send(message);
			log.info("mail sent to "+email);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean otpSendMail(String email, UserInfoEntity userInfoEntity) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		final String fromEmail= "irfankhan2690@outlook.com";
		final String password = "KHan@1234";
		String to = email;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.host", hostName);
		properties.put("mail.smtp.port", portNumber);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.debug", true);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.transport.protocol", "smtp");
		
		Session session=Session.getInstance(properties, new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		try {
			String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
			/* log.info(otp); */
			userInfoEntity.setOneTimePassword(otp);
			
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("here your one time password sent by irfan");
			message.setText("OTP = " +userInfoEntity.getOneTimePassword() +" ");
			//here we need to add code
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;	
	}

}
