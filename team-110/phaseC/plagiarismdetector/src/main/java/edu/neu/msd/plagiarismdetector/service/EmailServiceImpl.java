package edu.neu.msd.plagiarismdetector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * class EmailServiceImpl sends email to admin when something
 * bad happens
 * @author Frenia Pinto
 *
 */
@Component
public class EmailServiceImpl implements EmailService{
  

	@Autowired
	private JavaMailSender emailSender;
	
	/**

     * The function sends the email to the admin
     * @param to String Send-to email address
     * @param subject String subject of the e-mail
     * @param text String Body of the e-mail
     */

	@Override
    public void sendMessage(String to, String subject, String text) {
	

        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
	

    }
} 