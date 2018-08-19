package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.neu.msd.plagiarismdetector.ast.ParserFacade;

/**
 * Class that compares all the similar blocks and finds the longest similar
 * block and give plagiarism percentage on the basis of the longest similar code
 * found
 * 
 * @author vaibhavshukla
 *
 */
public class SimilarCodeComparison implements FileComparable {
	
	private static final Logger logger = Logger.getLogger(SimilarCodeComparison.class);
	
	@Override
	/**
	 * @param File File
	 */
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
				minDiff = lcs(file1ASTResp.toCharArray(), file2ASTResp.toCharArray(),file1ASTResp.toCharArray().length,file2ASTResp.toCharArray().length);
			} catch (IOException e) {
				logger.log(Level.ERROR,e.getMessage());
			}		

		}
		return ((minDiff/maxValue)*100);
	}
	
	
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	/**
	 * 
	 * @param charSequence1
	 * @param charSequence2
	 * @param m
	 * @param n
	 * @return
	 */
	  public int lcs( char[] charSequence1, char[] charSequence2, int m, int n )
	  {
	    int[][] dp = new int[m+1][n+1];
	 
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++)
	    {
	      for (int j=0; j<=n; j++)
	      {
	        if (i == 0 || j == 0)
	            dp[i][j] = 0;
	        else if (charSequence1[i-1] == charSequence2[j-1])
	            dp[i][j] = dp[i-1][j-1] + 1;
	        else
	            dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
	      }
	    }
	  return dp[m][n]; 
	  }
	 
	  
	  /* Utility function to get max of 2 integers */
	  /**
	   * 
	   * @param a
	   * @param b
	   * @return
	   */
	  public int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }
	  
	
}
