package edu.neu.msd.plagiarismDetector;

/**
 * 
 * Comparator is used to compare two ASTs and provide results
 *
 */
public interface Comparator {
	
	/**
	 * Compares the structure of two AST.
	 * @param ast1
	 * @param ast2
	 * @return a Report
	 */
	public Report compareStructure(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2);

	/**
	 * compares the variables names of two ASTs
	 * @param ast1
	 * @param ast2
	 * @return Report
	 */
	public Report compareVariables(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2);
	
	/**
	 * Compares functional breakdown of two ASTs
	 * @param ast1
	 * @param ast2
	 * @return Report
	 */
	public Report compareFunctionBody(AbstractSyntaxTree ast1, AbstractSyntaxTree ast2);

}
