package edu.neu.msd.plagiarismDetector;

public class PGComparator implements Comparator {
	private Report report1;

	private Report report2;

	private Report report3;

	private Report report;

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Comparator#compareStructure(edu.neu.msd.plagiarismDetector.AbstractSyntaxTree, edu.neu.msd.plagiarismDetector.AbstractSyntaxTree)
	 */
	@Override
	public Report compareStructure(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2) {

		return report1;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Comparator#compareVariables(edu.neu.msd.plagiarismDetector.AbstractSyntaxTree, edu.neu.msd.plagiarismDetector.AbstractSyntaxTree)
	 */
	@Override
	public Report compareVariables(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2) {

		return report2;
	}

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Comparator#compareFunctionBody(edu.neu.msd.plagiarismDetector.AbstractSyntaxTree, edu.neu.msd.plagiarismDetector.AbstractSyntaxTree)
	 */
	@Override
	public Report compareFunctionBody(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2) {

		return report3;
	}

	/**
	 * @param report1
	 * @param report2
	 * @param report3
	 * @return
	 */
	public Report combineReports(Report report1, Report report2, Report report3) {
		return report;
	}

}
