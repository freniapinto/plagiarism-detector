package edu.neu.msd.plagiarismDetector;

import java.util.Date;

public class File {
	Date timeSTamp;
	AbstractSyntaxTree ast;
	
	StringBuilder fileContents;
	
	/**
	 * @param fileContents
	 * @return
	 */
	public AbstractSyntaxTree createAST(StringBuilder fileContents)
	{
		return ast;
	}
	
}
