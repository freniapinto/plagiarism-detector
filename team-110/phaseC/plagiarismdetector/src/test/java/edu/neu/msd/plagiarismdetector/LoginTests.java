package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.neu.msd.plagiarismdetector.model.User;

public class LoginTests {
	@Test
	public void testUser() {
		User u = new User();
		u.setUsername("test");
		u.setPassword("123");
		u.setId(122L);
		assertEquals("test",u.getUsername());
		assertEquals(122L, u.getId().longValue());
	}
	
	@Test
	public void testPassword() {
		User u = new User();
		u.setUsername("test123");
		u.setPassword("123");
		assertEquals("123",u.getPassword());
		
		u.setEmailAddress("test@gmail.com");
		assertEquals("test@gmail.com", u.getemailAddress());
		
		u.setPosition("Instructor");
		assertEquals("Instructor", u.getPosition());
	}
	
	@Test
	public void testPassConfirm() {
		User u = new User();
		u.setUsername("123test");
		u.setPasswordConfirm("9875");
		assertEquals("9875",u.getPasswordConfirm());
	}
	
	

}
