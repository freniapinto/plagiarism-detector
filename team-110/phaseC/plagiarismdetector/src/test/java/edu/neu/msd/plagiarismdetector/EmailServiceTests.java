package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.neu.msd.plagiarismdetector.service.EmailService;
import edu.neu.msd.plagiarismdetector.service.EmailServiceImpl;

/**
 * The class tests the E-mail service
 * @author frenia
 *
 */
public class EmailServiceTests {
	
	EmailService email = new EmailServiceImpl();	
	
	@Test
	public void testEmailWithNullAddress() {
		int checker =0;
		try {
			email.sendMessage(null, "Test e-mail", "This is a test email");
		}
		catch(Exception e) {
			checker =1;
		}
		
		assertEquals(1,checker);
	}

}