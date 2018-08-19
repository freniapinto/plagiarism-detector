package edu.neu.msd.plagiarismDetector;

/**
 * 
 * Authenticates the login credentials
 *
 */
public interface Authentication {
	
	// returns true if login is successful
	/**
	 * @param username
	 * @param password
	 * @return true on successful logins
	 */
	public boolean login(String username, String password); 
	
	/**
	 * Sends a backup password to reset the user's password
	 * @param emailId
	 */
	public void forgotPassword(String emailId);
	

}
