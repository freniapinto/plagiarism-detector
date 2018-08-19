package edu.neu.msd.plagiarismdetector.service;

/**
* Interface EmailService to send e-mail when something bad happens
* @author Frenia Pinto
*
*/
public interface EmailService {
	public void sendMessage(String to, String subject, String text);
}