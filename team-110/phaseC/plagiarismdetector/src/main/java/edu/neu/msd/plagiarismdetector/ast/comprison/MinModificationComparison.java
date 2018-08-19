package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.neu.msd.plagiarismdetector.ast.ParserFacade;

/**
 * CLass that holds the comparisons strategies to compare python files
 *
 * @author vaibhavshukla
 */
public class MinModificationComparison implements FileComparable {
	
	private static final Logger logger = Logger.getLogger(MinModificationComparison.class);
	
	/**
	 * Private constructor
	 */
	public MinModificationComparison() {
		super();
	}

	/**
	 * Method to comapre 2 files using edit distance i.e the minimum number of
	 * modifications required for building file 2 from file 1
	 * @throws IOException 
	 */
	@Override
	public float compare(File file1, File file2) {
		int minDiff=0;
		int maxValue =1;
		if (file1.exists() && file2.exists()) {
			ParserFacade pF = new ParserFacade();
			String file1ASTResp;
			String file2ASTResp;
			try {
				file1ASTResp = pF.parse(file1);
				file2ASTResp = pF.parse(file2);
				maxValue = Math.max(file1ASTResp.length(), file2ASTResp.length());
				minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);
			} catch (IOException e) {
				logger.log(Level.ERROR,e.getMessage());
			}		

		}
		return (((maxValue-minDiff)/maxValue)*100);
	}
	
	
	/**
	 * Method to calculate the edit distance between 2 strings
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}

	

}
