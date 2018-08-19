package edu.neu.msd.plagiarismDetector;

import java.util.List;

/**
 * 
 * to create tree from nodes for plagiarism comparison
 *
 */
public interface Tree {

	/**
	 * @return list of Node
	 */
	public List<Node> getNodes();
	/**
	 * @param nd
	 */
	public void setNode(List<Node> nd);
	
}
