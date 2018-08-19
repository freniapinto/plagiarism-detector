package edu.neu.msd.plagiarismDetector;

import java.util.List;

public class PlagiarismDetector {

	
	private static PlagiarismDetector mPlagiarismDetectorInstance;

	private List<Submission> mSubmissions;
	
	private List<Report> mReports;

	
	public static PlagiarismDetector getInstance() {
		if (mPlagiarismDetectorInstance == null)
			mPlagiarismDetectorInstance = new PlagiarismDetector();

		return mPlagiarismDetectorInstance;
	}

	private PlagiarismDetector() {
	}

	/**
	 * @param submissions
	 * @return
	 */
	public boolean runPlagiarismDetector(List<Submission> submissions) {
		return true;
	}

	
	public boolean stopPlagiarismDetector() {
		return true;
	}

}
