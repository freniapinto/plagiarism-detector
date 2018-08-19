package edu.neu.msd.plagiarismdetector;

import java.io.File;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import edu.neu.msd.plagiarismdetector.ast.comprison.CodeShiftComparison;
import edu.neu.msd.plagiarismdetector.ast.comprison.FetchCommonSubString;
import edu.neu.msd.plagiarismdetector.ast.comprison.FileComparable;
import edu.neu.msd.plagiarismdetector.ast.comprison.MinModificationComparison;
import edu.neu.msd.plagiarismdetector.ast.comprison.SimilarCodeComparison;
import edu.neu.msd.plagiarismdetector.ast.comprison.WeightedScore;
import edu.neu.msd.plagiarismdetector.model.Report;
import edu.neu.msd.plagiarismdetector.utilities.Constants;

/**
 * 
 * Class to handle running the plagiarism detection system to find similarity
 * between all the submissions
 * 
 * @author vaibhavshukla
 *
 */
public class PGRunner {

	List<Report> mComparisonReportList;
	List<File> mFilesToCompare;
	List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies;

	/**
	 * Cosntrcutor which takes in the list of files to be compared
	 * 
	 * @param mFilesToCompare
	 */
	public PGRunner(List<File> mFilesToCompare, List<Constants.COMPARISON_STRATEGIES> strategies) {
		super();
		this.mFilesToCompare = mFilesToCompare;
		this.mComparisonStrategies = strategies;
		mComparisonReportList = new ArrayList<>();
	}

	/**
	 * Method run to run the plagiarism detector system on the submissions and get
	 * the similarity percentage
	 * 
	 * @return
	 */
	public List<Report> run() {
		for (int i = 0; i < mFilesToCompare.size(); i++) {
			for (int j = i + 1; j < mFilesToCompare.size(); j++) {
				File file1 = mFilesToCompare.get(i);
				File file2 = mFilesToCompare.get(j);
				mComparisonReportList.add(generateComparisonReport(file1, file2));
			}
		}
		return mComparisonReportList;
	}

	/**
	 * Generate a detailed report of individual file comparison
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public Report generateComparisonReport(File f1, File f2) {

		Report comparisonReport = new Report();

		comparisonReport.setF1(f1);
		comparisonReport.setF2(f2);

		Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults = applyComparisonStrategies(f1, f2);

		comparisonReport.setComparisonResults(comparisonResults);
		float weightedScore = computeWeightedScore(comparisonResults);
		comparisonReport.setTotalScore(weightedScore);
		List<String> highLightedPlagarisedCodeFiles = FetchCommonSubString.getHighLightedFiles(f1, f2);
		comparisonReport.setFile1HighlightedCode(highLightedPlagarisedCodeFiles.get(0));
		comparisonReport.setFile2HighlightedCode(highLightedPlagarisedCodeFiles.get(1));
		comparisonReport.setPlagiarismLevel(computePlagiarismLevel(weightedScore));
		return comparisonReport;

	}

	/**
	 * METHOD that applies all the comparison strategies to get a score on
	 * comparison on files through each strategy and store the result
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public Map<Constants.COMPARISON_STRATEGIES, Float> applyComparisonStrategies(File f1, File f2) {
		Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults = new EnumMap<>(
				Constants.COMPARISON_STRATEGIES.class);
  
		if (mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE)) {
			FileComparable cM = new MinModificationComparison();
			float minModificationScore = cM.compare(f1, f2);
			comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE, minModificationScore);
		}

		if (mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS)) {
			FileComparable cS = new SimilarCodeComparison();
			float similarCodeComparisonScore = cS.compare(f1, f2);
			comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS, similarCodeComparisonScore);
		}
		if (mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY)) {
			FileComparable cSC = new CodeShiftComparison();
			float codeShiftComparisonScore = cSC.compare(f1, f2);
			comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY, codeShiftComparisonScore);
		}
		return comparisonResults;
	}

	/**
	 * Method to compute the weighted average of all the strategies used
	 * 
	 * @param comparisonResults
	 * @return
	 */
	public float computeWeightedScore(Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults) {
		WeightedScore wS = new WeightedScore(comparisonResults,mComparisonStrategies);
		return wS.compute(comparisonResults);
	}

	/**
	 * Method to compute the plagiarism level for comparison and see if the
	 * submissions are highly plagiarised
	 * 
	 * @param score
	 * @return
	 */
	public String computePlagiarismLevel(float score) {
		String plagiarismLevel = Constants.LOW_PLAGIARISED;

		if (score >= Constants.HIGH_PLAGIARISM_THRESHOLD)
			plagiarismLevel = Constants.HIGH_PLAGIARISED;
		else if (score >= Constants.MEDIUM_PLAGIARISM_THRESHOLD)
			plagiarismLevel = Constants.MEDIUM_PLAGIARISED;

		return plagiarismLevel;
	}

}
