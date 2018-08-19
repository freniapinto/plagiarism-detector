package edu.neu.msd.plagiarismDetector;

import java.util.List;

/**
 * @author VAIBHAV
 *
 */
/**
 * @author VAIBHAV
 *
 */
public class Instructor implements Authentication,User {
	List<Submission> sub;
	ReportManager rm;
	PlagiarismDetector pd;
	String emailId;
	String userName;
	String password;
	String role;
	
	/* (non-Javadoc)
	 * @see userSubmission.Authentication#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String userName,String password) {
		
		return true;
	}

	/* (non-Javadoc)
	 * @see userSubmission.Authentication#forgotPassword(java.lang.String)
	 */
	@Override
	public void forgotPassword(String emailId) {
		

	}
	
	
	
	
	/**
	 * @param s
	 */
	public void uploadSubmission(Submission s)
	{
		
	}
	
	/**
	 * @param s
	 */
	public void deleteSubmission(Submission s)
	{
		
	}
	
	/**
	 * @param s
	 */
	public void filterSubmission(Submission s)
	{
		
	}

	/**
	 * @param sub
	 */
	public void runPlagiarismDetector(List<Submission> sub)
	{
		
	}
	
	
	public void cancelPlagiarismDetector()
	{
		
	}
	
	/**
	 * @param r
	 */
	public void viewReport(Report r)
	{
		
	}
	
	/**
	 * @param r
	 */
	public void deleteReport(Report r)
	{
		
	}
	
	/**
	 * @param r
	 */
	public void downloadReport(Report r)
	{
		
	}

	/* (non-Javadoc)
	 * @see userSubmission.User#inputEmail()
	 */
	@Override
	public String inputEmail() {
		
		return this.emailId;
	}

	/* (non-Javadoc)
	 * @see userSubmission.User#inputUserName()
	 */
	@Override
	public String inputUserName() {
		
		return this.userName;
	}

	/* (non-Javadoc)
	 * @see userSubmission.User#inputPassword()
	 */
	@Override
	public String inputPassword() {
		return this.password;
	}

	/* (non-Javadoc)
	 * @see userSubmission.User#inputRole()
	 */
	@Override
	public String inputRole() {
		return this.role;
	}
	
	
	
}
