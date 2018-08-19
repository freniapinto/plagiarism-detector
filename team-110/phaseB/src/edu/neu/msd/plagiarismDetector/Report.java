package edu.neu.msd.plagiarismDetector;

import java.util.Map;

/**
 * 
 * class for individual reports
 *
 */
public class Report {

	private Map<Integer,Integer> mCommonLiens;
	private String mStructureMatch;
	private int mTotalPercentMatch;
	private String mFlag;
	/**
	 * @return the mCommonLiens
	 */
	public Map<Integer, Integer> getmCommonLiens() {
		return mCommonLiens;
	}
	/**
	 * @param mCommonLiens the mCommonLiens to set
	 */
	public void setmCommonLiens(Map<Integer, Integer> mCommonLiens) {
		this.mCommonLiens = mCommonLiens;
	}
	/**
	 * @return the mStructureMatch
	 */
	public String getmStructureMatch() {
		return mStructureMatch;
	}
	/**
	 * @param mStructureMatch the mStructureMatch to set
	 */
	public void setmStructureMatch(String mStructureMatch) {
		this.mStructureMatch = mStructureMatch;
	}
	/**
	 * @return the mTotalPercentMatch
	 */
	public int getmTotalPercentMatch() {
		return mTotalPercentMatch;
	}
	/**
	 * @param mTotalPercentMatch the mTotalPercentMatch to set
	 */
	public void setmTotalPercentMatch(int mTotalPercentMatch) {
		this.mTotalPercentMatch = mTotalPercentMatch;
	}
	/**
	 * @return the mFlag
	 */
	public String getmFlag() {
		return mFlag;
	}
	/**
	 * @param mFlag the mFlag to set
	 */
	public void setmFlag(String mFlag) {
		this.mFlag = mFlag;
	}
	
	
	
	
}
