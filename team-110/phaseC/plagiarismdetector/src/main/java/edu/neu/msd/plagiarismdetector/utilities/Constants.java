package edu.neu.msd.plagiarismdetector.utilities;

/**
 * Holds all the constants used in the project
 * 
 * @author vaibhavshukla
 *
 */
public class Constants {

	
	public enum COMPARISON_STRATEGIES {
		STRATEGY_LCS, STRATEGY_EDIT_DISTANCE, STRATEGY_COSINE_SIMILARITY
	}

	public static final float HIGH_PLAGIARISM_THRESHOLD = 75;

	public static final float MEDIUM_PLAGIARISM_THRESHOLD = 30;

	public static final String HIGH_PLAGIARISED = "highlyPlagiarised";

	public static final String MEDIUM_PLAGIARISED = "mediumPlagiarised";

	public static final String LOW_PLAGIARISED = "lowPlagiarised";
	
	public static final String ENCODING_TYPE = "UTF-8";
	
	public static final String EMAIL_ADDRESS = "pgdetector110@gmail.com";
	

}
