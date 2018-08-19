package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import edu.neu.msd.plagiarismdetector.ast.ParserFacade;
import edu.neu.msd.plagiarismdetector.ast.comprison.MinModificationComparison;

/**
 * 
 * Added test cases for comparison strategy min modification
 * 
 * @author vaibhavshukla
 *
 */
public class MinModificationComparisonTests {

	@Test
	public void compareTreeforPythonFilesSimilar() throws IOException {
		int minDiff = 0;
		ParserFacade pF = new ParserFacade();
		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parse(python3File1);
			String file2ASTResp = pF.parse(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(0, minDiff);
	}

	@Test
	public void compareTreeforPythonFilesSame() throws IOException {
		int minDiff = 0;
		ParserFacade pF = new ParserFacade();
		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parse(python3File1);
			String file2ASTResp = pF.parse(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(0, minDiff);
	}

	@Test
	public void compareTreeforPythonFilesDifferent() throws IOException {
		int minDiff = 0;
		ParserFacade pF = new ParserFacade();

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parse(python3File1);
			String file2ASTResp = pF.parse(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(152, minDiff);
	}

	@Test
	public void compareSimilarFilesEditDistance() throws IOException {

		int minDiff = 0;
		ParserFacade pF = new ParserFacade();

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parseFileString(python3File1);
			String file2ASTResp = pF.parseFileString(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(134, minDiff,200);
	}

	@Test
	public void compareSameFilesEditDistance() throws IOException {

		int minDiff = 0;
		ParserFacade pF = new ParserFacade();

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parseFileString(python3File1);
			String file2ASTResp = pF.parseFileString(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(0, minDiff);
	}

	@Test
	public void compareDifferentFilesEditDistance() throws IOException {
		int minDiff = 0;
		ParserFacade pF = new ParserFacade();

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		if (python3File1.exists() && python3File2.exists()) {
			String file1ASTResp = pF.parseFileString(python3File1);
			String file2ASTResp = pF.parseFileString(python3File2);
			minDiff = MinModificationComparison.minDistance(file1ASTResp, file2ASTResp);

		}

		assertEquals(6917, minDiff,200);
	}
}