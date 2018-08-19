package edu.neu.msd.plagiarismDetector;

import java.util.List;

public class Admin implements Authentication,User {
	
	
	String userId;
	String emailId;
	String userName;
	String password;
	String role;
	
	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Authentication#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String userName,String password) {
		
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Authentication#forgotPassword(java.lang.String)
	 */
	@Override
	public void forgotPassword(String emailId) {
		
	}
	
	
	/**
	 * @param emailList
	 * @return
	 */
	public boolean createAccounts(List<String> emailList)
	{
		return true;
	}
	
	/**
	 * @param emailList
	 * @return
	 */
	public boolean deleteAccount(List<String> emailList)
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.User#inputUserName()
	 */
	@Override
	public String inputUserName() {
		
		return this.userName;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.User#inputPassword()
	 */
	@Override
	public String inputPassword() {
		
		return this.password;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.User#inputRole()
	 */
	@Override
	public String inputRole() {
		
		return this.role;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.User#inputEmail()
	 */
	@Override
	public String inputEmail() {
	return this.emailId;
	}
	

}
