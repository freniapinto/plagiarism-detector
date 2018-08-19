package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import edu.neu.msd.plagiarismdetector.ast.comprison.SimilarCodeComparison;

/**
 * 
 * Added test cases for comparison strategy min modification
 * 
 * @author vaibhavshukla
 *
 */
public class SimilarCodeComparisonTests {

	@Test
	public void compareTreeforPythonFilesSimilar() throws IOException {
		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(100.0F, similarity,0.05f);
	}

	@Test
	public void compareTreeforPythonFilesSame() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(100.0F, similarity,0.05f);
	}

	@Test
	public void compareTreeforPythonFilesDifferent() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(0.0F, similarity,0.05f);
	}

	@Test
	public void compareSimilarFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(100.0F, similarity,0.05f);
	}

	@Test
	public void compareSameFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(100.0F, similarity,0.05f);
	}

	@Test
	public void compareDifferentFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		SimilarCodeComparison sCode = new SimilarCodeComparison();
		float similarity = sCode.compare(python3File1, python3File2);
		assertEquals(0.0F, similarity,0.05f);
	}
}