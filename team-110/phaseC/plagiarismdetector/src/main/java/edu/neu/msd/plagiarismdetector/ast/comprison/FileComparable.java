package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.io.File;

/**
 * Basic structure for comparing 2 codes for similarity
 * 
 * @author vaibhavshukla
 *
 */
public interface FileComparable {

	/**
	 * Method to compare similarity between 2 files
	 * 
	 * @param file1
	 * @param file2
	 * @return
	 */
	public  float compare(File file1, File file2);
}
