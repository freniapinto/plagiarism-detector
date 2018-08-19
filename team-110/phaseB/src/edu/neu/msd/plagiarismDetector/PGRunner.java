package edu.neu.msd.plagiarismDetector;

import java.util.List;
import java.util.Map;

public class PGRunner {
	

	private Map<String, List<AbstractSyntaxTree>> mPairs;

	private ReportManager mReportManager;

	private PGComparator mPGComparator;

	/**
	 * @param mSubmissions
	 * @return
	 */
	private Map<String, List<AbstractSyntaxTree>> createASTMap(List<Submission> mSubmissions) {
		return mPairs;
	}

	/**
	 * @return
	 */
	public Report createReport() {
		return mReportManager.generateReport();
	}

	/**
	 * 
	 */
	public void compare() {
		AbstractSyntaxTree ast1 = new AbstractSyntaxTree();
		AbstractSyntaxTree ast2 = new AbstractSyntaxTree();
		Report r1 = mPGComparator.compareStructure(ast1, ast2);
		Report r2 = mPGComparator.compareFunctionBody(ast1, ast2);
		Report r3 = mPGComparator.compareVariables(ast1, ast2);

		mPGComparator.combineReports(r1, r2, r3);

	}
}
