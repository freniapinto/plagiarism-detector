package edu.neu.msd.plagiarismdetector.model;

import java.io.File;
import java.util.Map;

import edu.neu.msd.plagiarismdetector.utilities.Constants;
import edu.neu.msd.plagiarismdetector.utilities.Constants.COMPARISON_STRATEGIES;

/**
 * Class holds the results obtained from the comparison strategies applied
 * 
 * @author vaibhavshukla
 *
 */
public class Report {

	File f1;
	File f2;
	Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults;
	float totalScore;
	String plagiarismLevel;
	String file1HighlightedCode;
	String file2HighlightedCode;

	public String getFile1HighlightedCode() {
		return file1HighlightedCode;
	}

	public void setFile1HighlightedCode(String file1HighlightedCode) {
		this.file1HighlightedCode = file1HighlightedCode;
	}

	public String getFile2HighlightedCode() {
		return file2HighlightedCode;
	}

	public void setFile2HighlightedCode(String file2HighlightedCode) {
		this.file2HighlightedCode = file2HighlightedCode;
	}

	public String getPlagiarismLevel() {
		return plagiarismLevel;
	}

	public void setPlagiarismLevel(String plagiarismLevel) {
		this.plagiarismLevel = plagiarismLevel;
	}

	public Report(File f1, File f2, Map<COMPARISON_STRATEGIES, Float> comparisonResults, float totalScore) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.comparisonResults = comparisonResults;
		this.totalScore = totalScore;
	}

	public Report() {
	}

	public File getF1() {
		return f1;
	}

	public void setF1(File f1) {
		this.f1 = f1;
	}

	public File getF2() {
		return f2;
	}

	public void setF2(File f2) {
		this.f2 = f2;
	}

	public Map<Constants.COMPARISON_STRATEGIES, Float> getComparisonResults() {
		return comparisonResults;
	}

	public void setComparisonResults(Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults) {
		this.comparisonResults = comparisonResults;
	}

	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

}
