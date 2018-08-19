package edu.neu.msd.plagiarismDetector;

import java.util.List;

public class AbstractSyntaxTree implements Tree{
	List<Node> nd;

	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Tree#getNodes()
	 */
	@Override
	public List<Node> getNodes() {
		
		return nd;
	}

	
	/* (non-Javadoc)
	 * @see edu.neu.msd.plagiarismDetector.Tree#setNode(java.util.List)
	 */
	@Override
	public void setNode(List<Node> nd) {
		
		
	}
	
	
}
