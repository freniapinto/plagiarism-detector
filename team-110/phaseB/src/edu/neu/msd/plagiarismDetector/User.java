package edu.neu.msd.plagiarismDetector;

/**
 * 
 * abstraction of various users of the system.
 *
 */
public interface User {
	
	/**
	 * @return String
	 */
	public String inputEmail();
	
	/**
	 * @return String
	 */
	public String inputUserName();
	
	/**
	 * @return String
	 */
	public String inputPassword();
	
	/**
	 * @return String
	 */
	public String inputRole() ;

}
